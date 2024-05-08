package org.example.viewmodel;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.view.MedicForm;
import org.example.viewmodel.commands.*;

import javax.swing.*;

public class MedicViewModel {

    private final Property<String> IDFisaMedicalaTextField;
    private final Property<String> symptomsTextField;
    private final Property<String> diagnostictextField;
    private final Property<String> treatmentTextField;
    private final Property<String> cautareNumePacientTextField;
    private final Property<String> startHourMedicTextField;
    private final Property<String> endDourMedicTextField;

    private Property<DefaultComboBoxModel<String>> diagnosticComboBox;
    private Property<DefaultComboBoxModel<String>> treatmentComboBox;
    private String selectedFilterDiagnostic;
    private String selectedFilterTreatment;
    public Command viewAllMedicalRecordsCommand;

    public Command updateMedicalRecordComand;

    public Command searchPatientByNameCommand;

    public Command setTimetableCommand;

    public Command viewAllConsultationsCommand;

    public Command logOutCommand;
    public Command populateTreatmentComboBox;
    public Command populateDiagnosticComboBox;
    public Command filterByDiagnostic;
    public Command filterByTreatment;

    public MedicViewModel(MedicForm medicForm) {


        IDFisaMedicalaTextField = PropertyFactory.createProperty("updateFisaMedicalaID", this, String.class);
        symptomsTextField = PropertyFactory.createProperty("updateFisaMedicalasymptoms", this, String.class);
        diagnostictextField = PropertyFactory.createProperty("updateFisaMedicaladiagnostic", this, String.class);
        treatmentTextField = PropertyFactory.createProperty("updateFisaMedicalatreatment", this, String.class);

        cautareNumePacientTextField = PropertyFactory.createProperty("numePacient", this, String.class);

        startHourMedicTextField = PropertyFactory.createProperty("startHour", this, String.class);
        endDourMedicTextField = PropertyFactory.createProperty("endHour", this, String.class);

        diagnosticComboBox = PropertyFactory.createProperty("diagnosticComboBox", this ,new DefaultComboBoxModel<>());
        treatmentComboBox = PropertyFactory.createProperty("treatmentComboBox", this, new DefaultComboBoxModel<>());

        viewAllMedicalRecordsCommand = new CommandMedicViewAllMedicalRecords(this, medicForm);
        updateMedicalRecordComand = new CommandMedicUpdateMedicalRecord(this, medicForm);
        searchPatientByNameCommand = new CommandMedicSearchPatientByName(this, medicForm);
        setTimetableCommand = new CommandMedicSetTimetable(this, medicForm);
        viewAllConsultationsCommand = new CommandMedicViewConsultations(this, medicForm);
        logOutCommand = new CommandMedicLogOut(this, medicForm);
        populateTreatmentComboBox = new CommandMedicPopulateTreatmentComboBox(this,medicForm);
        populateDiagnosticComboBox = new CommandMedicPopulateDiagnosticComboBox(this,medicForm);
        filterByDiagnostic = new CommandMedicFilterByDiagnostic(this,medicForm);
        filterByTreatment = new CommandMedicFilterByTreatment(this,medicForm);
    }

    public String getIDFisaMedicalaTextField() {
        return IDFisaMedicalaTextField.get();
    }

    public String getSymptomsTextField() {
        return symptomsTextField.get();
    }

    public String getDiagnostictextField() {
        return diagnostictextField.get();
    }

    public String getTreatmentTextField() {
        return treatmentTextField.get();
    }

    public String getCautareNumePacientTextField() {
        return cautareNumePacientTextField.get();
    }

    public String getStartHourMedicTextField() {
        return startHourMedicTextField.get();
    }

    public String getEndDourMedicTextField() {
        return endDourMedicTextField.get();
    }

    public DefaultComboBoxModel<String> getDiagnosticComboBox() {
        return diagnosticComboBox.get();
    }

    public void setDiagnosticComboBox(Property<DefaultComboBoxModel<String>> diagnosticComboBox) {
        this.diagnosticComboBox = diagnosticComboBox;
    }

    public DefaultComboBoxModel<String> getTreatmentComboBox() {
        return treatmentComboBox.get();
    }

    public void setTreatmentComboBox(Property<DefaultComboBoxModel<String>> treatmentComboBox) {
        this.treatmentComboBox = treatmentComboBox;
    }

    public String getSelectedFilterDiagnostic() {
        return selectedFilterDiagnostic;
    }

    public void setSelectedFilterDiagnostic(String selectedFilterDiagnostic) {
        this.selectedFilterDiagnostic = selectedFilterDiagnostic;
    }

    public String getSelectedFilterTreatment() {
        return selectedFilterTreatment;
    }

    public void setSelectedFilterTreatment(String selectedFilterTreatment) {
        this.selectedFilterTreatment = selectedFilterTreatment;
    }
}
