package org.example.viewmodel;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.view.AsistentForm;
import org.example.viewmodel.commands.*;

import javax.swing.*;

public class AsistentViewModel {

    private final Property<String> updateIDFisaTextField;
    private final Property<String> updateVarstaFisaTextField;
    private final Property<String> updateMedicFisaTextField;
    private final Property<String> updateAsistentFisaTextField;
    private final Property<String> stergereIDFisaTextField;
    private final Property<String> creareDiagnosticFisaTextField;
    private final Property<String> creareTratamentFisaTextField;
    private final Property<String> creareSimptomeFisaTextField;
    private final Property<String> creareVarstaFisaTextField;
    private final Property<String> creareMedicFisaTtextField;
    private final Property<String> creareAsistentFisaTextField;
    private final Property<String> patientNameTextField; //creare fisa
    private final Property<String> numeCautarePacientTextField;
    private final Property<String> startHourConsultationTextField;
    private final Property<String> endHourConsultationTextField;
    private final Property<String> namePacientConsultationTextField;
    private final Property<String> medicAddConsultTextField;

    private Property<DefaultComboBoxModel<String>> filterDiagnosticComboBox;
    private Property<DefaultComboBoxModel<String>> filterVarstaComboBox;
    private Property<DefaultComboBoxModel<String>> filterMedicComboBox;

    private String selectedFilterDiagnostic;
    private String selectedFilterVarsta;
    private String selectedFilterMedic;
    public Command viewAllMedicalRecords;

    public Command updateMedicalRecord;
    public Command deleteMedicalRecord;

    public Command createMedicalRecord;

    public Command searchPatientByName;
    public Command addConsultation;
    public Command logOutCommand;
    public Command exportCSVFile;
    public Command exportJSONFile;

    public Command exportDOCFile;
    public Command exportXMLFile;

    public Command populateVarstaComboBox;
    public Command populateMedicComboBox;
    public Command populateDiagnosticComboBox;

    public Command filterByVarsta;
    public Command filterByMedic;
    public Command filterByDiagnostic;


    public AsistentViewModel(AsistentForm asistentForm) {

        updateIDFisaTextField = PropertyFactory.createProperty("updateFisaID", this, String.class);
        updateVarstaFisaTextField = PropertyFactory.createProperty("updateFisaVarsta", this, String.class);
        updateMedicFisaTextField = PropertyFactory.createProperty("updateFisaMedic", this, String.class);
        updateAsistentFisaTextField = PropertyFactory.createProperty("updateFisaAsistent", this, String.class);

        stergereIDFisaTextField = PropertyFactory.createProperty("stergereFisaID", this, String.class);

        creareDiagnosticFisaTextField = PropertyFactory.createProperty("creareFisaDiagnostic", this, String.class);
        creareTratamentFisaTextField = PropertyFactory.createProperty("creareFisaTratament", this, String.class);
        creareSimptomeFisaTextField = PropertyFactory.createProperty("creareFisaSimptome", this, String.class);
        creareVarstaFisaTextField = PropertyFactory.createProperty("creareFisaVarsta", this, String.class);
        creareMedicFisaTtextField = PropertyFactory.createProperty("creareFisaMedic", this, String.class);
        creareAsistentFisaTextField = PropertyFactory.createProperty("creareFisaAsistent", this, String.class);
        patientNameTextField = PropertyFactory.createProperty("creareFisaNumePacient", this, String.class);

        numeCautarePacientTextField = PropertyFactory.createProperty("cautarePacientNume", this, String.class);

        startHourConsultationTextField = PropertyFactory.createProperty("addConsultStartHour", this, String.class);
        endHourConsultationTextField = PropertyFactory.createProperty("addConsultEndHour", this, String.class);
        namePacientConsultationTextField = PropertyFactory.createProperty("addConsultnamePatient", this, String.class);
        medicAddConsultTextField = PropertyFactory.createProperty("addConsultMedic", this, String.class);

        filterDiagnosticComboBox = PropertyFactory.createProperty("filterDiagnosticComboBox", this,new DefaultComboBoxModel<>());
        filterVarstaComboBox = PropertyFactory.createProperty("filterVarstaComboBox", this, new DefaultComboBoxModel<>());
        filterMedicComboBox = PropertyFactory.createProperty("filterMedicComboBox", this,new DefaultComboBoxModel<>() );

        viewAllMedicalRecords = new CommandAsistentViewAllMedicalRecords(this, asistentForm);

        updateMedicalRecord = new CommandAsistentUpdateMedicalRecord(this, asistentForm);

        deleteMedicalRecord = new CommandAsistentDeleteMedicalRecord(this, asistentForm);

        createMedicalRecord = new CommandAsistentCreateMedicalRecord(this, asistentForm);

        searchPatientByName = new CommandAsistentSearchPatientByName(this, asistentForm);

        addConsultation = new CommandAsistentAddConsultation(this, asistentForm);

        logOutCommand = new CommandAsistentLogOut(this, asistentForm);

        exportCSVFile = new CommandExportCSV(this, asistentForm);

        exportJSONFile = new CommandExportJSON(this,asistentForm);

        exportDOCFile = new CommandExportDOC(this,asistentForm);

        exportXMLFile = new CommandExportXML(this,asistentForm);

        populateDiagnosticComboBox = new CommandAsistentPopulateDiagnosticCombobox(this,asistentForm);
        populateMedicComboBox = new CommandAsistentPopulateMedicComboBox(this,asistentForm);
        populateVarstaComboBox = new CommandAsistentPopulateVarstaComboBox(this,asistentForm);

        filterByVarsta = new CommandAsistentfilterByVarsta(this,asistentForm);
        filterByMedic = new CommandAsistentFilterByMedic(this,asistentForm);
        filterByDiagnostic = new CommandAsistentFilterByDiagnostic(this,asistentForm);
    }

