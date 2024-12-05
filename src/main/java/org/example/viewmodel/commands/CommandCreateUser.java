package org.example.viewmodel.commands;

import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

public class CommandCreateUser implements Command{
    private final AdminViewModel adminViewModel;
    private final AdminForm adminForm;

    private final UserRepository userRepository = new UserRepository();

    public CommandCreateUser(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }

    @Override
    public void execute(){

        String username = adminViewModel.getCreateUsernameTextField();
        String password = adminViewModel.getCreatePasswordTextField();
        Integer role = Integer.parseInt(adminViewModel.getCreateRoleTextField());

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        userRepository.save(newUser);
    }
}
