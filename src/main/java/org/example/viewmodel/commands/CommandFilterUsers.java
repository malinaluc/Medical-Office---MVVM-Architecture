package org.example.viewmodel.commands;

import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

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
        addItemsComboBox();
        filterUsersByRole();
    }

    void addItemsComboBox(){
        adminViewModel.setSelectedFilter("Medic");
        adminViewModel.setSelectedFilter("Asistent");
    }

    void filterUsersByRole(){

        String role = adminViewModel.getSelectedFilter();
        System.out.println("ROL CMBOBOX : " + role);

    }
}
