package org.example.viewmodel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import org.example.view.AdminForm;
import org.example.viewmodel.commands.Command;
import org.example.viewmodel.commands.CommandCreateUser;

import org.example.viewmodel.commands.CommandUpdateUser;
import org.example.viewmodel.commands.CommandViewAllUsers;

public class AdminViewModel {

    public Command viewAllUsersCommand;

    private final Property<String> createUsernameTextField;
    private final Property<String > createPasswordTextField;
    private final Property<String> createRoleTextField;

    private final Property<String> updateUsernameTextField;
    private final Property<String > updatePasswordTextField;
    private final Property<String> updateIDUserTextField;

    public Command createUserCommand;
    public Command updateUserCommand;

    public AdminViewModel(AdminForm adminForm){

        createUsernameTextField = PropertyFactory.createProperty("createUsername",this,String.class);
        createPasswordTextField = PropertyFactory.createProperty("createPassword",this,String.class);
        createRoleTextField = PropertyFactory.createProperty("createRole",this, String.class);

        updateUsernameTextField = PropertyFactory.createProperty("updateUsername",this,String.class);
        updatePasswordTextField = PropertyFactory.createProperty("updatePassword",this,String.class);
        updateIDUserTextField = PropertyFactory.createProperty("updateID",this, String.class);


        viewAllUsersCommand = new CommandViewAllUsers(this,adminForm);
        createUserCommand = new CommandCreateUser(this,adminForm);
        updateUserCommand = new CommandUpdateUser(this,adminForm);

    }

    public String getCreateUsernameTextField() {return createUsernameTextField.get();}

    public String getCreatePasswordTextField() {return createPasswordTextField.get();}

    public String getCreateRoleTextField() {return createRoleTextField.get();}

    public String getUpdateUsernameTextField() {return updateUsernameTextField.get();}

    public String getUpdatePasswordTextField() {return updatePasswordTextField.get();}

    public String getUpdateIDUserTextField() {return updateIDUserTextField.get();}


}
