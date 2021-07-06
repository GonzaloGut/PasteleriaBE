/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.controller;

import com.apirest.pasteleria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.pasteleria.entity.Producto;
import com.apirest.pasteleria.service.dto.request.ProductoRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/")
public class ProdutosController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("web/list/producto")
    public ResponseEntity<?> productos() {
        return new ResponseEntity<>(productoService.findAllProducts(), HttpStatus.OK);
    }
    @GetMapping(value = "web/one/producto/{id}")
    public ResponseEntity<?> producto(@PathVariable(value="id") Long id) {
        return new ResponseEntity<>(productoService.findOneProduct(id), HttpStatus.OK);
    }

    @PostMapping("web/save/producto")
    public ResponseEntity<?> saveproductos(@RequestBody ProductoRequest productoRequest) {
        try {
            productoService.saveProducts(productoRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
