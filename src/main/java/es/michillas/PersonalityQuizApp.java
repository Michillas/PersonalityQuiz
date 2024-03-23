package es.michillas;

import es.michillas.models.Usuario;
import es.michillas.services.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class PersonalityQuizApp {
    public static void main(String[] args) {
        SpringApplication.run(PersonalityQuizApp.class, args);
    }
}