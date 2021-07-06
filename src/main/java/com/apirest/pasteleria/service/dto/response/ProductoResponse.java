package com.apirest.pasteleria.service.dto.response;

import com.apirest.pasteleria.entity.Producto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoResponse {

    private Long idproduct;

    private String producNane;

    private String descripcion;

    private String imagen;

    private List<CategoryResponse> categorias ;

    private List<PriceResponse> precio;

    public ProductoResponse(Producto producto,  List<PriceResponse> precio,  List<CategoryResponse> categorias) {
        this.idproduct = producto.getIdproduct();
        this.producNane = producto.getProducNane();
        this.descripcion = producto.getDescripcion();
        this.imagen = producto.getImagen();
        this.precio = precio;
        this.categorias = categorias;
    }

    public ProductoResponse() {
    }

    public Long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Long idproduct) {
        this.idproduct = idproduct;
    }

    public String getProducNane() {
        return producNane;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setProducNane(String producNane) {
        this.producNane = producNane;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CategoryResponse> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoryResponse> categorias) {
        this.categorias = categorias;
    }

    public List<PriceResponse> getPrecio() {
        return precio;
    }

    public void setPrecio(List<PriceResponse> precio) {
        this.precio = precio;
    }

}
