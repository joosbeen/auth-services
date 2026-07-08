package com.company.autenticacion.controller;

import com.company.autenticacion.dto.LoginRequest;
import com.company.autenticacion.dto.LoginResponse;
import com.company.autenticacion.dto.RegisterRequest;
import com.company.autenticacion.dto.RegisterResponse;
import com.company.autenticacion.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = authenticationService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        RegisterResponse response = authenticationService.register(registerRequest);
        return ResponseEntity.ok(response);
    }
}
