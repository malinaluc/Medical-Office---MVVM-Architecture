package org.example.viewmodel.commands;

import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

import javax.swing.*;
import java.util.List;

public class CommandViewAllUsers implements Command{

    private final AdminViewModel adminViewModel;
    private final AdminForm adminForm;

    private final UserRepository userRepository = new UserRepository();

    public CommandViewAllUsers(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;

    }
    @Override
    public void execute(){

        adminForm.getVizualizareUtilizatoriTextArea().setText("");
        List<User> allUsers = userRepository.readAll();
        for(User user : allUsers){
            String rol = (user.getRole() == 1) ? "administrator" : (user.getRole() == 2) ? "medic" : "asistent";
            adminForm.getVizualizareUtilizatoriTextArea().append("ID User: " + user.getIdUser() + "\n" + "Username: " + user.getUsername() + "\n" + "Password: " + user.getPassword() + "\n" + "Rol: " + rol + "\n" + "\n");
        }
    }
}
