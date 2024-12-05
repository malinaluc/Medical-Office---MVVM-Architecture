package org.example.viewmodel.commands;

import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CommandExportXML implements Command{
    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    public CommandExportXML(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;

    }
    @Override
    public void execute(){
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/cabinetmedicalMVVM";
        String username = "root";
        String password = "cutucutumiau";

        String xmlFilePath = "Medic_exports.xml";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM medic";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(xmlFilePath));

            // Write XML header
            fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            fileWriter.newLine();
            fileWriter.write("<medics>");
            fileWriter.newLine();

            // Write data to the XML file
            while (result.next()) {
                Integer idMedic = result.getInt("idMedic");
                String name = result.getString("name");
                String surname = result.getString("surname");
                Integer idUser = result.getInt("idUser");
                Integer startTimeProgram = result.getInt("startTimeProgram");
                Integer endTimeProgram = result.getInt("endTimeProgram");

                // Format data into XML
                fileWriter.write("  <medic>");
                fileWriter.newLine();
                fileWriter.write("    <idMedic>" + idMedic + "</idMedic>");
                fileWriter.newLine();
                fileWriter.write("    <name>" + name + "</name>");
                fileWriter.newLine();
                fileWriter.write("    <surname>" + surname + "</surname>");
                fileWriter.newLine();
                fileWriter.write("    <idUser>" + idUser + "</idUser>");
                fileWriter.newLine();
                fileWriter.write("    <startTimeProgram>" + startTimeProgram + "</startTimeProgram>");
                fileWriter.newLine();
                fileWriter.write("    <endTimeProgram>" + endTimeProgram + "</endTimeProgram>");
                fileWriter.newLine();
                fileWriter.write("  </medic>");
                fileWriter.newLine();
            }

            // Close XML tags
            fileWriter.write("</medics>");

            statement.close();
            fileWriter.close();

            System.out.println("Data exported successfully to " + xmlFilePath);

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }


    }
}
