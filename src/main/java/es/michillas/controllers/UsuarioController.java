package es.michillas.controller;

import es.michillas.model.Usuario;
import es.michillas.service.UsuarioService ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String getUsuario(@PathVariable int id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "usuario"; // Assuming you have a Thymeleaf template named "usuario.html"
    }

    @GetMapping("/list")
    public String getAllUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios"; // Assuming you have a Thymeleaf template named "usuarios.html" for listing all usuarios
    }

    @PostMapping("/create")
    public String createUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @PostMapping("/update")
    public String updateUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.updateUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/list";
    }
}
