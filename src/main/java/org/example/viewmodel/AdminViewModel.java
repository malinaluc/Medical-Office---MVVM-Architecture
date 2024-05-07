package org.example.viewmodel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import org.example.view.AdminForm;
import org.example.viewmodel.commands.*;

import javax.swing.*;

public class AdminViewModel {

    public Command viewAllUsersCommand;

    private final Property<String> createUsernameTextField;
    private final Property<String > createPasswordTextField;
    private final Property<String> createRoleTextField;

    private final Property<String> updateUsernameTextField;
    private final Property<String > updatePasswordTextField;
    private final Property<String> updateIDUserTextField;

    private final Property<String> deleteIDUserTextField;

    private final Property<DefaultComboBoxModel<String>> filterByRole ;
    private final Property<String> selectedFilter;

    public Command createUserCommand;
    public Command updateUserCommand;
    public Command deleteUserCommand;

    public Command filterusersCommand;

    public AdminViewModel(AdminForm adminForm){

        createUsernameTextField = PropertyFactory.createProperty("createUsername",this,String.class);
        createPasswordTextField = PropertyFactory.createProperty("createPassword",this,String.class);
        createRoleTextField = PropertyFactory.createProperty("createRole",this, String.class);

        updateUsernameTextField = PropertyFactory.createProperty("updateUsername",this,String.class);
        updatePasswordTextField = PropertyFactory.createProperty("updatePassword",this,String.class);
        updateIDUserTextField = PropertyFactory.createProperty("updateID",this, String.class);

        deleteIDUserTextField = PropertyFactory.createProperty("deleteID",this,String.class);

        filterByRole = PropertyFactory.createProperty("filterByRole",this,new DefaultComboBoxModel<>());
        selectedFilter = PropertyFactory.createProperty("selectedFilter", this,String.class,"");

        viewAllUsersCommand = new CommandViewAllUsers(this,adminForm);
        createUserCommand = new CommandCreateUser(this,adminForm);
        updateUserCommand = new CommandUpdateUser(this,adminForm);
        deleteUserCommand = new CommandDeleteUser(this,adminForm);
        filterusersCommand = new CommandFilterUsers(this,adminForm);
    }

    public String getCreateUsernameTextField() {return createUsernameTextField.get();}

    public String getCreatePasswordTextField() {return createPasswordTextField.get();}

    public String getCreateRoleTextField() {return createRoleTextField.get();}

    public String getUpdateUsernameTextField() {return updateUsernameTextField.get();}

    public String getUpdatePasswordTextField() {return updatePasswordTextField.get();}

    public String getUpdateIDUserTextField() {return updateIDUserTextField.get();}

    public String getDeleteIDUserTextField() {return deleteIDUserTextField.get();}

    public void setSelectedFilter(String selectedFilter){
        this.selectedFilter.set(selectedFilter);
    }

    public String getSelectedFilter() {
        return selectedFilter.get();
    }


}
