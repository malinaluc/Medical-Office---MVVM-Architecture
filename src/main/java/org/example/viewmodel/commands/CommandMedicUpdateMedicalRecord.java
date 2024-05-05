package org.example.viewmodel.commands;

import org.example.model.entity.Medic;
import org.example.model.entity.MedicalRecord;
import org.example.model.entity.User;
import org.example.model.repository.MedicalRecordRepository;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

public class CommandMedicUpdateMedicalRecord implements Command{

    private final MedicViewModel medicViewModel;

    private final MedicForm medicForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();




    public CommandMedicUpdateMedicalRecord(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }

    @Override
    public void execute(){
        String fisaIDString = medicViewModel.getIDFisaMedicalaTextField();
        Integer idfisaMedicala = Integer.parseInt(fisaIDString);
        String diagnostic = medicViewModel.getDiagnostictextField();
        String treatment = medicViewModel.getTreatmentTextField();
        String symptoms = medicViewModel.getSymptomsTextField();

        MedicalRecord existingFisaMedicala = medicalRecordRepository.findById(idfisaMedicala);
        String patientName = existingFisaMedicala.getPatientName();
        Medic idMedic = existingFisaMedicala.getIdMedic();
        User idAsistent = existingFisaMedicala.getIdAsistent();
        Integer patientAge = existingFisaMedicala.getPatientAge();

        MedicalRecord fisaMedicala = new MedicalRecord(idfisaMedicala,patientName, diagnostic, symptoms, treatment, patientAge, idMedic, idAsistent);

        medicalRecordRepository.updateFisa(fisaMedicala);
    }
}
