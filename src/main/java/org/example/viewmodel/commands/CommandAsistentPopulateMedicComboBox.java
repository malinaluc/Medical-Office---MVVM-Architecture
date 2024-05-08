package org.example.viewmodel.commands;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.model.entity.Medic;
import org.example.model.entity.MedicalRecord;
import org.example.model.repository.MedicRepository;
import org.example.model.repository.MedicalRecordRepository;
import org.example.utils.LoggedInUser;
import org.example.utils.SessionManager;
import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;
import org.hibernate.Hibernate;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommandAsistentPopulateMedicComboBox implements Command{
    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    MedicRepository medicRepository = new MedicRepository();
    MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

    public CommandAsistentPopulateMedicComboBox(AsistentViewModel asistentViewModel, AsistentForm asistentForm){
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute(){

        DefaultComboBoxModel<String>comboBoxModel = asistentViewModel.getFilterMedicComboBox();

        LoggedInUser loggedInUser = SessionManager.getLoggedInUser();
        Integer idUserLoggedIn = loggedInUser.getIdUserLoggedIn();
        List<MedicalRecord> allMedicalRecords = medicalRecordRepository.allMedicalRecordByUserId(idUserLoggedIn);

        Set<Medic> medics = new HashSet<>();
        for (MedicalRecord fisaMedicala : allMedicalRecords) {
            var medicTemp = fisaMedicala.getIdMedic();
            medics.add(fisaMedicala.getIdMedic());
        }
        for (Medic medic : medics) {
            comboBoxModel.addElement(medic.getIdMedic().toString());
        }

        Property<DefaultComboBoxModel<String>> property = PropertyFactory.createProperty("filterMedicComboBox",this,new DefaultComboBoxModel<String>());
        property.set(comboBoxModel);
        asistentViewModel.setFilterMedicComboBox(property);

    }
}
