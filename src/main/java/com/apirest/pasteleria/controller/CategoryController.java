/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.controller;

import com.apirest.pasteleria.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.pasteleria.entity.Category;
import com.apirest.pasteleria.service.dto.request.CategoryRequest;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("web/list/category")
    public ResponseEntity<?> categorys() {
        return new ResponseEntity<>(categoryService.findAllCategorys(), HttpStatus.OK);
    }

    @PostMapping("web/save/category")
    public ResponseEntity<?> savecategorys(@RequestBody CategoryRequest categoryRequest) {
        try {
            categoryService.saveCategory(categoryRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
