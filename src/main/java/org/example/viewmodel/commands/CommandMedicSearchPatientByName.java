package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

import java.util.List;

public class CommandMedicSearchPatientByName implements Command{
    private final MedicViewModel medicViewModel;

    private final MedicForm medicForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandMedicSearchPatientByName(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }


    @Override
    public void execute(){

        String patientName = medicViewModel.getCautareNumePacientTextField();

        medicForm.getAfisarePacientNumeTextArea().setText("");

        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.allMedicalRecordByPatientName(patientName);

        if(!allMedicalRecords.isEmpty())
        {
            for(MedicalRecord medicalRecord : allMedicalRecords){
            medicForm.getAfisarePacientNumeTextArea().append("Numar Fisa: " + medicalRecord.getIdfisaMedicala().toString() + "\n" + "Diagnostic: " + medicalRecord.getDiagnostic() + ", Simptome: " +
                    medicalRecord.getSymptoms() + "\n" + ", Tratament: " + medicalRecord.getTreatment() + ", Varsta Pacient: " + medicalRecord.getPatientAge().toString() + "\n" + "\n");
            }
        }
        else {
            medicForm.getAfisarePacientNumeTextArea().append("Pacientul cu numele furnizat nu exista");
        }
    }

}
