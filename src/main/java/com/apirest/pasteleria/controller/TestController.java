/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.controller;
import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
  	@GetMapping("/api/security/user")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
	public ResponseEntity<?> userAccess(Principal user) {
            System.out.println(user);
		return ResponseEntity.ok(user);
	}

	
	@GetMapping("/api/security/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}  
}
