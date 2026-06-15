package com.shopconnect.ms_inventario.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de transferencia para registrar transacciones de entrada o salida de mercancía")
public class MovimientoInventarioDTO {

    @Schema(description = "ID del producto que genera el movimiento de stock", example = "42")
    private Long productoId;

    @Schema(description = "Unidades afectadas en esta transacción de almacén", example = "25")
    private Integer cantidad;

    @Schema(description = "Naturaleza de la operación en el inventario", example = "INGRESO", allowableValues = {"INGRESO", "EGRESO"})
    private String tipoMovimiento; 

    public MovimientoInventarioDTO() {}

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(String tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }
}