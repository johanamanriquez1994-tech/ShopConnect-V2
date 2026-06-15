package com.shopconnect.ms_productos.service;

import com.shopconnect.ms_productos.dto.ProductoCatalogoDTO;
import com.shopconnect.ms_productos.dto.ProductoCrearDTO;
import com.shopconnect.ms_productos.model.Producto;
import com.shopconnect.ms_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoCatalogoDTO> obtenerTodos() {
        List<Producto> productos = productoRepository.findAll();
        
        return productos.stream().map(producto -> new ProductoCatalogoDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio()
        )).collect(Collectors.toList());
    }

    public Producto guardar(ProductoCrearDTO productoDTO) {
        Producto producto = new Producto();
        
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecioVenta());

        return productoRepository.save(producto);
    }
}