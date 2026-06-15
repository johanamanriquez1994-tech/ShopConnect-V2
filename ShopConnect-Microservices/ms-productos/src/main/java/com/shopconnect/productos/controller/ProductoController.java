package com.shopconnect.productos.controller;

import com.shopconnect.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String checkConnection() {
        try {
            long total = productoRepository.count();
            return "¡CONEXIÓN EXITOSA! Oracle está respondiendo. Productos actuales: " + total;
        } catch (Exception e) {
            return "Error de conexión con Oracle: " + e.getMessage();
        }
    }
}