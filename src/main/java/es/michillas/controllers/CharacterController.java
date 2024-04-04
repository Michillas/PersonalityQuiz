package es.michillas.controllers;

import es.michillas.models.Character;
import es.michillas.services.CharacterService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/list")
    public ResponseEntity<List<Character>> getAllCharacters() {
        try {
            List<Character> character = characterService.getAllCharacters();
            return ResponseEntity.ok().body(character);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<Character>> getCharactersByMbti(@PathVariable("type") String type) {
        try {
            List<Character> Characters = characterService.getCharactersByMbti(type);
            return ResponseEntity.ok().body(Characters);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public void createCharacter(@ModelAttribute Character character) {
        try {
            characterService.createCharacter(character);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete")
    public void deleteCharacter(@RequestParam String character) {
        try {
            characterService.deleteCharacter(character);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }
}
