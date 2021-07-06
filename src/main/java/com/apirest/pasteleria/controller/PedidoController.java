package com.apirest.pasteleria.controller;

import com.apirest.pasteleria.service.PedidoService;
import com.apirest.pasteleria.service.dto.request.PedidoRequest;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/pedido")
    @PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
    public ResponseEntity<?> genrarPedido(@RequestBody PedidoRequest pedidoRequest, Principal user) {
        try {
            return new ResponseEntity<>(pedidoService.generarPedido(user, pedidoRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/list/pedido")
    @PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
    public ResponseEntity<?> listPedido( Principal user) {
        try {
            return new ResponseEntity<>(pedidoService.listPedido(user),HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
