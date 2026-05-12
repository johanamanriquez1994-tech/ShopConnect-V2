package com.shopconnect.ms_inventario.service;

import com.shopconnect.ms_inventario.model.Inventario;
import com.shopconnect.ms_inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> listarTodo() {
        return inventarioRepository.findAll();
    }

    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario obtenerPorProducto(Long productoId) {
        return inventarioRepository.findByProductoId(productoId).orElse(null);
    }
}