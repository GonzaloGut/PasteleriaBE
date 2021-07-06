package com.apirest.pasteleria.service.dto.request;

import java.util.Date;

public class RegisterRequest {
	
	private String username;
    
	private String password;

	private String name;
	
	private int edad;
	
	private String email;
	
	private int numero;
        
        private Date fechaf;

    public RegisterRequest(String username, String password, String name, int edad, String email, int numero, Date fechaf) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.edad = edad;
        this.email = email;
        this.numero = numero;
        this.fechaf = fechaf;
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public RegisterRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
