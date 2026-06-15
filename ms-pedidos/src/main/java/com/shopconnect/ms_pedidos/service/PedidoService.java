package com.shopconnect.ms_pedidos.service;

import com.shopconnect.ms_pedidos.dto.PedidoResumenDTO;
import com.shopconnect.ms_pedidos.model.Pedido;
import com.shopconnect.ms_pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoResumenDTO> listarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedido -> {
            PedidoResumenDTO dto = new PedidoResumenDTO();
            dto.setId(pedido.getId());
            dto.setUsuarioId(pedido.getUsuarioId());
            dto.setProductoId(pedido.getProductoId());
            dto.setCantidad(pedido.getCantidad());
            dto.setFechaPedido(pedido.getFechaPedido());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<PedidoResumenDTO> listarPorUsuario(Long usuarioId) {
        List<Pedido> pedidos = pedidoRepository.findByUsuarioId(usuarioId);
        return pedidos.stream().map(pedido -> {
            PedidoResumenDTO dto = new PedidoResumenDTO();
            dto.setId(pedido.getId());
            dto.setUsuarioId(pedido.getUsuarioId());
            dto.setProductoId(pedido.getProductoId());
            dto.setCantidad(pedido.getCantidad());
            dto.setFechaPedido(pedido.getFechaPedido());
            return dto;
        }).collect(Collectors.toList());
    }

    public Pedido crearPedido(PedidoResumenDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(pedidoDTO.getUsuarioId());
        pedido.setProductoId(pedidoDTO.getProductoId());
        pedido.setCantidad(pedidoDTO.getCantidad());
        
        return pedidoRepository.save(pedido);
    }
}