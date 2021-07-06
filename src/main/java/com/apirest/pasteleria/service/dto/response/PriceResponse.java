/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.response;

import com.apirest.pasteleria.entity.Price;
import com.apirest.pasteleria.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


public class PriceResponse {

    private Long idprice;

    private String name;

    private Double precio;

    public PriceResponse(Price price) {
        this.idprice = price.getIdprice();
        this.name = price.getName();
        this.precio = price.getPrecio();
    }

    public Long getIdprice() {
        return idprice;
    }

    public void setIdprice(Long idprice) {
        this.idprice = idprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
