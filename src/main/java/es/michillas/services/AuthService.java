package es.michillas.services;

import es.michillas.models.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AuthService {

    @Autowired
    private AdminService adminService;

    private PasswordEncoder passwordEncoder;


    public boolean authenticate(String username, String password) throws SQLException {
        Admin admin = adminService.getAdminByName(username);
        if (admin == null) {
            return false;
        }

        return passwordEncoder.matches(password, admin.getPassword());
    }

    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

}
