package org.example.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import mvvm.bindings.Bind;
import mvvm.bindings.Binder;
import mvvm.bindings.BindingType;
import org.example.viewmodel.AsistentViewModel;

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

public class AsistentForm {

    private final AsistentViewModel asistentViewModel;
    private JPanel panel1;
    private JTextArea vizualizareFiseMedicaleTextArea;
    @Bind(value = "text", target = "updateIDFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateIDFisaTextField;
    @Bind(value = "text", target = "updateVarstaFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateVarstaFisaTextField;
    @Bind(value = "text", target = "updateMedicFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateMedicFisaTextField;
    @Bind(value = "text", target = "updateAsistentFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateAsistentFisaTextField;
    @Bind(value = "text", target = "creareDiagnosticFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField creareDiagnosticFisaTextField;
    @Bind(value = "text", target = "creareTratamentFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField creareTratamentFisaTextField;
    @Bind(value = "text", target = "creareSimptomeFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField creareSimptomeFisaTextField;
    @Bind(value = "text", target = "creareVarstaFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField creareVarstaFisaTextField;
    @Bind(value = "text", target = "creareMedicFisaTtextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField creareMedicFisaTtextField;
    @Bind(value = "text", target = "creareAsistentFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField creareAsistentFisaTextField;
    private JButton actualizareFisaButton;
    @Bind(value = "text", target = "stergereIDFisaTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField stergereIDFisaTextField;
    private JButton stergereButton;
    private JButton creareFisaButton;
    private JButton vizualizareFiseMedicaleButton;
    @Bind(value = "model", target = "filterMedicComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox filterMedicComboBox;
    private JTextArea filterMedicTextArea;
    @Bind(value = "model", target = "filterDiagnosticComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox filterDiagnosticComboBox;
    private JTextArea filterDiagnosticTextArea;
    private JTextArea filterVarstaTextArea;
    @Bind(value = "model", target = "filterVarstaComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox filterVarstaComboBox;
    @Bind(value = "text", target = "numeCautarePacientTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField numeCautarePacientTextField;
    private JButton cautarePacientButton;
    @Bind(value = "text", target = "startHourConsultationTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField startHourConsultationTextField;
    @Bind(value = "text", target = "endHourConsultationTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField endHourConsultationTextField;
    @Bind(value = "text", target = "namePacientConsultationTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField namePacientConsultationTextField;
    private JButton adaugareConsultatieButton;
    private JButton logOutButton;
    private JButton CSVButton;
    private JButton JSONButton;
    private JButton XMLButton;
    private JButton DOCButton;
    @Bind(value = "text", target = "patientNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField patientNameTextField; //creare fisa medicala
    @Bind(value = "text", target = "medicAddConsultTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField medicAddConsultTextField;
    private JTextArea searchPatientTextArea;

    public AsistentForm() {
        asistentViewModel = new AsistentViewModel(this);

        try {
            Binder.bind(this, asistentViewModel);
        } catch (Exception e) {
            logDebug("---AsistentForm Constructor---" + e);
        }


        vizualizareFiseMedicaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.viewAllMedicalRecords.execute();
            }
        });


        actualizareFisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.updateMedicalRecord.execute();
            }
        });
        stergereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.deleteMedicalRecord.execute();

            }
        });
        creareFisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.createMedicalRecord.execute();
            }
        });
        cautarePacientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.searchPatientByName.execute();
            }
        });
        adaugareConsultatieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.addConsultation.execute();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.logOutCommand.execute();
            }
        });
        CSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.exportCSVFile.execute();
            }
        });
        JSONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.exportJSONFile.execute();
            }
        });
        XMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.exportXMLFile.execute();
            }
        });
        DOCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentViewModel.exportDOCFile.execute();
            }
        });
        filterMedicComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) e.getItem();
                    asistentViewModel.setSelectedFilterMedic(selected);
                    asistentViewModel.filterByMedic.execute();

                }
            }
        });
        filterDiagnosticComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) e.getItem();
                    asistentViewModel.setSelectedFilterDiagnostic(selected);
                    asistentViewModel.filterByDiagnostic.execute();


                }
            }
        });
        filterVarstaComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) e.getItem();
                    asistentViewModel.setSelectedFilterVarsta(selected);
                    asistentViewModel.filterByVarsta.execute();


                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTextArea getVizualizareFiseMedicaleTextArea() {
        return vizualizareFiseMedicaleTextArea;
    }

    public JTextArea getSearchPatientTextArea() {
        return searchPatientTextArea;
    }

    public JTextArea getFilterMedicTextArea() {
        return filterMedicTextArea;
    }

    public JTextArea getFilterDiagnosticTextArea() {
        return filterDiagnosticTextArea;
    }

    public JTextArea getFilterVarstaTextArea() {
        return filterVarstaTextArea;
    }

    public void populateDiagnosticComboBox() {
        asistentViewModel.populateDiagnosticComboBox.execute();
    }

    public void populateMedicComboBox() {
        asistentViewModel.populateMedicComboBox.execute();
    }

    public void populateVarstaComboBox() {
        asistentViewModel.populateVarstaComboBox.execute();
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
        panel2.setLayout(new GridLayoutManager(18, 6, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-2395946));
        panel1.add(panel2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Vizualizare fise medicale");
        panel2.add(label1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vizualizareFiseMedicaleTextArea = new JTextArea();
        panel2.add(vizualizareFiseMedicaleTextArea, new GridConstraints(4, 0, 13, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Actualizare Fisa Medicala");
        panel2.add(label2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateIDFisaTextField = new JTextField();
        panel2.add(updateIDFisaTextField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("ID Fisa");
        panel2.add(label3, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Varsta Pacient");
        panel2.add(label4, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateVarstaFisaTextField = new JTextField();
        panel2.add(updateVarstaFisaTextField, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Medic Apartinator");
        panel2.add(label5, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateMedicFisaTextField = new JTextField();
        panel2.add(updateMedicFisaTextField, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Asistent Apartinator");
        panel2.add(label6, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateAsistentFisaTextField = new JTextField();
        panel2.add(updateAsistentFisaTextField, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Creare Fisa Medicala");
        panel2.add(label7, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Diagnostic");
        panel2.add(label8, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creareDiagnosticFisaTextField = new JTextField();
        panel2.add(creareDiagnosticFisaTextField, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Trataent");
        panel2.add(label9, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creareTratamentFisaTextField = new JTextField();
        panel2.add(creareTratamentFisaTextField, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Simptome");
        panel2.add(label10, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creareSimptomeFisaTextField = new JTextField();
        panel2.add(creareSimptomeFisaTextField, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Varsta Pacient");
        panel2.add(label11, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creareVarstaFisaTextField = new JTextField();
        panel2.add(creareVarstaFisaTextField, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Medic Apatinator");
        panel2.add(label12, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Asistent Apartinator");
        panel2.add(label13, new GridConstraints(15, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        actualizareFisaButton = new JButton();
        actualizareFisaButton.setText("Actualizare");
        panel2.add(actualizareFisaButton, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("Stergere Fisa");
        panel2.add(label14, new GridConstraints(13, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stergereButton = new JButton();
        stergereButton.setBackground(new Color(-2252579));
        stergereButton.setForeground(new Color(-13619152));
        stergereButton.setText("Stergere");
        panel2.add(stergereButton, new GridConstraints(17, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creareFisaButton = new JButton();
        creareFisaButton.setBackground(new Color(-2252579));
        creareFisaButton.setText("Creare");
        panel2.add(creareFisaButton, new GridConstraints(17, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vizualizareFiseMedicaleButton = new JButton();
        vizualizareFiseMedicaleButton.setBackground(new Color(-2252579));
        vizualizareFiseMedicaleButton.setText("Vizualizare");
        panel2.add(vizualizareFiseMedicaleButton, new GridConstraints(17, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("Filtrare Pacienti");
        panel2.add(label15, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setText("Medic");
        panel2.add(label16, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filterMedicComboBox = new JComboBox();
        filterMedicComboBox.setBackground(new Color(-2252579));
        filterMedicComboBox.setEditable(true);
        panel2.add(filterMedicComboBox, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filterMedicTextArea = new JTextArea();
        panel2.add(filterMedicTextArea, new GridConstraints(5, 3, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setText("Diagnostic");
        panel2.add(label17, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filterDiagnosticComboBox = new JComboBox();
        filterDiagnosticComboBox.setBackground(new Color(-2252579));
        panel2.add(filterDiagnosticComboBox, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filterDiagnosticTextArea = new JTextArea();
        panel2.add(filterDiagnosticTextArea, new GridConstraints(9, 3, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label18 = new JLabel();
        label18.setText("Varsta");
        panel2.add(label18, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label19 = new JLabel();
        label19.setText("Cautare pacient");
        panel2.add(label19, new GridConstraints(2, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label20 = new JLabel();
        label20.setText("Nume Pacient");
        panel2.add(label20, new GridConstraints(3, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numeCautarePacientTextField = new JTextField();
        panel2.add(numeCautarePacientTextField, new GridConstraints(4, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        adaugareConsultatieButton = new JButton();
        adaugareConsultatieButton.setBackground(new Color(-2252579));
        adaugareConsultatieButton.setText("Adaugare");
        panel2.add(adaugareConsultatieButton, new GridConstraints(17, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label21 = new JLabel();
        label21.setIcon(new ImageIcon(getClass().getResource("/images/asistent.png")));
        label21.setText("");
        panel2.add(label21, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label22 = new JLabel();
        Font label22Font = this.$$$getFont$$$("Castellar", Font.BOLD, 22, label22.getFont());
        if (label22Font != null) label22.setFont(label22Font);
        label22.setForeground(new Color(-13893586));
        label22.setText("ASISTENT");
        panel2.add(label22, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logOutButton = new JButton();
        logOutButton.setBackground(new Color(-2252579));
        logOutButton.setText("Log Out");
        panel2.add(logOutButton, new GridConstraints(0, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CSVButton = new JButton();
        CSVButton.setBackground(new Color(-2252579));
        CSVButton.setText("CSV");
        panel2.add(CSVButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JSONButton = new JButton();
        JSONButton.setBackground(new Color(-2252579));
        JSONButton.setText("JSON");
        panel2.add(JSONButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        XMLButton = new JButton();
        XMLButton.setBackground(new Color(-2252579));
        XMLButton.setText("XML");
        panel2.add(XMLButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DOCButton = new JButton();
        DOCButton.setBackground(new Color(-2252579));
        DOCButton.setText("DOC");
        panel2.add(DOCButton, new GridConstraints(1, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creareAsistentFisaTextField = new JTextField();
        panel2.add(creareAsistentFisaTextField, new GridConstraints(16, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        creareMedicFisaTtextField = new JTextField();
        panel2.add(creareMedicFisaTtextField, new GridConstraints(12, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label23 = new JLabel();
        label23.setText("Nume Pacient");
        panel2.add(label23, new GridConstraints(13, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        patientNameTextField = new JTextField();
        panel2.add(patientNameTextField, new GridConstraints(14, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label24 = new JLabel();
        label24.setText("ID Fisa");
        panel2.add(label24, new GridConstraints(14, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stergereIDFisaTextField = new JTextField();
        panel2.add(stergereIDFisaTextField, new GridConstraints(15, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        filterVarstaComboBox = new JComboBox();
        filterVarstaComboBox.setBackground(new Color(-2252579));
        panel2.add(filterVarstaComboBox, new GridConstraints(12, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filterVarstaTextArea = new JTextArea();
        panel2.add(filterVarstaTextArea, new GridConstraints(13, 3, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        medicAddConsultTextField = new JTextField();
        panel2.add(medicAddConsultTextField, new GridConstraints(16, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label25 = new JLabel();
        label25.setText("Medic");
        panel2.add(label25, new GridConstraints(15, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        namePacientConsultationTextField = new JTextField();
        panel2.add(namePacientConsultationTextField, new GridConstraints(14, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label26 = new JLabel();
        label26.setText("Nume Pacient");
        panel2.add(label26, new GridConstraints(13, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        endHourConsultationTextField = new JTextField();
        panel2.add(endHourConsultationTextField, new GridConstraints(12, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label27 = new JLabel();
        label27.setText("Ora final");
        panel2.add(label27, new GridConstraints(11, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startHourConsultationTextField = new JTextField();
        panel2.add(startHourConsultationTextField, new GridConstraints(10, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label28 = new JLabel();
        label28.setText("Ora inceput");
        panel2.add(label28, new GridConstraints(9, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label29 = new JLabel();
        label29.setText("Planificare Consultatie");
        panel2.add(label29, new GridConstraints(8, 4, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cautarePacientButton = new JButton();
        cautarePacientButton.setBackground(new Color(-2252579));
        cautarePacientButton.setText("Cautare");
        panel2.add(cautarePacientButton, new GridConstraints(6, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchPatientTextArea = new JTextArea();
        panel2.add(searchPatientTextArea, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
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
