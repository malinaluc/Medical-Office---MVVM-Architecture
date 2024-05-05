package org.example.viewmodel;


import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import org.example.view.LoginForm;
import org.example.viewmodel.commands.Command;
import org.example.viewmodel.commands.CommandLogin;

public class LoginViewModel {

    private final Property<String> usernameTextField;
    private final Property<String> passwordTextField;
    public Command loginCommand;

    public LoginViewModel(LoginForm loginForm){

        usernameTextField = PropertyFactory.createProperty("username",this,String.class);
        passwordTextField = PropertyFactory.createProperty("password",this,String.class);

        loginCommand = new CommandLogin(this,loginForm);

    }
    public String getUsernameTextField(){
        return usernameTextField.get();
    }
    public String getPasswordTextField() {
        return passwordTextField.get();
    }

}
