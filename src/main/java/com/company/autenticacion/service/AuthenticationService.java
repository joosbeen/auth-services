package com.company.autenticacion.service;

import com.company.autenticacion.dto.LoginRequest;
import com.company.autenticacion.dto.LoginResponse;
import com.company.autenticacion.dto.RegisterRequest;
import com.company.autenticacion.dto.RegisterResponse;
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

    public RegisterResponse register(RegisterRequest registerRequest) {
        if (!registerRequest.getContraseña().equals(registerRequest.getContraseña_confirm())) {
            throw new AuthenticationException("Las contraseñas no coinciden");
        }

        if (userRepository.existsByEmail(registerRequest.getCorreo())) {
            throw new AuthenticationException("El correo ya está registrado");
        }

        User user = new User(
                registerRequest.getNombre(),
                registerRequest.getCorreo(),
                registerRequest.getContraseña()
        );

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                "Registro exitoso",
                savedUser.getNombre(),
                savedUser.getEmail(),
                savedUser.getEstatus(),
                savedUser.getFechaRegistro(),
                savedUser.getFechaActualizacion()
        );
    }
}
