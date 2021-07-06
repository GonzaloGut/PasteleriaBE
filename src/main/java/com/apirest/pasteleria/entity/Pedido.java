package com.apirest.pasteleria.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedido;

    private Long cantidad;

    private Boolean  est;

    @Column(name = "fkpersona")
    private Long fkpersona;

    @Column(name = "fkproduct")
    private Long fkproduct;

    @Column(name = "fecha_insert")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date finsert;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fupdate;

    public Pedido() {
    }

    public Pedido(Long cantidad, Long fkpersona, Long fkproduct) {
        this.cantidad = cantidad;
        this.fkpersona = fkpersona;
        this.fkproduct = fkproduct;
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

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEst() {
        return est;
    }

    public void setEst(Boolean est) {
        this.est = est;
    }

    public Long getFkpersona() {
        return fkpersona;
    }

    public void setFkpersona(Long fkpersona) {
        this.fkpersona = fkpersona;
    }

    public Long getFkproduct() {
        return fkproduct;
    }

    public void setFkproduct(Long fkproduct) {
        this.fkproduct = fkproduct;
    }

    public Date getFinsert() {
        return finsert;
    }

    public void setFinsert(Date finsert) {
        this.finsert = finsert;
    }

    public Date getFupdate() {
        return fupdate;
    }

    public void setFupdate(Date fupdate) {
        this.fupdate = fupdate;
    }

}
