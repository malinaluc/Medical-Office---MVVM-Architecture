package org.example.viewmodel.commands;

import org.example.view.AsistentForm;
import org.example.viewmodel.AsistentViewModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CommandExportDOC implements Command{
    private final AsistentViewModel asistentViewModel;
    private final AsistentForm asistentForm;

    public CommandExportDOC(AsistentViewModel asistentViewModel, AsistentForm asistentForm) {
        this.asistentViewModel = asistentViewModel;
        this.asistentForm = asistentForm;

    }
    @Override
    public void execute(){
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/cabinetmedicalMVVM";
        String username = "root";
        String password = "cutucutumiau";

        String docFilePath = "Medic_exports.doc";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM medic";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(docFilePath));

            // Write header line containing column names
            fileWriter.write("idMedic\tname\tsurname\tidUser\tstartTimeProgram\tendTimeProgram");
            fileWriter.newLine();

            // Write data to the file
            while (result.next()) {
                Integer idMedic = result.getInt("idMedic");
                String name = result.getString("name");
                String surname = result.getString("surname");
                Integer idUser = result.getInt("idUser");
                Integer startTimeProgram = result.getInt("startTimeProgram");
                Integer endTimeProgram = result.getInt("endTimeProgram");

                String line = String.format("%d\t%s\t%s\t%d\t%d\t%d",
                        idMedic, name, surname, idUser, startTimeProgram, endTimeProgram);

                fileWriter.write(line);
                fileWriter.newLine();
            }

            statement.close();
            fileWriter.close();

            System.out.println("Data exported successfully to " + docFilePath);

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }

    }
}

