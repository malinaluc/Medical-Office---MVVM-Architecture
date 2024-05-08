package org.example.viewmodel.commands;

import org.example.utils.SessionManager;
import org.example.view.AdminForm;
import org.example.view.LoginForm;
import org.example.viewmodel.AdminViewModel;

import javax.swing.*;

public class CommandAdminLogOut implements Command {

    AdminForm adminForm;
    AdminViewModel adminViewModel;

    public CommandAdminLogOut(AdminViewModel adminViewModel, AdminForm adminForm) {
        this.adminViewModel = adminViewModel;
        this.adminForm = adminForm;
    }

    @Override
    public void execute() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adminForm.getPanel1());
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
