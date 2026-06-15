package com.shopconnect.ms_pedidos.controller;

import com.shopconnect.ms_pedidos.dto.PedidoResumenDTO;
import com.shopconnect.ms_pedidos.model.Pedido;
import com.shopconnect.ms_pedidos.service.PedidoService;
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
@RequestMapping("/api/pedidos")
@Tag(name = "Controlador de Pedidos", description = "Endpoints para la gestión, creación y consulta del historial de órdenes de compra")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Listar todas las órdenes de la plataforma", description = "Retorna un listado global de todos los pedidos registrados usando el formato compacto del DTO de resumen.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de pedidos obtenido exitosamente", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoResumenDTO.class)))
    })
    @GetMapping
    public List<PedidoResumenDTO> listar() {
        return pedidoService.listarTodos();
    }

    @Operation(summary = "Obtener historial de pedidos de un usuario específico", description = "Busca e identifica en la base de datos Oracle todas las órdenes pertenecientes al ID de usuario enviado por parámetro.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Historial del usuario recuperado con éxito", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoResumenDTO.class))),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado o sin órdenes registradas", 
            content = @Content)
    })
    @GetMapping("/usuario/{usuarioId}")
    public List<PedidoResumenDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return pedidoService.listarPorUsuario(usuarioId);
    }

    @Operation(summary = "Registrar y procesar una nueva orden de compra", description = "Recibe los IDs de usuario y producto, valida las reglas de negocio e inserta la transacción del pedido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido procesado y creado exitosamente", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o error en la petición", 
            content = @Content)
    })
    @PostMapping
    public Pedido realizarPedido(@Valid @RequestBody PedidoResumenDTO pedidoDTO) {
        return pedidoService.crearPedido(pedidoDTO);
    }
}