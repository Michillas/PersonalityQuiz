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
                        resultSet.getInt("attitude"),
                        resultSet.getInt("perception"),
                        resultSet.getInt("orientation"),
                        resultSet.getInt("behavior")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

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
                            resultSet.getInt("attitude"),
                            resultSet.getInt("perception"),
                            resultSet.getInt("orientation"),
                            resultSet.getInt("behavior")
                    );
                }
            }
        }
        return null;
    }

    public void createUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (username, mbti, attitude, perception, orientation, behavior) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getMbti());
            statement.setInt(3, usuario.getAttitude());
            statement.setInt(4, usuario.getPerception());
            statement.setInt(5, usuario.getOrientation());
            statement.setInt(6, usuario.getBehavior());
            statement.executeUpdate();
        }
    }

    public void updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET username = ?, mbti = ?, attitude = ?, perception = ?, orientation = ?, behavior = ? WHERE id = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getMbti());
            statement.setInt(3, usuario.getAttitude());
            statement.setInt(4, usuario.getPerception());
            statement.setInt(5, usuario.getOrientation());
            statement.setInt(6, usuario.getBehavior());
            statement.setInt(7, usuario.getId());
            statement.executeUpdate();
        }
    }

    public void deleteUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
