package org.example.viewmodel.commands;

import org.example.utils.SessionManager;
import org.example.view.LoginForm;
import org.example.view.MedicForm;
import org.example.viewmodel.MedicViewModel;

import javax.swing.*;

public class CommandMedicLogOut implements Command {

    private final MedicViewModel medicViewModel;
    private final MedicForm medicForm;

    public CommandMedicLogOut(MedicViewModel medicViewModel, MedicForm medicForm) {
        this.medicViewModel = medicViewModel;
        this.medicForm = medicForm;
    }

    @Override
    public void execute() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(medicForm.getPanel1());
        frame.setVisible(false);
        LoginForm loginForm = new LoginForm();
        JFrame loginFrame = new JFrame("Login Form");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().add(loginForm.getPanel1()); // Add the JPanel from Login to the JFrame
        loginFrame.setSize(700, 700);
        loginFrame.setLocationRelativeTo(null); // Center the frame on the screen
        loginFrame.setVisible(true); // Make the frame visible

        SessionManager.logOutUser();

    }


}
