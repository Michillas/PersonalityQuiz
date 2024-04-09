package es.michillas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    String url = "jdbc:mysql://localhost:3306/personalityquiz?allowPublicKeyRetrieval=true";
    String user = "root";
    String pass = "";

    Connection connection;

    public Connection connect(){
        try {
            connection = DriverManager.getConnection(url, user,pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }
}
