package com.shopconnect.ms_productos.controller;

import com.shopconnect.ms_productos.dto.ProductoCatalogoDTO;
import com.shopconnect.ms_productos.dto.ProductoCrearDTO;
import com.shopconnect.ms_productos.model.Producto;
import com.shopconnect.ms_productos.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Controlador de Productos", description = "Endpoints para la gestión, visualización y creación del catálogo de productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Operation(summary = "Obtener el catálogo optimizado de productos", description = "Retorna un listado de productos formateado mediante un DTO diseñado para el catálogo público.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Catálogo obtenido exitosamente", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductoCatalogoDTO.class)))
    })
    @GetMapping
    public List<ProductoCatalogoDTO> listar() {
        return productoService.obtenerTodos();
    }

    @Operation(summary = "Registrar un nuevo producto", description = "Recibe los datos del producto a través de un DTO de creación, los procesa e inserta el registro en la base de datos Oracle.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado con éxito", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))),
        @ApiResponse(responseCode = "400", description = "Petición incorrecta o parámetros de validación fallidos", 
            content = @Content)
    })
    @PostMapping
    public Producto crear(@Valid @RequestBody ProductoCrearDTO productoDTO) {
        return productoService.guardar(productoDTO);
    }
}