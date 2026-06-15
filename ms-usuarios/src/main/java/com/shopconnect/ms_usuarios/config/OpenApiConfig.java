package com.shopconnect.ms_usuarios.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Usuarios")
                        .version("1.0.0")
                        .description("API REST para la gestión y registro de usuarios en ShopConnect. " +
                                     "Permite dar de alta nuevos usuarios utilizando DTOs validados."))
                .addServersItem(new Server()
                        .url("http://localhost:8085")
                        .description("Servidor Local - Puerto 8085"));
    }
}