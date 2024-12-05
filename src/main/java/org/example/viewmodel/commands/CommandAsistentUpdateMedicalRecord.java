package org.example.viewmodel.commands;

import org.example.model.entity.Medic;
import org.example.model.entity.MedicalRecord;
import org.example.model.entity.User;
import org.example.model.repository.MedicRepository;
import org.example.model.repository.MedicalRecordRepository;
import org.example.model.repository.UserRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

public class CommandAsistentUpdateMedicalRecord implements Command{

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    private final MedicRepository medicRepository = new MedicRepository();

    private final UserRepository userRepository = new UserRepository();

    public CommandAsistentUpdateMedicalRecord(AsistentViewModel asistentViewModel,AsistentForm asistentForm){
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }


    @Override
    public void execute(){

        Integer idfisaMedicala = Integer.parseInt(asistentViewModel.getUpdateIDFisaTextField());
        Integer patientAge = Integer.parseInt(asistentViewModel.getUpdateVarstaFisaTextField());
        Integer medicID = Integer.parseInt(asistentViewModel.getUpdateMedicFisaTextField());
        Integer asistentID = Integer.parseInt(asistentViewModel.getUpdateAsistentFisaTextField());

        Medic medic = medicRepository.findMedicByID(medicID);
        User asistent = userRepository.findByID(asistentID);

        MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(idfisaMedicala);

        String patientName = existingMedicalRecord.getPatientName();
        String symptoms = existingMedicalRecord.getSymptoms();
        String treatment = existingMedicalRecord.getTreatment();
        String diagnostic = existingMedicalRecord.getDiagnostic();

        MedicalRecord newMedicalRecord = new MedicalRecord(idfisaMedicala,patientName,symptoms,treatment,diagnostic,patientAge,medic,asistent);

        medicalRecordRepository.update(newMedicalRecord);
    }
}
