package es.michillas.services;

import es.michillas.DatabaseConnection;
import es.michillas.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    DatabaseConnection mysql = new DatabaseConnection();

    // Method to retrieve all usuarios from the database
    public List<Usuario> getAllUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("mbti"),
                        resultSet.getInt("focus"),
                        resultSet.getInt("information"),
                        resultSet.getInt("decisions"),
                        resultSet.getInt("outerlife")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Method to retrieve a usuario by its ID from the database
    public Usuario getUsuarioById(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection connection = mysql.connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Usuario(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("mbti"),
                            resultSet.getInt("focus"),
                            resultSet.getInt("information"),
                            resultSet.getInt("decisions"),
                            resultSet.getInt("outerlife")
                    );
                }
            }
        }
        return null; // Return null if no usuario found with the given id
    }

    // Method to create a new usuario in the database
    public void createUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (username, mbti, focus, information, decisions, outerlife) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getMbti());
            statement.setInt(3, usuario.getFocus());
            statement.setInt(4, usuario.getInformation());
            statement.setInt(5, usuario.getDecisions());
            statement.setInt(6, usuario.getOuterlife());
            statement.executeUpdate();
        }
    }

    // Method to update an existing usuario in the database
    public void updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET username = ?, mbti = ?, focus = ?, information = ?, decisions = ?, outerlife = ? WHERE id = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getMbti());
            statement.setInt(3, usuario.getFocus());
            statement.setInt(4, usuario.getInformation());
            statement.setInt(5, usuario.getDecisions());
            statement.setInt(6, usuario.getOuterlife());
            statement.setInt(7, usuario.getId());
            statement.executeUpdate();
        }
    }

    // Method to delete a usuario by its ID from the database
    public void deleteUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
