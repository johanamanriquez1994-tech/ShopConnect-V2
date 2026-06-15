package com.shopconnect.ms_pagos.service;

import com.shopconnect.ms_pagos.dto.PagoDTO;
import com.shopconnect.ms_pagos.model.Pago;
import com.shopconnect.ms_pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }

    public Pago procesarPago(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        
        pago.setPedidoId(pagoDTO.getPedidoId());
        pago.setMonto(pagoDTO.getMonto());
        pago.setEstado(pagoDTO.getEstado() != null ? pagoDTO.getEstado() : "PROCESANDO");

        return pagoRepository.save(pago);
    }
}