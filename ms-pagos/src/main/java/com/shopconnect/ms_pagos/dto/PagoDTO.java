package com.shopconnect.ms_pagos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de transferencia para el registro y consulta del estado de pagos")
public class PagoDTO {

    @Schema(description = "ID del pedido asociado al pago (proveniente de ms-pedidos)", example = "10025")
    private Long pedidoId;

    @Schema(description = "Monto total facturado y pagado", example = "179.97")
    private Double monto;

    @Schema(description = "Estado actual de la transacción financiera", example = "PROCESADO")
    private String estado;

    public PagoDTO() {
    }

    public PagoDTO(Long pedidoId, Double monto, String estado) {
        this.pedidoId = pedidoId;
        this.monto = monto;
        this.estado = estado;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}