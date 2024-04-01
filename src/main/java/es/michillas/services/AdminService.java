package es.michillas.services;

import es.michillas.DatabaseConnection;
import es.michillas.models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    DatabaseConnection mysql = new DatabaseConnection();
    public List<Admin> getAllAdmins() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM `admin`";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Admin admin = new Admin(
                        resultSet.getString("name"),
                        resultSet.getString("password")
                );
                admins.add(admin);
            }
        }
        return admins;
    }

    public Admin getAdminByName(String name) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE name = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Admin admin = new Admin(
                            resultSet.getString("name"),
                            resultSet.getString("password")
                    );
                }
            }
        }
        return null;
    }

    public void createAdmin(Admin admin) throws SQLException {
        String sql = "INSERT INTO `admin` (name, password) VALUES (?, ?)";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getName());
            statement.setString(2, admin.getPassword());
            statement.executeUpdate();
        }
    }

    public void deleteAdmin(String admin) throws SQLException {
        String sql = "DELETE FROM `admin` WHERE name = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin);
            statement.executeUpdate();
        }
    }
}
