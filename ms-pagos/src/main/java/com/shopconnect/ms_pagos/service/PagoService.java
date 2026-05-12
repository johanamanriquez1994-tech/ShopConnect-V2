package com.shopconnect.ms_pagos.service;

import com.shopconnect.ms_pagos.model.Pago;
import com.shopconnect.ms_pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Pago registrarPago(Pago pago) {
        // Por defecto, si se registra, lo ponemos como COMPLETADO por ahora
        if (pago.getEstado() == null) {
            pago.setEstado("COMPLETADO");
        }
        return pagoRepository.save(pago);
    }
}