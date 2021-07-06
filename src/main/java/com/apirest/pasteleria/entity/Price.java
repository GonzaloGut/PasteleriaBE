package com.apirest.pasteleria.entity;

import com.apirest.pasteleria.service.dto.request.PriceRequest;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idprice;

    private String name;

    private Double precio;

    public Price() {
    }

    public Price(String name, Double precio) {
        this.name = name;
        this.precio = precio;
    }

    public Price(PriceRequest priceRequest) {
        this.name = priceRequest.getName();
        this.precio = priceRequest.getPrecio();
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
