package com.shopconnect.ms_pedidos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Modelo de transferencia que resume los datos esenciales de un pedido procesado")
public class PedidoResumenDTO {

    @Schema(description = "Identificador único del pedido en la base de datos Oracle", example = "10025")
    private Long id;

    @Schema(description = "ID del usuario que realizó la compra (proveniente de ms-usuarios)", example = "1")
    private Long usuarioId;

    @Schema(description = "ID del producto adquirido (proveniente de ms-productos)", example = "42")
    private Long productoId;

    @Schema(description = "Cantidad de unidades solicitadas del producto", example = "3")
    private Integer cantidad;

    @Schema(description = "Fecha y hora exacta en la que se registró el pedido", example = "2026-06-14T10:15:30")
    private LocalDateTime fechaPedido;

    public PedidoResumenDTO() {
    }

    public PedidoResumenDTO(Long id, Long usuarioId, Long productoId, Integer cantidad, LocalDateTime fechaPedido) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}