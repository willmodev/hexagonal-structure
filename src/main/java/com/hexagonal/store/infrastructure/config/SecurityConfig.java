package com.hexagonal.store.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Rutas para Swagger UI y documentación OpenAPI
    private static final String[] SWAGGER_PATHS = {
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/v3/api-docs/**",
        "/api-docs/**",
        "/webjars/**"
    };

    private static final String[] PUBLIC_PATHS = {
            "/products/**",
            "/discounts/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Permitir acceso a Swagger UI y documentación OpenAPI
                .requestMatchers(SWAGGER_PATHS).permitAll()
                // Permitir acceso a endpoints de productos
                .requestMatchers(PUBLIC_PATHS).permitAll()
                // Requerir autenticación para todos los demás endpoints
                .anyRequest().authenticated());
            
        return http.build();
    }
}
