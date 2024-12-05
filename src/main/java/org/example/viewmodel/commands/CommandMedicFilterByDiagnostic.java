package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

import java.util.List;

public class CommandMedicFilterByDiagnostic implements Command{

    private final MedicViewModel medicViewModel;
    private final MedicForm medicForm;
    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandMedicFilterByDiagnostic(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }

    @Override
    public void execute(){

        String selectedDiagnostic = medicViewModel.getSelectedFilterDiagnostic();

        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.allMedicalRecordByDiagnostic(selectedDiagnostic);

        medicForm.getFiltrareDiagnosticTtextArea().setText("");

        for (MedicalRecord fisaMedicala : allMedicalRecords) {
            medicForm.getFiltrareDiagnosticTtextArea().append("Numar Fisa: " + fisaMedicala.getIdfisaMedicala().toString() + "\n" + "Nume pacient : " + fisaMedicala.getPatientName() + "\n" + "Diagnostic: " + fisaMedicala.getDiagnostic() + ", Simptome: " +
                    fisaMedicala.getSymptoms() + "\n" + ", Tratament: " + fisaMedicala.getTreatment() + ", Varsta Pacient: " + fisaMedicala.getPatientAge().toString() + "\n" + "\n");

        }
    }
}
