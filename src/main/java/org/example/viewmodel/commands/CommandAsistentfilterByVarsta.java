package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import java.util.List;

public class CommandAsistentfilterByVarsta implements Command {
    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentfilterByVarsta(AsistentViewModel asistentViewModel, AsistentForm asistentForm){
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute(){

        asistentForm.getFilterVarstaTextArea().setText("");

        Integer varsta = Integer.parseInt(asistentViewModel.getSelectedFilterVarsta());

        List<MedicalRecord> allByVarsta = medicalRecordRepository.allMedicalRecordByVarsta(varsta);

        for(MedicalRecord fisaMedicala : allByVarsta){
            asistentForm.getFilterVarstaTextArea().append("Numar Fisa: " + fisaMedicala.getIdfisaMedicala().toString() +"\n" + "Nume pacient : " + fisaMedicala.getPatientName() +  "\n" + "Diagnostic: " + fisaMedicala.getDiagnostic() + "\n" + ", Simptome: " +
                    fisaMedicala.getSymptoms() + "\n" + ", Tratament: " + "\n" + fisaMedicala.getTreatment() + "\n" + ", Varsta Pacient: " + fisaMedicala.getPatientAge().toString() + "\n" + "\n");
        }
    }
}
