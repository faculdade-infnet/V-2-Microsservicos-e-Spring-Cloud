package br.edu.infnet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("TP3")
                        .version("1.0")
                        .description("Microsserviços e DevOps com Spring Boot e Spring Cloud")
                )
                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor local"));
    }
}
