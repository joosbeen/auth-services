package com.company.autenticacion.service;

import com.company.autenticacion.dto.LoginRequest;
import com.company.autenticacion.dto.LoginResponse;
import com.company.autenticacion.entity.User;
import com.company.autenticacion.exception.AuthenticationException;
import com.company.autenticacion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new AuthenticationException("Usuario no encontrado"));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new AuthenticationException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse("Login exitoso", user.getEmail(), token);
    }
}
