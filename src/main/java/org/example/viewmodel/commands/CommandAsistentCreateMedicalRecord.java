package org.example.viewmodel.commands;

import org.example.model.entity.Medic;
import org.example.model.entity.MedicalRecord;
import org.example.model.entity.User;
import org.example.model.repository.MedicRepository;
import org.example.model.repository.MedicalRecordRepository;
import org.example.model.repository.UserRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

public class CommandAsistentCreateMedicalRecord implements Command {

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;
    private final MedicRepository medicRepository = new MedicRepository();
    private final UserRepository userRepository = new UserRepository();
    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentCreateMedicalRecord(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }


    @Override
    public void execute() {

        String patientName = asistentViewModel.getPatientNameTextField();
        String symptoms = asistentViewModel.getCreareSimptomeFisaTextField();
        String treatment = asistentViewModel.getCreareTratamentFisaTextField();
        String diagnostic = asistentViewModel.getCreareDiagnosticFisaTextField();
        Integer patientAge = Integer.parseInt(asistentViewModel.getCreareVarstaFisaTextField());
        Integer medic = Integer.parseInt(asistentViewModel.getCreareMedicFisaTtextField());
        Integer asistent = Integer.parseInt(asistentViewModel.getCreareAsistentFisaTextField());

        Medic idMedic = medicRepository.findMedicByID(medic);

        User idAsistent = userRepository.findByID(asistent);

        MedicalRecord newMedicalRecord = new MedicalRecord();
        newMedicalRecord.setPatientName(patientName);
        newMedicalRecord.setSymptoms(symptoms);
        newMedicalRecord.setTreatment(treatment);
        newMedicalRecord.setDiagnostic(diagnostic);
        newMedicalRecord.setPatientAge(patientAge);
        newMedicalRecord.setIdMedic(idMedic);
        newMedicalRecord.setIdAsistent(idAsistent);

        medicalRecordRepository.save(newMedicalRecord);
    }
}
