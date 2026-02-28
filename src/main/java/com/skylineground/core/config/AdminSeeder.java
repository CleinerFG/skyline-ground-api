package com.skylineground.core.config;

import com.fasterxml.uuid.impl.TimeBasedEpochGenerator;
import com.skylineground.modules.identity.user.SystemRole;
import com.skylineground.modules.identity.user.User;
import com.skylineground.modules.identity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AdminSeeder {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TimeBasedEpochGenerator uuidGenerator;

    @Value("${app.admin.name}")
    private String name;

    @Value("${app.admin.email}")
    private String email;

    @Value("${app.admin.password}")
    private String password;

    @Bean
    public CommandLineRunner seedAdmin() {
        return args -> {
            if (!userRepository.existsBySystemRole(SystemRole.ADMIN)) {
                var admin = User.builder()
                        .externalId(uuidGenerator.generate())
                        .name(name)
                        .email(email)
                        .password(passwordEncoder.encode(password))
                        .systemRole(SystemRole.ADMIN)
                        .build();

                userRepository.save(admin);
            }
        };
    }
}
