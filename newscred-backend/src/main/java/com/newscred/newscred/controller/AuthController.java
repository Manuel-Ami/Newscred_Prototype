package com.newscred.newscred.controller;

import com.newscred.newscred.dto.RegisterRequest;
import com.newscred.newscred.dto.LoginRequest;
import com.newscred.newscred.service.AuthService;
import com.newscred.newscred.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);

    }
@PostMapping("/login")
public AuthResponse login(@RequestBody LoginRequest request) {

    String token = authService.login(request);

    return new AuthResponse(token, request.getEmail());
}
}