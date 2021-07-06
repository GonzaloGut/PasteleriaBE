package com.apirest.pasteleria.entity;

import com.apirest.pasteleria.service.dto.request.CategoryRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcategory;

    private String namecategory;

    private String descripcion;

    public Category() {
    }

    public Category(String namecategory, String descripcion) {
        this.namecategory = namecategory;
        this.descripcion = descripcion;
    }

    public Category(CategoryRequest categoryRequest) {
        this.namecategory = categoryRequest.getNamecategory();
        this.descripcion = categoryRequest.getDescripcion();
    }

    public Long getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Long idcategory) {
        this.idcategory = idcategory;
    }

    public String getNamecategory() {
        return namecategory;
    }

    public void setNamecategory(String namecategory) {
        this.namecategory = namecategory;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
