package org.example.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;
import mvvm.bindings.Bind;
import mvvm.bindings.Binder;
import mvvm.bindings.BindingType;
import org.example.viewmodel.MedicViewModel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import static org.example.utils.ExtensionFunctions.logDebug;

public class MedicForm {

    private final MedicViewModel medicViewModel;
    @Getter
    private JPanel panel1;
    private JTextArea vizualizareFiseMedicaleTextArea;
    @Bind(value = "text", target = "IDFisaMedicalaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField IDFisaMedicalaTextField;
    @Bind(value = "text", target = "symptomsTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField symptomsTextField;
    @Bind(value = "text", target = "diagnostictextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField diagnostictextField;
    @Bind(value = "text", target = "treatmentTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField treatmentTextField;
    private JButton vizalizareFiseMedicaleButton;
    private JButton actualizareFisaButton;
    @Bind(value = "model", target = "diagnosticComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox diagnosticComboBox;
    private JTextArea filtrareDiagnosticTtextArea;
    @Bind(value = "model", target = "treatmentComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox treatmentComboBox;
    private JTextArea filtrareTreatmentTextArea;
    @Bind(value = "text", target = "cautareNumePacientTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField cautareNumePacientTextField;
    private JTextArea afisarePacientNumeTextArea;
    @Bind(value = "text", target = "startHourMedicTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField startHourMedicTextField;
    @Bind(value = "text", target = "endDourMedicTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField endDourMedicTextField;
    private JButton timetableButton;
    private JTextArea vizualizareConsultatiiTextArea;
    private JButton consultatiiButton;
    private JButton logOutButton;
    private JButton cautareButton;

    public MedicForm() {
        medicViewModel = new MedicViewModel(this);

        try {
            Binder.bind(this, medicViewModel);
        } catch (Exception e) {
            logDebug("--MedicForm Constructor--" + e);
        }


        vizalizareFiseMedicaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicViewModel.viewAllMedicalRecordsCommand.execute();
            }
        });


        actualizareFisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicViewModel.updateMedicalRecordComand.execute();

            }
        });
        cautareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicViewModel.searchPatientByNameCommand.execute();
            }
        });
        timetableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicViewModel.setTimetableCommand.execute();
            }
        });
        consultatiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicViewModel.viewAllConsultationsCommand.execute();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicViewModel.logOutCommand.execute();
            }
        });

        diagnosticComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) e.getItem();
                    medicViewModel.setSelectedFilterDiagnostic(selected);
                    medicViewModel.filterByDiagnostic.execute();

                }
            }
        });
        treatmentComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) e.getItem();
                    medicViewModel.setSelectedFilterTreatment(selected);
                    medicViewModel.filterByTreatment.execute();
                }
            }
        });
    }

    public JTextArea getVizualizareFiseMedicaleTextArea() {
        return vizualizareFiseMedicaleTextArea;
    }

    public JTextArea getAfisarePacientNumeTextArea() {
        return afisarePacientNumeTextArea;
    }

    public JTextArea getVizualizareConsultatiiTextArea() {
        return vizualizareConsultatiiTextArea;
    }

    public JTextArea getFiltrareTreatmentTextArea() {
        return filtrareTreatmentTextArea;
    }

    public JTextArea getFiltrareDiagnosticTtextArea() {
        return filtrareDiagnosticTtextArea;
    }

    public void populateTreatmentComboBox() {
        medicViewModel.populateTreatmentComboBox.execute();
    }

    public void populateDiagnosticComboBoz() {
        medicViewModel.populateDiagnosticComboBox.execute();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-2252579));
        panel1.setForeground(new Color(-2252579));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(15, 6, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-2395946));
        panel1.add(panel2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Vizualizare fise medicale");
        panel2.add(label1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vizualizareFiseMedicaleTextArea = new JTextArea();
        panel2.add(vizualizareFiseMedicaleTextArea, new GridConstraints(4, 0, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Actualizare fise medicale");
        panel2.add(label2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("ID Fisa Medicala");
        panel2.add(label3, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        IDFisaMedicalaTextField = new JTextField();
        panel2.add(IDFisaMedicalaTextField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Simptome");
        panel2.add(label4, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        symptomsTextField = new JTextField();
        panel2.add(symptomsTextField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Diagnostic");
        panel2.add(label5, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        diagnostictextField = new JTextField();
        panel2.add(diagnostictextField, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Tratament");
        panel2.add(label6, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        treatmentTextField = new JTextField();
        panel2.add(treatmentTextField, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Filtrare pacienti");
        panel2.add(label7, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Diagnostic");
        panel2.add(label8, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        diagnosticComboBox = new JComboBox();
        diagnosticComboBox.setBackground(new Color(-2252579));
        panel2.add(diagnosticComboBox, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filtrareDiagnosticTtextArea = new JTextArea();
        filtrareDiagnosticTtextArea.setText("");
        panel2.add(filtrareDiagnosticTtextArea, new GridConstraints(6, 2, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        filtrareTreatmentTextArea = new JTextArea();
        panel2.add(filtrareTreatmentTextArea, new GridConstraints(11, 2, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        treatmentComboBox = new JComboBox();
        treatmentComboBox.setBackground(new Color(-2252579));
        panel2.add(treatmentComboBox, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Tratament");
        panel2.add(label9, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Cautare Pacient");
        panel2.add(label10, new GridConstraints(2, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Nume pacient");
        panel2.add(label11, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cautareNumePacientTextField = new JTextField();
        panel2.add(cautareNumePacientTextField, new GridConstraints(4, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        afisarePacientNumeTextArea = new JTextArea();
        panel2.add(afisarePacientNumeTextArea, new GridConstraints(6, 3, 3, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Program de Lucru");
        panel2.add(label12, new GridConstraints(9, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Ora incepere");
        panel2.add(label13, new GridConstraints(10, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startHourMedicTextField = new JTextField();
        panel2.add(startHourMedicTextField, new GridConstraints(11, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("Ora final");
        panel2.add(label14, new GridConstraints(12, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        endDourMedicTextField = new JTextField();
        panel2.add(endDourMedicTextField, new GridConstraints(13, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        timetableButton = new JButton();
        timetableButton.setBackground(new Color(-2252579));
        timetableButton.setText("Introducere");
        panel2.add(timetableButton, new GridConstraints(14, 3, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vizalizareFiseMedicaleButton = new JButton();
        vizalizareFiseMedicaleButton.setBackground(new Color(-2252579));
        vizalizareFiseMedicaleButton.setText("Vizalizare");
        panel2.add(vizalizareFiseMedicaleButton, new GridConstraints(14, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        actualizareFisaButton = new JButton();
        actualizareFisaButton.setBackground(new Color(-2252579));
        actualizareFisaButton.setText("Actualizare");
        panel2.add(actualizareFisaButton, new GridConstraints(14, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("Program Consultatii");
        panel2.add(label15, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vizualizareConsultatiiTextArea = new JTextArea();
        panel2.add(vizualizareConsultatiiTextArea, new GridConstraints(4, 5, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label16 = new JLabel();
        Font label16Font = this.$$$getFont$$$("Castellar", Font.BOLD, 22, label16.getFont());
        if (label16Font != null) label16.setFont(label16Font);
        label16.setForeground(new Color(-13893586));
        label16.setText("MEDIC");
        panel2.add(label16, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logOutButton = new JButton();
        logOutButton.setBackground(new Color(-2252579));
        logOutButton.setText("Log Out");
        panel2.add(logOutButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setIcon(new ImageIcon(getClass().getResource("/images/doctor.png")));
        label17.setText("");
        panel2.add(label17, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        consultatiiButton = new JButton();
        consultatiiButton.setBackground(new Color(-2252579));
        consultatiiButton.setText("Vizualizare");
        panel2.add(consultatiiButton, new GridConstraints(14, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cautareButton = new JButton();
        cautareButton.setBackground(new Color(-2252579));
        cautareButton.setText("Cautare");
        panel2.add(cautareButton, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel1.add(spacer3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel1.add(spacer4, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
