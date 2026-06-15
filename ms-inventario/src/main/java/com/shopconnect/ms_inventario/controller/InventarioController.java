package com.shopconnect.ms_inventario.controller;

import com.shopconnect.ms_inventario.dto.InventarioDTO;
import com.shopconnect.ms_inventario.dto.MovimientoInventarioDTO;
import com.shopconnect.ms_inventario.model.Inventario;
import com.shopconnect.ms_inventario.service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
@Tag(name = "Controlador de Inventario", description = "Endpoints para la consulta de stock disponible y registro de movimientos de almacén")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Operation(summary = "Consultar el stock de un producto", description = "Busca en la base de datos Oracle la cantidad neta disponible en almacén para el ID de producto proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Stock recuperado con éxito", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventarioDTO.class))),
        @ApiResponse(responseCode = "404", description = "El producto no está registrado en el inventario", 
            content = @Content)
    })
    @GetMapping("/producto/{productoId}")
    public InventarioDTO obtenerStock(@PathVariable Long productoId) {
        return inventarioService.obtenerStock(productoId);
    }

    @Operation(summary = "Registrar un movimiento de stock", description = "Procesa un ingreso o egreso de unidades en el almacén, recalculando el stock final del producto.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Movimiento procesado e inventario actualizado con éxito", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Inventario.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o inconsistencia en el movimiento (ej. stock insuficiente)", 
            content = @Content)
    })
    @PostMapping("/movimiento")
    public Inventario registrarMovimiento(@Valid @RequestBody MovimientoInventarioDTO movimientoDTO) {
        return inventarioService.registrarMovimiento(movimientoDTO);
    }
}