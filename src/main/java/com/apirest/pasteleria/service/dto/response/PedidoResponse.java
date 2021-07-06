/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.response;

import com.apirest.pasteleria.entity.Pedido;
import java.util.Date;

public class PedidoResponse {

    private Long idpedido;

    private Long cantidad;

    private ProductoResponse fkproduct;
    
    private Boolean est;
    
    private Date finsert;

    public PedidoResponse(Pedido pedido, ProductoResponse fkproduct) {
        this.idpedido = pedido.getIdpedido();
        this.cantidad = pedido.getCantidad();
        this.fkproduct = fkproduct;
        this.finsert = pedido.getFinsert();
         this.est = pedido.getEst();
    }

    public PedidoResponse() {
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public Boolean getEst() {
        return est;
    }

    public void setEst(Boolean est) {
        this.est = est;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoResponse getFkproduct() {
        return fkproduct;
    }

    public void setFkproduct(ProductoResponse fkproduct) {
        this.fkproduct = fkproduct;
    }

    public Date getFinsert() {
        return finsert;
    }

    public void setFinsert(Date finsert) {
        this.finsert = finsert;
    }

}
