package com.apirest.pasteleria.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.apirest.pasteleria.service.dto.request.RegisterRequest;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpersona;

    private String name;

    private int edad;

    private String email;

    private int numero;

    @OneToOne(mappedBy = "persona")
    private Login login;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkdireccion", referencedColumnName = "iddireccion")
    private Direccion direccion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkpersona", referencedColumnName = "idpersona")
    private List<Pedido> fkpedido = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date fechaf;
    
    @Column(name = "fecha_insert")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date finsert;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "fecha_update")
    private Date fupdate;

    public Persona(String name, int edad, String email, int nunmero,Date fechaf ,Login login, Direccion direccion,
            List<Pedido> fkpedido) {
        this.name = name;
        this.edad = edad;
        this.email = email;
        this.numero = nunmero;
        this.fechaf = fechaf;
        this.login = login;
        this.direccion = direccion;
        this.fkpedido = fkpedido;
    }

    public Persona(RegisterRequest register) {
        this.name = register.getName();
        this.edad = register.getEdad();
        this.email = register.getEmail();
        this.numero = register.getNumero();
        this.fechaf = register.getFechaf();
    }

    public Persona() {
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Pedido> getFkpedido() {
        return fkpedido;
    }

    public void setFkpedido(List<Pedido> fkpedido) {
        this.fkpedido = fkpedido;
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
