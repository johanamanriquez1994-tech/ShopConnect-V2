package com.shopconnect.ms_pagos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones_pago")
public class TransaccionPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del pago es obligatorio")
    private Long pagoId;

    @NotBlank(message = "El código de transacción es obligatorio")
    private String codigoTransaccion; // El ID que viene del banco o Stripe/PayPal

    private LocalDateTime fechaTransaccion;

    public TransaccionPago() {
        this.fechaTransaccion = LocalDateTime.now();
    }

  
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPagoId() { return pagoId; }
    public void setPagoId(Long pagoId) { this.pagoId = pagoId; }
    public String getCodigoTransaccion() { return codigoTransaccion; }
    public void setCodigoTransaccion(String codigoTransaccion) { this.codigoTransaccion = codigoTransaccion; }
    public LocalDateTime getFechaTransaccion() { return fechaTransaccion; }
    public void setFechaTransaccion(LocalDateTime fechaTransaccion) { this.fechaTransaccion = fechaTransaccion; }
}