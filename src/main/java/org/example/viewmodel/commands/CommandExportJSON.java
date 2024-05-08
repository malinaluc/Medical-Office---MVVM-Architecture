package org.example.viewmodel.commands;

//import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CommandExportJSON implements Command {

    @Override
    public void execute() {
        String url = "jdbc:mysql://127.0.0.1:3306/cabinetmedicalMVVM";
        String user = "root";
        String password = "cutucutumiau";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM medic")) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
//            Gson gson = new Gson();
            StringBuilder json = new StringBuilder("[");

            while (rs.next()) {
                json.append("{");
                for (int i = 1; i <= numColumns; i++) {
                    String column = rsmd.getColumnName(i);
                    Object value = rs.getObject(i);
                    json.append("\"").append(column).append("\":\"").append(value).append("\"");
                    if (i < numColumns) {
                        json.append(",");
                    }
                }
                json.append("}");
                if (!rs.isLast()) {
                    json.append(",");
                }
            }
            json.append("]");

            // Do something with the JSON string, for example, print it or write it to a file
            System.out.println(json);

            // Or write it to a file
            try (FileWriter writer = new FileWriter("data.json")) {
                writer.write(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
