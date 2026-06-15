package com.shopconnect.ms_inventario.config;

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
                        .title("Microservicio de Inventario - ShopConnect")
                        .version("1.0")
                        .description("Documentación interactiva de la API para el control de stock, almacén y disponibilidad de productos en tiempo real."));
    }
}
