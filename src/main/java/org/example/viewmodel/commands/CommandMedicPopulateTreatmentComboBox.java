package org.example.viewmodel.commands;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.utils.LoggedInUser;
import org.example.utils.SessionManager;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;

public class CommandMedicPopulateTreatmentComboBox implements Command{

    private final MedicViewModel medicViewModel;
    private final MedicForm medicForm;
    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandMedicPopulateTreatmentComboBox(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }
    @Override
    public void execute(){

        DefaultComboBoxModel<String> comboBoxModel = medicViewModel.getTreatmentComboBox();

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();
        Integer idUserLoggedIn = loggedInUser.getIdUserLoggedIn();
        List<MedicalRecord> allFisaMedicala = medicalRecordRepository.allMedicalRecordByMedicID(loggedInUser.getIdUserLoggedIn());

        HashSet<String> treatments = new HashSet<>();

        for (MedicalRecord fisaMedicala : allFisaMedicala) {
            treatments.add(fisaMedicala.getTreatment());
        }

        if (treatments != null) {
            for (String tratment : treatments) {
                comboBoxModel.addElement(tratment);
            }
        }

        Property<DefaultComboBoxModel<String>> property = PropertyFactory.createProperty("treatmentComboBox",this,new DefaultComboBoxModel<String>());
        property.set(comboBoxModel);
        medicViewModel.setTreatmentComboBox(property);
    }
}
