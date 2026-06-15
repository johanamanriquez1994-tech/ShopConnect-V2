package com.shopconnect.ms_usuarios.controller;

import com.shopconnect.ms_usuarios.dto.UsuarioDTO;
import com.shopconnect.ms_usuarios.model.Usuario;
import com.shopconnect.ms_usuarios.service.UsuarioService;
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
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
@Tag(name = "Controlador de Usuarios", description = "Endpoints para la gestión y registro de usuarios en ShopConnect")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Obtener lista completa de usuarios", description = "Retorna un listado con todos los usuarios registrados en la base de datos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))
    })
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.findAll();
    }

    @Operation(summary = "Registrar un nuevo usuario", description = "Recibe los datos del usuario mediante un DTO, los valida e inserta un nuevo registro en el sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada no válidos (Error de validación)", 
            content = @Content)
    })
    @PostMapping
    public Usuario crear(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }
}