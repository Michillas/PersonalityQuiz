package es.michillas.service;

import es.michillas.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to retrieve all usuarios from the database
    public List<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM usuarios";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("mbti"),
                    resultSet.getInt("focus"),
                    resultSet.getInt("information"),
                    resultSet.getInt("decisions"),
                    resultSet.getInt("outerlife")
            );
        });
    }

    // Method to retrieve a usuario by its ID from the database
    public Usuario getUsuarioById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            return new Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("mbti"),
                    resultSet.getInt("focus"),
                    resultSet.getInt("information"),
                    resultSet.getInt("decisions"),
                    resultSet.getInt("outerlife")
            );
        });
    }

    // Method to create a new usuario in the database
    public void createUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, mbti, focus, information, decisions, outerlife) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getMbti(), usuario.getFocus(), usuario.getInformation(), usuario.getDecisions(), usuario.getOuterlife());
    }

    // Method to update an existing usuario in the database
    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET username = ?, mbti = ?, focus = ?, information = ?, decisions = ?, outerlife = ? WHERE id = ?";
        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getMbti(), usuario.getFocus(), usuario.getInformation(), usuario.getDecisions(), usuario.getOuterlife(), usuario.getId());
    }

    // Method to delete a usuario by its ID from the database
    public void deleteUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}