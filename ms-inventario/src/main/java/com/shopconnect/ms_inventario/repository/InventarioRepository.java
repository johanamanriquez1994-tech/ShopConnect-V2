package com.shopconnect.ms_inventario.repository;

import com.shopconnect.ms_inventario.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    // Buscamos por productoId para saber cuánto stock tiene un producto específico
    Optional<Inventario> findByProductoId(Long productoId);
}
