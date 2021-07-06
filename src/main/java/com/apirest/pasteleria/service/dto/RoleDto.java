/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto;

import com.apirest.pasteleria.entity.ERole;

public class RoleDto {
    private ERole name;

    public RoleDto(ERole name) {
        this.name = name;
    }

    public RoleDto() {
    }
    
    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
