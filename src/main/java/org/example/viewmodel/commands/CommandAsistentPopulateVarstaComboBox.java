package org.example.viewmodel.commands;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicalRecordRepository;
import org.example.utils.LoggedInUser;
import org.example.utils.SessionManager;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;

public class CommandAsistentPopulateVarstaComboBox implements Command {
    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentPopulateVarstaComboBox(AsistentViewModel asistentViewModel, AsistentForm asistentForm){
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute(){

        DefaultComboBoxModel<String> comboBoxModel = asistentViewModel.getFilterVarstaComboBox();

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();
        Integer idUserLoggedIn = loggedInUser.getIdUserLoggedIn();

        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.allMedicalRecordByUserId(idUserLoggedIn);



        HashSet<Integer> ages = new HashSet<>();

        for (MedicalRecord fisaMedicala : allMedicalRecords) {
            ages.add(fisaMedicala.getPatientAge());
        }
        if (ages != null) {
            for (Integer age : ages) {
               comboBoxModel.addElement(age.toString());
            }
        }

        Property<DefaultComboBoxModel<String>> property = PropertyFactory.createProperty("filterVarstaComboBox",this,new DefaultComboBoxModel<String>());
        property.set(comboBoxModel);
        asistentViewModel.setFilterVarstaComboBox(property);

    }

}
