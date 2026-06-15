package com.shopconnect.ms_pedidos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Pedidos - ShopConnect")
                        .version("1.0")
                        .description("Documentación interactiva de la API para la creación, procesamiento y seguimiento de las órdenes de compra de los clientes."));
    }
}
