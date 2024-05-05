package org.example.viewmodel.commands;

import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.view.AdminForm;
import org.example.viewmodel.AdminViewModel;

public class CommandDeleteUser implements Command{

    private AdminViewModel adminViewModel;
    private AdminForm adminForm;

    private UserRepository userRepository = new UserRepository();
    public CommandDeleteUser(AdminViewModel adminViewModel, AdminForm adminForm){
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }

    @Override
    public void execute(){
        Integer idUser = Integer.parseInt(adminViewModel.getDeleteIDUserTextField());

        User userToDelete = userRepository.findByID(idUser);
        userRepository.delete(userToDelete);
    }
}
