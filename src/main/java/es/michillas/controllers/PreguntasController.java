package es.michillas.controllers;

import es.michillas.models.Pregunta;
import es.michillas.services.PreguntasService;

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
@RequestMapping("/preguntas")
public class PreguntasController {

    @Autowired
    private PreguntasService preguntasService;

    @GetMapping("/list")
    public ResponseEntity<List<Pregunta>> getAllPreguntas() {
        try {
            List<Pregunta> preguntas = preguntasService.getAllQuestions();
            return ResponseEntity.ok().body(preguntas);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<Pregunta>> getPreguntasByType(@PathVariable("type") String type) {
        try {
            List<Pregunta> preguntas = preguntasService.getQuestionsByType(type);
            return ResponseEntity.ok().body(preguntas);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public void createPregunta(@ModelAttribute Pregunta pregunta) {
        try {
            preguntasService.createQuestion(pregunta);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete")
    public void deletePregunta(@RequestParam String question) {
        try {
            preguntasService.deleteQuestion(question);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }
}
