package com.shopconnect.ms_productos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;    // <--- IMPORTANTE
import java.util.HashSet; // <--- IMPORTANTE

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser al menos 1")
    private Double precio;

   
    @ManyToMany
    @JoinTable(
      name = "producto_categoria",
      joinColumns = @JoinColumn(name = "producto_id"),
      inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    public Producto() {}

   
    public Set<Categoria> getCategorias() { return categorias; }
    public void setCategorias(Set<Categoria> categorias) { this.categorias = categorias; }

    
}
