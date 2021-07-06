/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.request;


public class ProductoRequest {
    private String producNane;

    private String descripcion;
    
    private String imagen;
    
    private Long price;
    
    private Long categories;

    public ProductoRequest(String producNane, String descripcion, String imagen, long price, long categories) {
        this.producNane = producNane;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.price = price;
        this.categories = categories;
    }

    public ProductoRequest() {
    }

    public String getProducNane() {
        return producNane;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getCategories() {
        return categories;
    }

    public void setCategories(long categories) {
        this.categories = categories;
    }
    
    
}
