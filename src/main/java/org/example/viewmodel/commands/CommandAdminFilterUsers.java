package org.example.viewmodel.commands;

import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

import java.util.List;

public class CommandAdminFilterUsers implements Command{

    private final AdminViewModel adminViewModel;
    private final AdminForm adminForm;

    private final UserRepository userRepository = new UserRepository();

    public CommandAdminFilterUsers(AdminViewModel adminViewModel, AdminForm adminForm){
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
