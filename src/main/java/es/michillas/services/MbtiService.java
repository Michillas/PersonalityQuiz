package es.michillas.services;

import es.michillas.DatabaseConnection;
import es.michillas.models.Mbti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.michillas.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class MbtiService {

    DatabaseConnection mysql = new DatabaseConnection();
    public List<Mbti> getAllMbtis() throws SQLException {
        List<Mbti> mbtiList = new ArrayList<>();
        String sql = "SELECT * FROM `mbti`";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Mbti mbti = new Mbti(
                        resultSet.getString("mbti"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                mbtiList.add(mbti);
            }
        }
        return mbtiList;
    }

    public Mbti getMbtiByMbti(String mbti) throws SQLException {
        String sql = "SELECT * FROM `mbti` WHERE mbti = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mbti);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Mbti(
                            resultSet.getString("mbti"),
                            resultSet.getString("name"),
                            resultSet.getString("description")
                    );
                } else {
                    return null; // MBTI not found
                }
            }
        }
    }

    public void createMbti(Mbti mbti) throws SQLException {
        String sql = "INSERT INTO `mbti` (mbti, name, description) VALUES (?, ?, ?)";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mbti.getLetters());
            statement.setString(2, mbti.getName());
            statement.setString(3, mbti.getDescription());
            statement.executeUpdate();
        }
    }

    public void deleteMbti(String mbti) throws SQLException {
        String sql = "DELETE FROM `mbti` WHERE name = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mbti);
            statement.executeUpdate();
        }
    }
}
