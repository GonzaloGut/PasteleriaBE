/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.response;

import com.apirest.pasteleria.entity.Direccion;
import com.apirest.pasteleria.entity.Pedido;
import com.apirest.pasteleria.entity.Persona;
import java.util.ArrayList;
import java.util.List;


public class PersonaResponse {
    
    
    private String username;
    
    private String name;

    private int edad;

    private String email;

    private int numero;
    
    private Direccion direccion;
    
    private List<Pedido> fkpedido = new ArrayList<>();

    public PersonaResponse(String username, Persona persona ) {
        this.username = username;
        this.name = persona.getName();
        this.edad = persona.getEdad();
        this.email = persona.getEmail();
        this.numero = persona.getNumero();
        this.direccion = persona.getDireccion();
        this.fkpedido = persona.getFkpedido();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    
}
