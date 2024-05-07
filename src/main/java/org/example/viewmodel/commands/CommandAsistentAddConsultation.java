package org.example.viewmodel.commands;

import org.example.model.entity.Consultation;
import org.example.model.entity.Medic;
import org.example.model.repository.ConsultationRepository;
import org.example.model.repository.MedicRepository;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

public class CommandAsistentAddConsultation implements Command {

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    private final ConsultationRepository consultationRepository = new ConsultationRepository();

    private final MedicRepository medicRepository = new MedicRepository();

    public CommandAsistentAddConsultation(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }


    @Override
    public void execute() {
        Integer startConsultationHour = Integer.parseInt(asistentViewModel.getStartHourConsultationTextField());
        Integer endConsultationHour = Integer.parseInt(asistentViewModel.getEndHourConsultationTextField());
        String namePatient = asistentViewModel.getNamePacientConsultationTextField();
        Integer medic = Integer.parseInt(asistentViewModel.getMedicAddConsultTextField());

        Medic idMedic = medicRepository.findMedicByID(medic);

        Consultation consultation = new Consultation();
        consultation.setStartConsultationHour(startConsultationHour);
        consultation.setEndConsultationHour(endConsultationHour);
        consultation.setNamePatient(namePatient);
        consultation.setIdMedic(idMedic);

        consultationRepository.save(consultation);

    }
}
