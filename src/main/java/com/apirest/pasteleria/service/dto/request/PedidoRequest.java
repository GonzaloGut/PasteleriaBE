/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.request;

public class PedidoRequest {

    private Long cantidad;

    private Long fkproduct;

    public PedidoRequest(Long cantidad, Long fkproduct) {
        this.cantidad = cantidad;
        this.fkproduct = fkproduct;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getFkproduct() {
        return fkproduct;
    }

    public void setFkproduct(Long fkproduct) {
        this.fkproduct = fkproduct;
    }

}
