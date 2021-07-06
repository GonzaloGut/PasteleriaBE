/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.controller;

import com.apirest.pasteleria.service.PersonaService;
import com.apirest.pasteleria.service.dto.request.PersonaRequest;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/persona")
    public ResponseEntity<?> login(Principal user) {
        try {
            return new ResponseEntity<>(personaService.obtenerDatosGenerales(user), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/update/persona")
    public ResponseEntity<Void> updatePersona(@RequestBody PersonaRequest personaRequest,Principal user) {
        try {
            personaService.updatePersona(personaRequest,user);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        }
    }
}
