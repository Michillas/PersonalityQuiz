package es.michillas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    String url = loadURLFromEnv();
    String user = loadUsernameFromEnv();
    String pass = loadPasswordFromEnv();

    Connection connection;

    public Connection connect(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }

    private String loadPasswordFromEnv() {
        try (BufferedReader br = new BufferedReader(new FileReader("./.env"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("DB_PASSWORD")) {
                    return line.split("=")[1].trim().replaceAll("^\"|\"$", "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String loadUsernameFromEnv() {
        try (BufferedReader br = new BufferedReader(new FileReader("./.env"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("DB_USERNAME")) {
                    return line.split("=")[1].trim().replaceAll("^\"|\"$", "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String loadURLFromEnv() {
        try (BufferedReader br = new BufferedReader(new FileReader("./.env"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("DB_URL")) {
                    return line.split("=")[1].trim().replaceAll("^\"|\"$", "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
