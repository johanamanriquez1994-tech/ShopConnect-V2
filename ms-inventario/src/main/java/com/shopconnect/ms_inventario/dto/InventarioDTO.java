package com.shopconnect.ms_inventario.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de transferencia para consultar o actualizar el stock actual de un producto en almacén")
public class InventarioDTO {

    @Schema(description = "ID del producto asociado (proveniente de ms-productos)", example = "42")
    private Long productoId;

    @Schema(description = "Cantidad física disponible en el inventario actual", example = "150")
    private Integer cantidad;

    public InventarioDTO() {}

    public InventarioDTO(Long productoId, Integer cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}