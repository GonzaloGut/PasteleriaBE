/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.dto.response;

import com.apirest.pasteleria.service.dto.UserDto;

public class JwtUserResponse {
    private UserDto user;
    private JwtResponse jwt;

    public JwtUserResponse(UserDto user, JwtResponse jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public JwtResponse getJwt() {
        return jwt;
    }

    public void setJwt(JwtResponse jwt) {
        this.jwt = jwt;
    }

}
