package org.example.viewmodel.commands;

import org.example.utils.SessionManager;
import org.example.view.AsistentForm;
import org.example.view.LoginForm;
import org.example.viewmodel.AsistentViewModel;

import javax.swing.*;

public class CommandAsistentLogOut implements Command {

    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    public CommandAsistentLogOut(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;
    }

    @Override
    public void execute() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(asistentForm.getPanel1());
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
