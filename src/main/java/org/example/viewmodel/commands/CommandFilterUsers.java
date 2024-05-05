package org.example.viewmodel.commands;

import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

public class CommandFilterUsers implements Command{

    private AdminViewModel adminViewModel;
    private AdminForm adminForm;

    private UserRepository userRepository = new UserRepository();

    public CommandFilterUsers(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }


    @Override
    public void execute(){
        addItemsComboBox();
        filterUsersByRole();
    }

    void addItemsComboBox(){
        adminViewModel.setFiltrateUsersComboBox("Medic");
        adminViewModel.setFiltrateUsersComboBox("Asistent");
    }

    void filterUsersByRole(){

        String role = adminViewModel.getFiltrateUsersComboBox();
        System.out.println("ROL CMBOBOX : " + role);

    }
}
