package org.example.viewmodel.commands;

import org.example.model.entity.Consultation;
import org.example.model.entity.Medic;
import org.example.model.repository.ConsultationRepository;
import org.example.model.repository.MedicRepository;
import org.example.utils.LoggedInUser;
import org.example.utils.SessionManager;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;
import java.util.List;

public class CommandMedicViewConsultations implements Command{
    private final MedicViewModel medicViewModel;

    private final MedicForm medicForm;
    private final ConsultationRepository consultationRepository = new ConsultationRepository();

    private final MedicRepository medicRepository = new MedicRepository();
    public CommandMedicViewConsultations(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }
    @Override
    public void execute(){

        medicForm.getVizualizareConsultatiiTextArea().setText("");

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();

        Medic loggedInMedic = medicRepository.findMedicByID(loggedInUser.getIdUserLoggedIn());

        List<Consultation> allConsultations = consultationRepository.allConsultationsByMedicId(loggedInMedic.getIdMedic());

        for(Consultation consultation : allConsultations){
            medicForm.getVizualizareConsultatiiTextArea().append("Interval orar: " + consultation.getStartConsultationHour() + " - " + consultation.getEndConsultationHour()+"\nNume pacient: " + consultation.getNamePatient()+ "\n" + "\n");
        }

    }
}
