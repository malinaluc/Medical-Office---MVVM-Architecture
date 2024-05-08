package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import java.util.List;

public class CommandAsistentViewAllMedicalRecords implements Command {

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentViewAllMedicalRecords(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute() {
        asistentForm.getVizualizareFiseMedicaleTextArea().setText("");

        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.readAll();
        for (MedicalRecord medicalRecord : allMedicalRecords) {
            asistentForm.getVizualizareFiseMedicaleTextArea().append("Numar Fisa: " + medicalRecord.getIdfisaMedicala().toString() + "\n" + "Nume pacient: " + medicalRecord.getPatientName() + "\n" + "Diagnostic: " + medicalRecord.getDiagnostic() + ", Simptome: " +
                    medicalRecord.getSymptoms() + "\n" + ", Tratament: " + medicalRecord.getTreatment() + ", Varsta Pacient: " + medicalRecord.getPatientAge().toString() + "\n" + "\n");
        }
    }
}
