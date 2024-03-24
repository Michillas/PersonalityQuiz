package es.michillas.services;

import es.michillas.DatabaseConnection;
import es.michillas.models.Preguntas;

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

    public List<Preguntas> getAllQuestions() throws SQLException {
        List<Preguntas> preguntasList = new ArrayList<>();
        String sql = "SELECT * FROM preguntas";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Preguntas pregunta = new Preguntas(
                        resultSet.getString("question"),
                        resultSet.getString("type")
                );
                preguntasList.add(pregunta);
            }
        }
        return preguntasList;
    }

    public List<Preguntas> getQuestionsByType(String type) throws SQLException {
        List<Preguntas> preguntasList = new ArrayList<>();
        String sql = "SELECT * FROM preguntas WHERE type = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Preguntas pregunta = new Preguntas(
                            resultSet.getString("question"),
                            resultSet.getString("type")
                    );
                    preguntasList.add(pregunta);
                }
            }
        }
        return preguntasList;
    }

    public void createQuestion(Preguntas pregunta) throws SQLException {
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
