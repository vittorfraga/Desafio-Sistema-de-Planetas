package com.vittorfraga.planets.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI desafioAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Challenge Back-End")
                        .description("Challenge Back-End Project")
                        .version("v0.0.1")
                        .license(new License().name("Challenge Back-End").url("URL Temporária")));
    }
}
