package org.example.viewmodel.commands;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

import javax.swing.*;
import java.util.List;

public class CommandFilterUsers implements Command{

    private final AdminViewModel adminViewModel;
    private final AdminForm adminForm;

    private final UserRepository userRepository = new UserRepository();

    public CommandFilterUsers(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }


    @Override
    public void execute(){
        String selectedRole = adminViewModel.getSelectedFilter();
        Integer role ;
        if(selectedRole.equals("Admin")) role = 1;
        else if(selectedRole.equals("Medic")) role = 2;
        else role =3;

        adminForm.getFiltrareUtilizatoriTextArea().setText("");

        List<User> allUsers = userRepository.allUsersByUserTypeID(role);

        for(User user : allUsers){
            adminForm.getFiltrareUtilizatoriTextArea().append("Username : " + user.getUsername() + "\n");
        }
    }


}
