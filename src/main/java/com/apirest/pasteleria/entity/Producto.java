package com.apirest.pasteleria.entity;

import com.apirest.pasteleria.service.dto.request.ProductoRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduct;

    private String producNane;

    private String descripcion;

    private String imagen;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkproduct", referencedColumnName = "idproduct")
    private List<Pedido> fkpedidos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "producto_category",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "producto_price",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id"))
    private List<Price> price = new ArrayList<>();

    public Producto() {
    }

    public Producto(String producNane, String descripcion, String imagen) {
        this.producNane = producNane;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Producto(ProductoRequest productoRequest) {
        this.producNane = productoRequest.getProducNane();
        this.descripcion = productoRequest.getDescripcion();
        this.imagen = productoRequest.getImagen();
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Pedido> getFkpedidos() {
        return fkpedidos;
    }

    public void setFkpedidos(List<Pedido> fkpedidos) {
        this.fkpedidos = fkpedidos;
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

    public void setProducNane(String producNane) {
        this.producNane = producNane;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Pedido> getFkpedido() {
        return fkpedidos;
    }

    public void setFkpedido(List<Pedido> fkpedido) {
        this.fkpedidos = fkpedido;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }

}
