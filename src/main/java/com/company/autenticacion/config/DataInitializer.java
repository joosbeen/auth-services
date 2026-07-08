package com.company.autenticacion.config;

import com.company.autenticacion.entity.User;
import com.company.autenticacion.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("test@example.com")) {
            User user = new User("Usuario Test", "test@example.com", "password123");
            userRepository.save(user);
            System.out.println("Usuario de prueba creado: Usuario Test / test@example.com / password123");
        }
    }
}
