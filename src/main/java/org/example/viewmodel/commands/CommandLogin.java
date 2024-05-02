package org.example.viewmodel.commands;

import org.example.viewmodel.LoginViewModel;

public class CommandLogin implements Command {

    private LoginViewModel loginViewModel;

    public CommandLogin(){

    }
    public CommandLogin(LoginViewModel loginViewModel){
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void execute(){

    }



}
