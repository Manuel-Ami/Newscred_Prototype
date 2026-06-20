package com.newscred.newscred.service;

import com.newscred.newscred.dto.RegisterRequest;
import com.newscred.newscred.dto.LoginRequest;
import com.newscred.newscred.entity.User;
import com.newscred.newscred.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.newscred.newscred.security.JwtService;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return "Registration successful";
    }


public String login(LoginRequest request) {

    if (request.getEmail().equals("lance@example.com")
            && request.getPassword().equals("1234")) {

        return "mock-jwt-token-12345";
    }

    throw new RuntimeException("Invalid credentials");
}}