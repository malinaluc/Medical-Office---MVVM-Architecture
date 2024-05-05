package org.example.viewmodel.commands;

import org.example.model.entity.Medic;
import org.example.model.entity.User;
import org.example.model.repository.MedicRepository;
import org.example.model.repository.MedicalRecordRepository;
import org.example.model.repository.UserRepository;
import org.example.utils.LoggedInUser;
import org.example.utils.SessionManager;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

public class CommandMedicSetTimetable implements Command{
    private final MedicViewModel medicViewModel;

    private final MedicForm medicForm;

    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    private final UserRepository userRepository = new UserRepository();

    private final MedicRepository medicRepository = new MedicRepository();

    public CommandMedicSetTimetable(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }
    @Override
    public void execute(){

        Integer startHour = Integer.parseInt(medicViewModel.getStartHourMedicTextField());
        Integer endHour = Integer.parseInt(medicViewModel.getEndDourMedicTextField());

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();

        Medic loggedInMedic = medicRepository.findMedicByID(loggedInUser.getIdUserLoggedIn());

        Integer IDMedic = loggedInMedic.getIdMedic();
        String name = loggedInMedic.getName();
        String surname = loggedInMedic.getSurname();

        User newUser = userRepository.findByID(loggedInUser.getIdUserLoggedIn());


        Medic newMedic = new Medic(IDMedic,name,surname,newUser,startHour,endHour);

        userRepository.update(newMedic);

    }
}
