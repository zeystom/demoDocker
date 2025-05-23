package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("User management API")
                .version("1.0.0").description("API documentation for Users control")
                .contact(new Contact().name("Your name").email("you@example.com")
                        .url("https://example.com"))
                        .license(new License()
                        .name("Apache 2.0")
                        .url("https:.apache.org/licenses/LICENSE-2.0.html")));
    }
}
