package com.shopconnect.ms_pedidos.controller;

import com.shopconnect.ms_pedidos.model.Pedido;
import com.shopconnect.ms_pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> listarPorUsuario(@PathVariable Long usuarioId) {
        return pedidoService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Pedido realizarPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }
}