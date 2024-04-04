package es.michillas.controllers;

import es.michillas.models.Usuario;
import es.michillas.services.UsuarioService ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id) {
        try {
            Usuario usuario = usuarioService.getUsuarioById(id);
            if (usuario != null) {
                return ResponseEntity.ok().body(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
    public void createUsuario(@RequestBody Usuario usuario) throws SQLException {
        usuarioService.createUsuario(usuario);
    }

    @PostMapping("/update")
    public void updateUsuario(@RequestBody Usuario usuario) throws SQLException {
        usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable("id") int id) throws SQLException {
        usuarioService.deleteUsuario(id);
    }
}
