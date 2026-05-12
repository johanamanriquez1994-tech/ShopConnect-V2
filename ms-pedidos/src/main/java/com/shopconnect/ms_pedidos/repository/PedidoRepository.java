package com.shopconnect.ms_pedidos.repository;

import com.shopconnect.ms_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Permite buscar todos los pedidos de un usuario específico
    List<Pedido> findByUsuarioId(Long usuarioId);
}