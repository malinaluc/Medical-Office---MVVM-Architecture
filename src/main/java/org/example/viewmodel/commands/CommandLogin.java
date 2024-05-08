package org.example.viewmodel.commands;

import org.example.model.entity.User;
import org.example.model.repository.UserRepository;
import org.example.utils.SessionManager;
import org.example.view.AdminForm;
import org.example.view.AsistentForm;
import org.example.view.LoginForm;
import org.example.view.MedicForm;
import org.example.viewmodel.LoginViewModel;

import javax.swing.*;

import static org.example.utils.ExtensionFunctions.logDebug;

public class CommandLogin implements Command {

    private final LoginViewModel loginViewModel;
    private final LoginForm loginForm;

    private final UserRepository userRepository = new UserRepository();

    public CommandLogin(LoginViewModel loginViewModel, LoginForm loginForm) {
        this.loginViewModel = loginViewModel;
        this.loginForm = loginForm;

        System.out.println("Login Form : " + loginForm);
    }

    @Override
    public void execute(){

        System.out.println("Executing CommandLogin .... ");

        String username = loginViewModel.getUsernameTextField();
        String password = loginViewModel.getPasswordTextField();

        User user = userRepository.getUserByEmailAndPassword(username, password);

        logDebug("Username = " + username + " and Password = " + password);

        if (user != null) {

            SessionManager.loginUser(user.getIdUser(), user.getUsername(), user.getPassword());
            if (user.getRole() == 2) showMedicForm();
            else if (user.getRole() == 1) showAdminForm();
            else showAsistentForm();
            System.out.println(user.getUsername() + " " + user.getPassword());

        } else
            JOptionPane.showMessageDialog(null, "Wrong username or password", "Error Message", JOptionPane.INFORMATION_MESSAGE);


    }

    public void showAdminForm() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginForm.getPanel1());
        frame.setVisible(false);
        AdminForm adminForm = new AdminForm();
        JFrame adminFrame = new JFrame("Admin Form");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.getContentPane().add(adminForm.getPanel1());
        adminFrame.setSize(700, 700);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);
        adminForm.populateComboBox();


    }

    public void showMedicForm() {

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginForm.getPanel1());
        frame.setVisible(false);
        MedicForm medicForm = new MedicForm();
        JFrame medicFrame = new JFrame("Medic Form");
        medicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        medicFrame.getContentPane().add(medicForm.getPanel1());
        medicFrame.setSize(700, 700);
        medicFrame.setLocationRelativeTo(null);
        medicFrame.setVisible(true);
        medicForm.populateTreatmentComboBox();
        medicForm.populateDiagnosticComboBoz();
    }

    public void showAsistentForm() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginForm.getPanel1());
        frame.setVisible(false);
        AsistentForm asistentForm = new AsistentForm();
        JFrame asistentFrame = new JFrame("Asistent Frame");
        asistentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asistentFrame.getContentPane().add(asistentForm.getPanel1());
        asistentFrame.setSize(700, 700);
        asistentFrame.setLocationRelativeTo(null);
        asistentFrame.setVisible(true);

    }



}
