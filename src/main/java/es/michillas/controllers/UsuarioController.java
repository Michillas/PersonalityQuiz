package es.michillas.controllers;

import es.michillas.models.Preguntas;
import es.michillas.models.Usuario;
import es.michillas.services.UsuarioService ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String getUsuario(@PathVariable int id, Model model) throws SQLException {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "usuario"; // Assuming you have a Thymeleaf template named "usuario.html"
    }

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        try {
            List<Usuario> usuario = usuarioService.getAllUsuarios();
            return ResponseEntity.ok().body(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public String createUsuario(@RequestBody Usuario usuario) throws SQLException {
        //System.out.println(usuario.toString());
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @PostMapping("/update")
    public String updateUsuario(@RequestBody Usuario usuario) throws SQLException {
        usuarioService.updateUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable int id) throws SQLException {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/list";
    }
}
