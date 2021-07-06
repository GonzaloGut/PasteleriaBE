/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service;

import com.apirest.pasteleria.entity.Login;
import com.apirest.pasteleria.entity.Persona;
import com.apirest.pasteleria.repository.LoginRepository;
import com.apirest.pasteleria.service.dto.request.LoginRequest;
import com.apirest.pasteleria.service.dto.request.PersonaRequest;
import com.apirest.pasteleria.service.dto.response.JwtUserResponse;
import com.apirest.pasteleria.service.dto.response.PersonaResponse;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private LoginRepository loginRepository;

    public PersonaResponse obtenerDatosGenerales(Principal userP) {
        Login user = loginRepository.findByUsername(
                userP.getName())
                .orElseThrow(() -> new RuntimeException("El username no existe"));
        return new PersonaResponse(user.getUsername(), user.getPersona());
    }

    public void updatePersona(PersonaRequest personaRequest, Principal userP) {
        System.out.println("com.apirest.pasteleria.service.PersonaService.savePersona()");
         Login user = loginRepository.findByUsername(
                userP.getName())
                .orElseThrow(() -> new RuntimeException("El username no existe"));
        Persona persona = user.getPersona();
        if (personaRequest.getEdad() != 0) {
            persona.setEdad(personaRequest.getEdad());
        }
        if (personaRequest.getNumero() != 0) {
            persona.setNumero(personaRequest.getNumero());
        }
        if (personaRequest.getName() != null) {
            persona.setName(personaRequest.getName());
        }
        if (personaRequest.getEmail() != null) {
            persona.setEmail(personaRequest.getEmail());
        }
        try {
            user.setPersona(persona);
            loginRepository.save(user);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
