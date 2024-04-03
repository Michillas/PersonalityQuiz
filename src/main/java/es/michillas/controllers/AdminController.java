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
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            boolean isAuthenticated = authService.authenticate(username, password);
            if (isAuthenticated) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to authenticate user");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password) {
        try {
            if (adminService.getAdminByName(username) != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }

            String encodedPassword = authService.encode(password);

            Admin admin = new Admin(username, password);
            adminService.createAdmin(admin);

            return ResponseEntity.ok("User registered successfully");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
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
    public String createAdmin(@ModelAttribute Admin admin) {
        try {
            adminService.createAdmin(admin);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
        return "redirect:/admins/list";
    }

    @PostMapping("/delete")
    public String deleteAdmin(@RequestParam String admin) {
        try {
            adminService.deleteAdmin(admin);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
        return "redirect:/admins/list";
    }
}
