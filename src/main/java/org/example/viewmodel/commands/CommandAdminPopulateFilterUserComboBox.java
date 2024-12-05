package org.example.viewmodel.commands;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

import javax.swing.*;

public class CommandAdminPopulateFilterUserComboBox implements Command{
    private final AdminViewModel adminViewModel;
    private final AdminForm adminForm;

    public CommandAdminPopulateFilterUserComboBox(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }

    @Override
    public void execute(){
        DefaultComboBoxModel<String> comboBoxModel = adminViewModel.getFiltrareUsersComboBox();
        comboBoxModel.addElement("Admin");
        comboBoxModel.addElement("Medic");
        comboBoxModel.addElement("Asistent");
        Property<DefaultComboBoxModel<String>> property = PropertyFactory.createProperty("filtrareUsersComboBox", this, new DefaultComboBoxModel<String>());
        property.set(comboBoxModel);
        adminViewModel.setFiltrareUsersComboBox(property);
    }
}
