package org.example.viewmodel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import org.example.view.MedicForm;
import org.example.viewmodel.commands.*;

public class MedicViewModel {

    private final Property<String> IDFisaMedicalaTextField;
    private final Property<String> symptomsTextField;
    private final Property<String> diagnostictextField;
    private final Property<String> treatmentTextField;
    private final Property<String> cautareNumePacientTextField;
    private final Property<String> startHourMedicTextField;
    private final Property<String> endDourMedicTextField;

    public Command viewAllMedicalRecordsCommand;

    public Command updateMedicalRecordComand;

    public Command searchPatientByNameCommand;

    public Command setTimetableCommand;
    public MedicViewModel(MedicForm medicForm){


        IDFisaMedicalaTextField = PropertyFactory.createProperty("updateFisaMedicalaID",this,String.class);
        symptomsTextField = PropertyFactory.createProperty("updateFisaMedicalasymptoms",this,String.class);
        diagnostictextField = PropertyFactory.createProperty("updateFisaMedicaladiagnostic",this,String.class);
        treatmentTextField = PropertyFactory.createProperty("updateFisaMedicalatreatment",this,String.class);

        cautareNumePacientTextField = PropertyFactory.createProperty("numePacient",this,String.class);

        startHourMedicTextField = PropertyFactory.createProperty("startHour", this, String.class);
        endDourMedicTextField = PropertyFactory.createProperty("endHour", this, String.class);

        viewAllMedicalRecordsCommand = new CommandMedicViewAllMedicalRecords(this,medicForm);
        updateMedicalRecordComand = new CommandMedicUpdateMedicalRecord(this,medicForm);
        searchPatientByNameCommand = new CommandMedicSearchPatientByName(this,medicForm);
        setTimetableCommand = new CommandMedicSetTimetable(this,medicForm);

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

    public String getStartHourMedicTextField() {return startHourMedicTextField.get();}

    public String getEndDourMedicTextField() {return endDourMedicTextField.get();}



}
