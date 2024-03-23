package es.michillas.controllers;

import es.michillas.models.Preguntas;
import es.michillas.services.PreguntasService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntasController {

    @Autowired
    private PreguntasService preguntasService;

    @GetMapping("/list")
    public ResponseEntity<List<Preguntas>> getAllPreguntas() {
        try {
            List<Preguntas> preguntas = preguntasService.getAllQuestions();
            return ResponseEntity.ok().body(preguntas);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{type}")
    public String getPreguntasByType(@PathVariable String type, Model model) {
        try {
            List<Preguntas> preguntas = preguntasService.getQuestionsByType(type);
            model.addAttribute("preguntas", preguntas);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
        return "preguntasList"; // Assuming you have a Thymeleaf template named "preguntasList.html" for listing preguntas by type
    }

    @PostMapping("/create")
    public String createPregunta(@ModelAttribute Preguntas pregunta) {
        try {
            preguntasService.createQuestion(pregunta);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
        return "redirect:/preguntas/list";
    }

    @PostMapping("/delete")
    public String deletePregunta(@RequestParam String question) {
        try {
            preguntasService.deleteQuestion(question);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
        return "redirect:/preguntas/list";
    }
}
