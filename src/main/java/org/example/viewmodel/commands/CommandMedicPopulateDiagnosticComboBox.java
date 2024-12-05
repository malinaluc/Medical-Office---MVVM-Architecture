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

public class CommandMedicPopulateDiagnosticComboBox implements Command{
    private final MedicViewModel medicViewModel;
    private final MedicForm medicForm;
    private final MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandMedicPopulateDiagnosticComboBox(MedicViewModel medicViewModel, MedicForm medicForm){
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }
    @Override
    public void execute(){

        DefaultComboBoxModel<String> comboBoxModel = medicViewModel.getDiagnosticComboBox();

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();
        Integer idUserLoggedIn = loggedInUser.getIdUserLoggedIn();
        List<MedicalRecord> allFisaMedicala = medicalRecordRepository.allMedicalRecordByMedicID(loggedInUser.getIdUserLoggedIn());

        HashSet<String> diagnostics = new HashSet<>();

        for (MedicalRecord fisaMedicala : allFisaMedicala) {
            diagnostics.add(fisaMedicala.getDiagnostic());
        }

        if (diagnostics != null) {
            for (String diagnostic : diagnostics) {
                comboBoxModel.addElement(diagnostic);
            }
        }

        Property<DefaultComboBoxModel<String>> property = PropertyFactory.createProperty("diagnosticComboBox",this,new DefaultComboBoxModel<String>());
        property.set(comboBoxModel);
        medicViewModel.setDiagnosticComboBox(property);
    }

}
