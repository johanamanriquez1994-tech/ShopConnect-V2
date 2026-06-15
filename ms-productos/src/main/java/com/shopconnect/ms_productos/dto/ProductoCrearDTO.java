package com.shopconnect.ms_productos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de transferencia para la creación de nuevos productos en el catálogo")
public class ProductoCrearDTO {

    @Schema(description = "Nombre comercial del producto", example = "Audífonos Inalámbricos Bluetooth")
    private String nombre;

    @Schema(description = "Descripción detallada con las especificaciones del producto", example = "Cancelación activa de ruido, batería de 40 horas y carga rápida USB-C.")
    private String descripcion;

    @Schema(description = "Precio de venta al público en la plataforma", example = "59.99")
    private Double precioVenta;

    @Schema(description = "Categoría a la que pertenece el producto para su organización", example = "Electrónica")
    private String categoria;

    public ProductoCrearDTO() {
    }

    public ProductoCrearDTO(String nombre, String descripcion, Double precioVenta, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}