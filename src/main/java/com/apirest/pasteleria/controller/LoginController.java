package com.apirest.pasteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.pasteleria.service.LoginService;
import com.apirest.pasteleria.service.dto.request.LoginRequest;
import com.apirest.pasteleria.service.dto.request.RegisterRequest;
import com.apirest.pasteleria.service.dto.response.JwtUserResponse;

@RestController
@RequestMapping("/api/web")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@RequestBody RegisterRequest register) {
        return loginService.resgisterUserClient(register);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtUserResponse> login(@RequestBody LoginRequest loginRequest) {
        return  new ResponseEntity<>(loginService.getJwtByLogin(loginRequest),HttpStatus.OK);
    }
}
