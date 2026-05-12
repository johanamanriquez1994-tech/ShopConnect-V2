package com.shopconnect.ms_inventario.repository;

import com.shopconnect.ms_inventario.model.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Long> {
    // Para ver todos los movimientos de un item específico del inventario
    List<MovimientoInventario> findByInventarioId(Long inventarioId);
}