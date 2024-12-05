package org.example.viewmodel.commands;

import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicRepository;
import org.example.model.repository.MedicalRecordRepository;
import org.example.model.repository.UserRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

public class CommandAsistentDeleteMedicalRecord implements Command {

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    private final MedicRepository medicRepository = new MedicRepository();

    private final UserRepository userRepository = new UserRepository();

    public CommandAsistentDeleteMedicalRecord(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute() {

        Integer IDFisa = Integer.parseInt(asistentViewModel.getStergereIDFisaTextField());

        MedicalRecord medicalRecordToDelete = medicalRecordRepository.findById(IDFisa);

        medicalRecordRepository.delete(medicalRecordToDelete);
    }
}
