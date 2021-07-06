/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.request;


public class CategoryRequest {
	private String namecategory;
	
	private String descripcion;

    public CategoryRequest() {
    }

    public CategoryRequest(String namecategory, String descripcion) {
        this.namecategory = namecategory;
        this.descripcion = descripcion;
    }

    public String getNamecategory() {
        return namecategory;
    }

    public void setNamecategory(String namecategory) {
        this.namecategory = namecategory;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
