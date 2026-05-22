package com.shopconnect.ms_inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_inventario")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del inventario es obligatorio")
    private Long inventarioId;

    @NotBlank(message = "El tipo de movimiento es obligatorio")
    private String tipo; 

    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;

    private LocalDateTime fecha;

    public MovimientoInventario() {
        this.fecha = LocalDateTime.now();
    }

  
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInventarioId() { return inventarioId; }
    public void setInventarioId(Long inventarioId) { this.inventarioId = inventarioId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}