package es.michillas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PersonalityQuizApp {
    public static void main(String[] args) {
        SpringApplication.run(PersonalityQuizApp.class, args);
    }

    @GetMapping("/error")
    public String handleError() {
        return "Error";
    }
}