package com.shopconnect.ms_inventario.controller;

import com.shopconnect.ms_inventario.model.Inventario;
import com.shopconnect.ms_inventario.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.listarTodo();
    }

    @GetMapping("/producto/{productoId}")
    public Inventario verStock(@PathVariable Long productoId) {
        return inventarioService.obtenerPorProducto(productoId);
    }

    @PostMapping
    public Inventario actualizar(@Valid @RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }
}
