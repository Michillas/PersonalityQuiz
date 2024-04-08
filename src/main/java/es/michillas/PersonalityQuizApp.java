package es.michillas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class PersonalityQuizApp {
    public static void main(String[] args) {
        SpringApplication.run(PersonalityQuizApp.class, args);
    }

    @RestController
    @RequestMapping("/")
    static class Controller {
        @GetMapping("/error")
        String handleError() {
            return "Error";
        }
    }
}