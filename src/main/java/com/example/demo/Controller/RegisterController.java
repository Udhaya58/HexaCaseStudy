package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repo.AdminRepo;
import com.example.demo.Repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register normal user
    @PostMapping("/userregister")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/adminregister")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        if (adminRepo.findByEmail(admin.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Admin already exists");
        }

        admin.setRole(Role.ADMIN); // ✅ Important!
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepo.save(admin);

        return ResponseEntity.ok("Admin created successfully");
    }}

   

