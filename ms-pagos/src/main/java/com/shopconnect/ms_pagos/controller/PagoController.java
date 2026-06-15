package com.shopconnect.ms_pagos.controller;

import com.shopconnect.ms_pagos.dto.PagoDTO;
import com.shopconnect.ms_pagos.model.Pago;
import com.shopconnect.ms_pagos.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> listar() {
        return pagoService.obtenerTodos();
    }

    @PostMapping
    public Pago crear(@Valid @RequestBody PagoDTO pagoDTO) {
        return pagoService.procesarPago(pagoDTO);
    }
}