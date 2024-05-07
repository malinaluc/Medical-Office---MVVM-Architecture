package org.example.viewmodel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import org.example.view.AsistentForm;
import org.example.viewmodel.commands.Command;
import org.example.viewmodel.commands.CommandAsistentDeleteMedicalRecord;
import org.example.viewmodel.commands.CommandAsistentUpdateMedicalRecord;
import org.example.viewmodel.commands.CommandAsistentViewAllMedicalRecords;

public class AsistentViewModel {

    private final Property<String> updateIDFisaTextField;
    private final Property<String> updateVarstaFisaTextField;
    private final Property<String> updateMedicFisaTextField;
    private final Property<String> updateAsistentFisaTextField;
    private final Property<String> stergereIDFisaTextField;


    public Command viewAllMedicalRecords;

    public Command updateMedicalRecord;
    public Command deleteMedicalRecord;

    public AsistentViewModel(AsistentForm asistentForm) {

        updateIDFisaTextField = PropertyFactory.createProperty("updateFisaID", this, String.class);
        updateVarstaFisaTextField = PropertyFactory.createProperty("updateFisaVarsta", this, String.class);
        updateMedicFisaTextField = PropertyFactory.createProperty("updateFisaMedic", this, String.class);
        updateAsistentFisaTextField = PropertyFactory.createProperty("updateFisaAsistent", this, String.class);

        stergereIDFisaTextField = PropertyFactory.createProperty("stergereFisaID", this, String.class);


        viewAllMedicalRecords = new CommandAsistentViewAllMedicalRecords(this, asistentForm);

        updateMedicalRecord = new CommandAsistentUpdateMedicalRecord(this, asistentForm);

        deleteMedicalRecord = new CommandAsistentDeleteMedicalRecord(this, asistentForm);

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


}

