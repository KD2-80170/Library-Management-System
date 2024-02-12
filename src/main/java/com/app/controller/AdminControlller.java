package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.AdminRepository;
import com.app.entities.Admin;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminControlller {
	@Autowired
	private AdminRepository adRepo;
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Admin admin) {
        Admin registeredadmin = adRepo.save(admin);
        return ResponseEntity.ok().body(registeredadmin);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Admin loginAdmin) {
        Optional<Admin> userOptional;
	
			userOptional =adRepo.findByUsername(loginAdmin.getUsername());

        if (userOptional.isPresent()) {
            Admin admin = userOptional.get();
            if (admin.getPassword().equals(loginAdmin.getPassword())) {
                return ResponseEntity.ok().body(admin);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}


