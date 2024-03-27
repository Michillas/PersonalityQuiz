package es.michillas.controllers;

import es.michillas.models.Admin;
import es.michillas.services.AdminService;

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
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

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

    @GetMapping("/{type}")
    public String getAdminsByName(@PathVariable String name, Model model) {
        try {
            List<Admin> admin = adminService.getAdminsByName(name);
            model.addAttribute("admin", admin);
        } catch (SQLException e) {
            // Handle SQL Exception
            e.printStackTrace();
        }
        return "adminList";
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
