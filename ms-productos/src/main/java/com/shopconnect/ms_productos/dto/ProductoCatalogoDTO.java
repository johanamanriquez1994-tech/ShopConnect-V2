package com.shopconnect.ms_productos.dto;

public class ProductoCatalogoDTO {

    private Long idProducto; 
    private String nombre;
    private Double precioVenta;

    public ProductoCatalogoDTO() {
    }

    public ProductoCatalogoDTO(Long idProducto, String nombre, Double precioVenta) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