    public String getUpdateIDFisaTextField() {
        return updateIDFisaTextField.get();
    }

    public String getUpdateVarstaFisaTextField() {
        return updateVarstaFisaTextField.get();
    }

    public String getUpdateMedicFisaTextField() {
        return updateMedicFisaTextField.get();
    }

    public String getUpdateAsistentFisaTextField() {
        return updateAsistentFisaTextField.get();
    }

    public String getStergereIDFisaTextField() {
        return stergereIDFisaTextField.get();
    }

    public String getCreareDiagnosticFisaTextField() {
        return creareDiagnosticFisaTextField.get();
    }

    public String getCreareTratamentFisaTextField() {
        return creareTratamentFisaTextField.get();
    }

    public String getCreareSimptomeFisaTextField() {
        return creareSimptomeFisaTextField.get();
    }

    public String getCreareVarstaFisaTextField() {
        return creareVarstaFisaTextField.get();
    }

    public String getCreareMedicFisaTtextField() {
        return creareMedicFisaTtextField.get();
    }

    public String getCreareAsistentFisaTextField() {
        return creareAsistentFisaTextField.get();
    }

    public String getPatientNameTextField() {
        return patientNameTextField.get();
    }

    public String getNumeCautarePacientTextField() {
        return numeCautarePacientTextField.get();
    }

    public String getStartHourConsultationTextField() {
        return startHourConsultationTextField.get();
    }

    public String getEndHourConsultationTextField() {
        return endHourConsultationTextField.get();
    }

    public String getNamePacientConsultationTextField() {
        return namePacientConsultationTextField.get();
    }

    public String getMedicAddConsultTextField() {
        return medicAddConsultTextField.get();
    }

    public DefaultComboBoxModel<String> getFilterDiagnosticComboBox() {
        return filterDiagnosticComboBox.get();
    }

    public void setFilterDiagnosticComboBox(Property<DefaultComboBoxModel<String>> filterDiagnosticComboBox) {
        this.filterDiagnosticComboBox = filterDiagnosticComboBox;
    }

    public DefaultComboBoxModel<String> getFilterVarstaComboBox() {
        return filterVarstaComboBox.get();
    }

    public void setFilterVarstaComboBox(Property<DefaultComboBoxModel<String>> filterVarstaComboBox) {
        this.filterVarstaComboBox = filterVarstaComboBox;
    }

    public DefaultComboBoxModel<String> getFilterMedicComboBox() {
        return filterMedicComboBox.get();
    }

    public void setFilterMedicComboBox(Property<DefaultComboBoxModel<String>> filterMedicComboBox) {
        this.filterMedicComboBox = filterMedicComboBox;
    }


    public String getSelectedFilterDiagnostic() {
        return selectedFilterDiagnostic;
    }

    public void setSelectedFilterDiagnostic(String selectedFilterDiagnostic) {
        this.selectedFilterDiagnostic = selectedFilterDiagnostic;
    }

    public String getSelectedFilterVarsta() {
        return selectedFilterVarsta;
    }

    public void setSelectedFilterVarsta(String selectedFilterVarsta) {
        this.selectedFilterVarsta = selectedFilterVarsta;
    }

    public String getSelectedFilterMedic() {
        return selectedFilterMedic;
    }

    public void setSelectedFilterMedic(String selectedFilterMedic) {
        this.selectedFilterMedic = selectedFilterMedic;
    }
}


