/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.request;

import java.util.Date;
import java.util.Objects;

public class PersonaRequest {

    private String name;

    private int edad;

    private String email;

    private int numero;
    
    private Date fechaf;

    public PersonaRequest(String name, int edad, String email, int numero, Date fechaf) {
        this.name = name;
        this.edad = edad;
        this.email = email;
        this.numero = numero;
        this.fechaf = fechaf;
    }

    public PersonaRequest() {
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonaRequest other = (PersonaRequest) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonaRequest{" + "name=" + name + ", edad=" + edad + ", email=" + email + ", numero=" + numero + '}';
    }

}
