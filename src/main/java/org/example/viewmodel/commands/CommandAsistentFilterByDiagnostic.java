package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import java.util.List;

public class CommandAsistentFilterByDiagnostic implements Command{
    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentFilterByDiagnostic(AsistentViewModel asistentViewModel, AsistentForm asistentForm){
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute(){

        String selectedDiagnostic = asistentViewModel.getSelectedFilterDiagnostic();

        asistentForm.getFilterDiagnosticTextArea().setText("");


        List<MedicalRecord> allByDiagnostic = medicalRecordRepository.allMedicalRecordByDiagnostic(selectedDiagnostic);

        for (MedicalRecord fisaMedicala : allByDiagnostic) {
            asistentForm.getFilterDiagnosticTextArea().append("Numar Fisa: " + fisaMedicala.getIdfisaMedicala().toString() + "\n" + "Nume pacient : " + fisaMedicala.getPatientName() + "\n" + "Diagnostic: " + fisaMedicala.getDiagnostic() + ", Simptome: " +
                    fisaMedicala.getSymptoms() + "\n" + ", Tratament: " + fisaMedicala.getTreatment() + ", Varsta Pacient: " + fisaMedicala.getPatientAge().toString() + "\n" + "\n");

        }

    }
}
