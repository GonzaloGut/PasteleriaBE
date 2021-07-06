package com.apirest.pasteleria.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddireccion;

    private String name;

    private String distrito;

    private String privincia;

    @OneToOne(mappedBy = "direccion")
    private Persona fkpersona;

    public Direccion() {
    }

    public Direccion(Long iddireccion, String name, String distrito, String privincia, Persona fkpersona) {
        this.iddireccion = iddireccion;
        this.name = name;
        this.distrito = distrito;
        this.privincia = privincia;
        this.fkpersona = fkpersona;
    }

    public Long getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Long iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getPrivincia() {
        return privincia;
    }

    public void setPrivincia(String privincia) {
        this.privincia = privincia;
    }

    public Persona getFkpersona() {
        return fkpersona;
    }

    public void setFkpersona(Persona fkpersona) {
        this.fkpersona = fkpersona;
    }

}
