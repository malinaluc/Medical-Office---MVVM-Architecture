/*
 * Copyright 2020 Serge de Schaetzen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.sds.mvvm.bindings;

import static net.sds.mvvm.utils.ReflectionUtils.getField;
import static net.sds.mvvm.utils.ReflectionUtils.resolvePath;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import net.sds.mvvm.properties.Property;

public class ValueConsumerFactory {
  private static final List<ConsumerRegistrator> registrators = new ArrayList<>();
  private ValueConsumerFactory() {}

  /**
   * Creates a ValueConsumer using the given source and path. If no predefined consumer is found, a
   * Reflection one is created and returned.
   * @param source The source.
   * @param path The path.
   * @param <T>
   * @return The ValueConsumer.
   */
  public static <T> ValueConsumer<T> create(Object source, String path) throws BindingException {
    for (ConsumerRegistrator registrator : registrators) {
      if (registrator.predicate.test(source, path)) {
        return registrator.factory.apply(source, path);
      }
    }
    return getConsumer(source, path);
  }

  /**
   * Returns a ValueSupplier for the path specified. The path can point to nested fields/methods of the object given using a '.' delimited path.
   * Methods referenced in the path should have 0 parameters. If no supplier could be found a BindingException is thrown.
   *
   * @param object The object to parse.
   * @param path The path to use.
   * @return The supplier.
   */
  private static ValueConsumer getConsumer(Object object, String path) throws BindingException {
    Optional<ValueConsumer> supplier = getMethodConsumer(object, path);
    if (supplier.isPresent()) {
      return supplier.get();
    }

    supplier = getFieldConsumer(object, path);
    if (supplier.isPresent()) {
      return supplier.get();
    }

    throw new BindingException(String.format("Could not find a ValueProvider for path %s in class %s", path, object.getClass().getName()));
  }

  /**
   * Returns a ValueConsumer using the method with the name specified.
   * @param owner
   * @param name
   * @return
   */
  private static Optional<ValueConsumer> getMethodConsumer(final Object owner, String name) {
    Method method = null;
    Class<?> cl = owner.getClass();
    while (method == null && cl != null) {
      for (Method m : cl.getMethods()) {
        if (m.getName().equals(name) && m.getParameterCount() == 1) {
          method = m;
          break;
        }
      }
      cl = cl.getSuperclass();
    }

    if (method != null) {
      final Method m = method;
      return Optional.of(o -> {
        try {
          m.invoke(owner, o);
        } catch (ReflectiveOperationException e) {
          throw new BindingValueException(String.format("Could not set the value %s using method %s!", o, m.getName()));
        }
      });
    }
    return Optional.empty();
  }

  private static Optional<ValueConsumer> getFieldConsumer(final Object owner, String name) {
    Optional<Field> field = getField(owner.getClass(), name);
    if (field.isPresent()) {
      final Field f = field.get();
      if (!f.isAccessible()) {
        f.setAccessible(true);
      }
      return Optional.of(o -> {
        try {
          f.set(owner, o);
        } catch (ReflectiveOperationException e) {
          throw new BindingValueException(String.format("Could not set the value %s using field %s!", o, f.getName()));
        }
      });
    }
    return Optional.empty();
  }

  static {
    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof Property && s.equals(Paths.VALUE)
        , (o, s) -> v -> ((Property) o).set(v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JTextComponent && s.equals(Paths.TEXT)
        , (o, s) -> v -> ((JTextComponent) o).setText(v != null ? v.toString() : null)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JTextComponent && s.equals(Paths.EDITABLE)
        , (o, s) -> v -> ((JTextComponent) o).setEditable((Boolean) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JLabel && s.equals(Paths.TEXT)
        , (o, s) -> v -> ((JLabel) o).setText(v != null ? v.toString() : null)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof Component && s.equals(Paths.ENABLED)
        , (o, s) -> v -> ((Component) o).setEnabled((Boolean) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof Component && s.equals(Paths.VISIBLE)
        , (o, s) -> v -> ((Component) o).setVisible((Boolean) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof Component && s.equals(Paths.FOREGROUND)
        , (o, s) -> v -> ((Component) o).setForeground((Color) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof Component && s.equals(Paths.BACKGROUND)
        , (o, s) -> v -> ((Component) o).setBackground((Color) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof Component && s.equals(Paths.FONT)
        , (o, s) -> v -> ((Component) o).setFont((Font) v)));
    
    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof AbstractButton && s.equals(Paths.SELECTED)
        , (o, s) -> v -> ((AbstractButton) o).setSelected((Boolean) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JComboBox && s.equals(Paths.SELECTED_ITEM)
        , (o, s) -> v -> ((JComboBox) o).setSelectedItem(v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JComboBox && s.equals(Paths.MODEL)
        , (o, s) -> v -> ((JComboBox) o).setModel((ComboBoxModel) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JList && s.equals(Paths.SELECTED_INDEX)
        , (o, s) -> v -> ((JList) o).setSelectedIndex((Integer) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JComboBox && s.equals(Paths.SELECTED_INDICES)
        , (o, s) -> v -> ((JList) o).setSelectedIndices((int[]) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JList && s.equals(Paths.MODEL)
        , (o, s) -> v -> ((JList) o).setModel((ListModel) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JTable && s.equals(Paths.MODEL)
        , (o, s) -> v -> ((JTable) o).setModel((TableModel) v)));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JTable && s.equals(Paths.SELECTED_ROW)
        , (o, s) -> v -> setSelectedRows((JTable) o, new Object[] {v})));

    registrators.add(new ConsumerRegistrator((o, s) -> o instanceof JTable && s.equals(Paths.SELECTED_ROWS)
        , (o, s) -> v -> setSelectedRows((JTable) o, (Object[]) v)));
  }

  private static void setSelectedRows(JTable table, Object[] rows) {
    List<Integer> viewRows = new ArrayList<>();
    for (int i = 0; i < rows.length; i++) {
      if (rows[i] == null || rows[i].toString().trim().length() == 0) {
        continue;
      }
      int row = rows[i] instanceof Integer ? (Integer) rows[i] : Integer.parseInt(rows[i].toString());
      viewRows.add(table.convertRowIndexToView(row));
    }
    if (viewRows.size() > 0) {
      table.getSelectionModel().setSelectionInterval(viewRows.get(0), viewRows.get(viewRows.size() - 1));
    } else {
      table.getSelectionModel().clearSelection();
    }
  }

  public static void registerConsumerFactory(BiPredicate<Object, String> predicate, BiFunction<Object, String, ValueConsumer> factory) {
    registerConsumerFactory(predicate, factory, -1);
  }

  public static void registerConsumerFactory(BiPredicate<Object, String> predicate, BiFunction<Object, String, ValueConsumer> factory, int index) {
    ConsumerRegistrator registrator = new ConsumerRegistrator(predicate, factory);
    if (index < 0) {
      registrators.add(registrator);
    } else {
      registrators.add(index, registrator);
    }
  }

  private static class ConsumerRegistrator {
    final private BiPredicate<Object, String> predicate;
    final private BiFunction<Object, String, ValueConsumer> factory;

    private ConsumerRegistrator(BiPredicate<Object, String> predicate, BiFunction<Object, String, ValueConsumer> factory) {
      this.predicate = predicate;
      this.factory = factory;
    }
  }
}
