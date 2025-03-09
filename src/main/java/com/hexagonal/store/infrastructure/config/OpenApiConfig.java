package com.hexagonal.store.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Store API")
                        .version("1.0")
                        .description("API REST para la gestión de productos usando arquitectura hexagonal")
                        .contact(new Contact()
                                .name("Willinton Mora")
                                .email("will.mora@gmail.com")));
    }
}
