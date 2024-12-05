package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.utils.LoggedInUser;
import org.example.utils.SessionManager;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

import java.util.List;

public class CommandMedicViewAllMedicalRecords implements Command {

    private final MedicViewModel medicViewModel;

    private final MedicForm medicForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();


    public CommandMedicViewAllMedicalRecords(MedicViewModel medicViewModel, MedicForm medicForm) {
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }

    @Override
    public void execute() {

        medicForm.getVizualizareFiseMedicaleTextArea().setText("");
        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();

        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.allMedicalRecordByMedicUserId(loggedInUser.getIdUserLoggedIn());

        for (MedicalRecord medicalRecord : allMedicalRecords) {
            medicForm.getVizualizareFiseMedicaleTextArea().append("Numar Fisa: " + medicalRecord.getIdfisaMedicala().toString() + "\n" + "Nume pacient: " + medicalRecord.getPatientName() + "\n" + "Diagnostic: " + medicalRecord.getDiagnostic() + ", Simptome: " +
                    medicalRecord.getSymptoms() + "\n" + ", Tratament: " + medicalRecord.getTreatment() + ", Varsta Pacient: " + medicalRecord.getPatientAge().toString() + "\n" + "\n");
        }
    }
}
