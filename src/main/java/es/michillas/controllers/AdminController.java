package es.michillas.controllers;

import es.michillas.models.Admin;
import es.michillas.services.AdminService;
import es.michillas.services.AuthService;

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
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        try {
            boolean isAuthenticated = authService.authenticate(admin.getName(), admin.getPassword());
            if (isAuthenticated) {
                return ResponseEntity.ok("{\"message\": \"Iniciado sesión correctamente\"}");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Usuario o contraseña incorrecto\"}");
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error iniciando sesión\"}");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        try {
            if (adminService.getAdminByName(admin.getName()) != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"El nombre de usuario ya existe\"}");
            }

            String encodedPassword = authService.encode(admin.getPassword());

            Admin newAdmin = new Admin(admin.getName(), encodedPassword);
            adminService.createAdmin(newAdmin);

            return ResponseEntity.ok("{\"message\": \"Usuario registrado correctamente\"}");
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error registrando al usuario\"}");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        try {
            List<Admin> admin = adminService.getAllAdmins();
            return ResponseEntity.ok().body(admin);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Admin> getAdminByName(@PathVariable("name") String name) {
        try {
            Admin admin = adminService.getAdminByName(name);
            if (admin != null) {
                return ResponseEntity.ok().body(admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/create")
    public void createAdmin(@ModelAttribute Admin admin) {
        try {
            adminService.createAdmin(admin);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }

    @PostMapping("/delete")
    public void deleteAdmin(@RequestParam String admin) {
        try {
            adminService.deleteAdmin(admin);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
    }
}
