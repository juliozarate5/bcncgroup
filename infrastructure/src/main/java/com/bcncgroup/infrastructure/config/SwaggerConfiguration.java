package com.bcncgroup.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Prices e-commerce")
                        .description("API REST Prices e-commerce")
                        .version("1.0.0")
                        .contact(
                                new Contact()
                                        .name("Julio Martinez")
                                        .email("juliomzarate5@gmail.com")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("BCNC Group")
                        .url("https://bcncgroup.com"));
    }
}
