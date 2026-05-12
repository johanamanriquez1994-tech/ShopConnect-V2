package com.shopconnect.ms_pagos.controller;

import com.shopconnect.ms_pagos.model.Pago;
import com.shopconnect.ms_pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoRepository repository;

    @PostMapping("/procesar")
    public Pago procesarPago(@RequestBody Pago pago) {
        pago.setEstado("PROCESADO");
        return repository.save(pago);
    }
}
