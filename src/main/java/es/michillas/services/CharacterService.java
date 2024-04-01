package es.michillas.services;

import es.michillas.DatabaseConnection;
import es.michillas.models.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    DatabaseConnection mysql = new DatabaseConnection();
    public List<Character> getAllCharacters() throws SQLException {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT * FROM `character`";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Character character = new Character(
                        resultSet.getString("name"),
                        resultSet.getString("mbti"),
                        resultSet.getString("img")
                );
                characters.add(character);
            }
        }
        return characters;
    }

    public List<Character> getCharactersByMbti(String type) throws SQLException {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT * FROM `character` WHERE mbti = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Character character = new Character(
                            resultSet.getString("name"),
                            resultSet.getString("mbti"),
                            resultSet.getString("img")
                    );
                    characters.add(character);
                }
            }
        }
        return characters;
    }

    public void createCharacter(Character character) throws SQLException {
        String sql = "INSERT INTO `character` (name, mbti, img) VALUES (?, ?, ?)";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, character.getName());
            statement.setString(2, character.getMbti());
            statement.setString(3, character.getImg());
            statement.executeUpdate();
        }
    }

    public void deleteCharacter(String character) throws SQLException {
        String sql = "DELETE FROM `character` WHERE name = ?";
        try (Connection connection = mysql.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, character);
            statement.executeUpdate();
        }
    }
}
