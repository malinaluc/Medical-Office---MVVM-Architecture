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

public class CommandAsistentPopulateDiagnosticCombobox implements Command{

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentPopulateDiagnosticCombobox(AsistentViewModel asistentViewModel, AsistentForm asistentForm){
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute(){

        DefaultComboBoxModel<String> comboBoxModel = asistentViewModel.getFilterDiagnosticComboBox();

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();
        Integer idUserLoggedIn = loggedInUser.getIdUserLoggedIn();
        List<MedicalRecord> allFisaMedicala = medicalRecordRepository.allMedicalRecordByUserId(idUserLoggedIn);

        HashSet<String> diagnostics = new HashSet<>();

        for (MedicalRecord fisaMedicala : allFisaMedicala) {
            diagnostics.add(fisaMedicala.getDiagnostic());
        }

        if (diagnostics != null) {
            for (String diagnostic : diagnostics) {
                comboBoxModel.addElement(diagnostic);
            }
        }

        Property<DefaultComboBoxModel<String>> property = PropertyFactory.createProperty("filterDiagnosticComboBox",this,new DefaultComboBoxModel<String>());
        property.set(comboBoxModel);
        asistentViewModel.setFilterDiagnosticComboBox(property);
    }

}

