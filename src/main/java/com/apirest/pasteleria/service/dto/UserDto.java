/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserDto {
    	private String username;
    
	private String name;
	
	private int edad;
	
	private String email;
	
	private int numero;
        
        private Date fechaf;

    	private Set<RoleDto> rolesDto = new HashSet<>();

    public UserDto(String username, String name, int edad, String email, int numero,Date fechaf, Set<RoleDto> rolesDto) {
        this.username = username;
        this.name = name;
        this.edad = edad;
        this.email = email;
        this.numero = numero;
        this.rolesDto = rolesDto;
        this.fechaf = fechaf;
    }

    public UserDto() {
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

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<RoleDto> getRolesDto() {
        return rolesDto;
    }

    public void setRolesDto(Set<RoleDto> rolesDto) {
        this.rolesDto = rolesDto;
    }

}
