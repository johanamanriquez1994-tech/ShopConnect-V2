package com.shopconnect.ms_inventario.service;

import com.shopconnect.ms_inventario.dto.InventarioDTO;
import com.shopconnect.ms_inventario.dto.MovimientoInventarioDTO;
import com.shopconnect.ms_inventario.model.Inventario;
import com.shopconnect.ms_inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public InventarioDTO obtenerStock(Long productoId) {
        Optional<Inventario> inventarioOpt = inventarioRepository.findByProductoId(productoId);
        
        Integer stockActual = 0;
        if (inventarioOpt.isPresent()) {
            stockActual = inventarioOpt.get().getCantidad();
        }

        InventarioDTO dto = new InventarioDTO();
        dto.setProductoId(productoId);
        dto.setCantidad(stockActual);
        
        return dto;
    }

    public Inventario registrarMovimiento(MovimientoInventarioDTO movimientoDTO) {
        Optional<Inventario> inventarioOpt = inventarioRepository.findByProductoId(movimientoDTO.getProductoId());
        
        Inventario inventario;
        
        if (inventarioOpt.isPresent()) {
            inventario = inventarioOpt.get();
        } else {
            inventario = new Inventario();
            inventario.setProductoId(movimientoDTO.getProductoId());
            inventario.setCantidad(0);
        }

        if ("INGRESO".equalsIgnoreCase(movimientoDTO.getTipoMovimiento())) {
            inventario.setCantidad(inventario.getCantidad() + movimientoDTO.getCantidad());
        } else if ("EGRESO".equalsIgnoreCase(movimientoDTO.getTipoMovimiento())) {
            if (inventario.getCantidad() < movimientoDTO.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para realizar el egreso");
            }
            inventario.setCantidad(inventario.getCantidad() - movimientoDTO.getCantidad());
        } else {
            inventario.setCantidad(inventario.getCantidad() + movimientoDTO.getCantidad());
        }

        return inventarioRepository.save(inventario);
    }
}