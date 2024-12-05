package org.example.viewmodel.commands;

import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

public class CommandUpdateUser implements Command{
    private final AdminViewModel adminViewModel;
    private final AdminForm adminForm;

    private final UserRepository userRepository = new UserRepository();

    public CommandUpdateUser(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }


    @Override
    public void execute(){

        Integer IDuser = Integer.parseInt(adminViewModel.getUpdateIDUserTextField());
        String username = adminViewModel.getUpdateUsernameTextField();
        String password = adminViewModel.getUpdatePasswordTextField();

        User existingUser = userRepository.findByID(IDuser);

        Integer rol = existingUser.getRole();

        User newUser = new User(IDuser, username, password, rol);

        userRepository.update(newUser);
}
}