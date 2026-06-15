package com.shopconnect.ms_usuarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Modelo de transferencia para registrar un nuevo usuario en el sistema")
public class UsuarioDTO {

    @Schema(description = "Nombre de usuario único para el inicio de sesión", example = "juan_perez")
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @Schema(description = "Correo electrónico del usuario", example = "juan.perez@mail.com")
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    private String email;

    @Schema(description = "Contraseña de acceso segura", example = "password123")
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}