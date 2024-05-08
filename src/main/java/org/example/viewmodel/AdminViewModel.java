package org.example.viewmodel;

import mvvm.properties.Property;
import mvvm.properties.PropertyFactory;
import org.example.view.AdminForm;
import org.example.viewmodel.commands.*;

import javax.swing.*;
import java.util.List;

public class AdminViewModel {

    private final Property<String> createUsernameTextField;
    private final Property<String> createPasswordTextField;
    private final Property<String> createRoleTextField;
    private final Property<String> updateUsernameTextField;
    private final Property<String> updatePasswordTextField;
    private final Property<String> updateIDUserTextField;
    private final Property<String> deleteIDUserTextField;
    private Property<DefaultComboBoxModel<String>> filtrareUsersComboBox;
    private String selectedFilter;
    public Command viewAllUsersCommand;
    public Command createUserCommand;
    public Command updateUserCommand;
    public Command deleteUserCommand;
    public Command populateUserTypeComboBox;
    public Command filterusersCommand;

    public Command logOutCommand;

    public AdminViewModel(AdminForm adminForm) {

        createUsernameTextField = PropertyFactory.createProperty("createUsername", this, String.class);
        createPasswordTextField = PropertyFactory.createProperty("createPassword", this, String.class);
        createRoleTextField = PropertyFactory.createProperty("createRole", this, String.class);

        updateUsernameTextField = PropertyFactory.createProperty("updateUsername", this, String.class);
        updatePasswordTextField = PropertyFactory.createProperty("updatePassword", this, String.class);
        updateIDUserTextField = PropertyFactory.createProperty("updateID", this, String.class);

        deleteIDUserTextField = PropertyFactory.createProperty("deleteID", this, String.class);

       /* filterByRole = PropertyFactory.createProperty("filterByRole", this, new DefaultComboBoxModel<>());
        selectedFilter = PropertyFactory.createProperty("selectedFilter", this, String.class, "");
*/
        filtrareUsersComboBox = PropertyFactory.createProperty("filtrareUsersComboBox", this, new DefaultComboBoxModel<>());


        viewAllUsersCommand = new CommandViewAllUsers(this, adminForm);
        createUserCommand = new CommandCreateUser(this, adminForm);
        updateUserCommand = new CommandUpdateUser(this, adminForm);
        deleteUserCommand = new CommandDeleteUser(this, adminForm);
        filterusersCommand = new CommandFilterUsers(this, adminForm);
        logOutCommand = new CommandAdminLogOut(this, adminForm);
        populateUserTypeComboBox = new CommandAdminPopulateFilterUserComboBox(this,adminForm);
    }

    public String getCreateUsernameTextField() {
        return createUsernameTextField.get();
    }

    public String getCreatePasswordTextField() {
        return createPasswordTextField.get();
    }

    public String getCreateRoleTextField() {
        return createRoleTextField.get();
    }

    public String getUpdateUsernameTextField() {
        return updateUsernameTextField.get();
    }

    public String getUpdatePasswordTextField() {
        return updatePasswordTextField.get();
    }

    public String getUpdateIDUserTextField() {
        return updateIDUserTextField.get();
    }

    public String getDeleteIDUserTextField() {
        return deleteIDUserTextField.get();
    }

    public String getSelectedFilter() {
        return selectedFilter;
    }

    public void setSelectedFilter(String selectedFilter) {
        this.selectedFilter = selectedFilter;
    }

    public DefaultComboBoxModel<String> getFiltrareUsersComboBox() {
        return filtrareUsersComboBox.get();
    }


    public void setFiltrareUsersComboBox(Property<DefaultComboBoxModel<String>> filtrareUsersComboBox) {
        this.filtrareUsersComboBox = filtrareUsersComboBox;
    }

}
