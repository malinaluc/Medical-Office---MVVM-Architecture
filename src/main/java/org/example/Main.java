package org.example;

import org.example.view.LoginForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm loginForm = new LoginForm();
                JFrame frame = new JFrame("Login Form");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(loginForm.getPanel1()); // Add the JPanel from Login to the JFrame
                frame.setSize(700, 700);
                // frame.pack(); // Size the frame to fit its contents
                frame.setLocationRelativeTo(null); // Center the frame on the screen
                frame.setVisible(true); // Make the frame visible
            }

        });
    }

}

