package com.ozalp.portfolio.config;

import com.ozalp.portfolio.business.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeDb {

    @Bean
    CommandLineRunner runner(AuthService authService) {
        return args -> {
            authService.createRootAdmin();
        };
    }
}
