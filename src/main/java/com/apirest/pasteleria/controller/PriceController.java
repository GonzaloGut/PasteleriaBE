/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.controller;

import com.apirest.pasteleria.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.pasteleria.entity.Price;
import com.apirest.pasteleria.service.dto.request.PriceRequest;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("web/list/price")
    public ResponseEntity<?> prices() {
        return new ResponseEntity<>(priceService.findAllPrices(), HttpStatus.OK);
    }

    @PostMapping("web/save/price")
    public ResponseEntity<Void> saveprices(@RequestBody PriceRequest priceRequest) {
        try {
            priceService.savePrice(priceRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
