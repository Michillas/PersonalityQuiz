package es.michillas.controllers;

import es.michillas.models.Mbti;
import es.michillas.services.MbtiService;

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
@RequestMapping("/mbtis")
public class MbtiController {

    @Autowired
    private MbtiService mbtiService;

    @GetMapping("/list")
    public ResponseEntity<List<Mbti>> getAllMbtis() {
        try {
            List<Mbti> mbti = mbtiService.getAllMbtis();
            return ResponseEntity.ok().body(mbti);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<Mbti> getMbtiByMbti(@PathVariable("type") String type) {
        try {
            Mbti mbti = mbtiService.getMbtiByMbti(type);
            if (mbti != null) {
                return ResponseEntity.ok().body(mbti);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/create")
    public void createMbti(@ModelAttribute Mbti mbti) {
        try {
            mbtiService.createMbti(mbti);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }

    @PostMapping("/delete")
    public void deleteMbti(@RequestParam String mbti) {
        try {
            mbtiService.deleteMbti(mbti);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }
}
