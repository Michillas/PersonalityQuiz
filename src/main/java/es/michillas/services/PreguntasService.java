package es.michillas.services;

import es.michillas.DatabaseConnection;
import es.michillas.models.Pregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PreguntasService {

    DatabaseConnection mysql = new DatabaseConnection();

    public List<Pregunta> getAllQuestions() throws SQLException {
        List<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM preguntas";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pregunta pregunta = new Pregunta(
                        resultSet.getString("question"),
                        resultSet.getString("type")
                );
                preguntas.add(pregunta);
            }
        }
        return preguntas;
    }

    public List<Pregunta> getQuestionsByType(String type) throws SQLException {
        List<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM preguntas WHERE type = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pregunta pregunta = new Pregunta(
                            resultSet.getString("question"),
                            resultSet.getString("type")
                    );
                    preguntas.add(pregunta);
                }
            }
        }
        return preguntas;
    }

    public void createQuestion(Pregunta pregunta) throws SQLException {
        String sql = "INSERT INTO preguntas (question, type) VALUES (?, ?)";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pregunta.getQuestion());
            statement.setString(2, pregunta.getType());
            statement.executeUpdate();
        }
    }

    public void deleteQuestion(String question) throws SQLException {
        String sql = "DELETE FROM preguntas WHERE question = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, question);
            statement.executeUpdate();
        }
    }
}
