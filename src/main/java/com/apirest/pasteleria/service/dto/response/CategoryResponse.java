/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.response;

import com.apirest.pasteleria.entity.Category;


public class CategoryResponse {
    	private Long idcategory;
	
	private String namecategory;
	
	private String descripcion;

    public CategoryResponse(Long idcategory, String namecategory, String descripcion) {
        this.idcategory = idcategory;
        this.namecategory = namecategory;
        this.descripcion = descripcion;
    }
        public CategoryResponse(Category category) {
        this.idcategory = category.getIdcategory();
        this.namecategory = category.getNamecategory();
        this.descripcion = category.getDescripcion();
    }

    public CategoryResponse() {
    }

    public Long getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Long idcategory) {
        this.idcategory = idcategory;
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
