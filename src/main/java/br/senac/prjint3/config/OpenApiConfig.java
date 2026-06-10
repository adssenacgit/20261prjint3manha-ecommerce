package br.senac.prjint3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API E-commerce Senac")
                        .description("Backend Java 21 com Spring Boot, MySQL e CRUD com apagamento lógico por status")
                        .version("1.0.0")
                        .contact(new Contact().name("Senac RJ"))
                        .license(new License().name("Uso acadêmico")));
    }
}
