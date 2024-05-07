package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import java.util.List;

public class CommandAsistentSearchPatientByName implements Command {

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentSearchPatientByName(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }


    @Override
    public void execute() {

        String patientName = asistentViewModel.getNumeCautarePacientTextField();

        asistentForm.getSearchPatientTextArea().setText("");

        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.allMedicalRecordByPatientName(patientName);

        if (!allMedicalRecords.isEmpty()) {
            for (MedicalRecord medicalRecord : allMedicalRecords) {
                asistentForm.getSearchPatientTextArea().append("Numar Fisa: " + medicalRecord.getIdfisaMedicala().toString() + "\n" + "Diagnostic: " + medicalRecord.getDiagnostic() + ", Simptome: " +
                        medicalRecord.getSymptoms() + "\n" + ", Tratament: " + medicalRecord.getTreatment() + ", Varsta Pacient: " + medicalRecord.getPatientAge().toString() + "\n" + "\n");
            }
        } else {
            asistentForm.getSearchPatientTextArea().append("Pacientul cu numele furnizat nu exista");
        }

    }
}
