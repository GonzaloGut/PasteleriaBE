/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service;

import com.apirest.pasteleria.entity.Category;
import com.apirest.pasteleria.entity.Price;
import com.apirest.pasteleria.entity.Producto;
import com.apirest.pasteleria.repository.CategoryRepository;
import com.apirest.pasteleria.repository.PriceRepository;
import com.apirest.pasteleria.repository.ProductRepository;
import com.apirest.pasteleria.service.dto.request.ProductoRequest;
import com.apirest.pasteleria.service.dto.response.ProductoResponse;
import com.apirest.pasteleria.service.mapper.ProductoMapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    @Autowired
    private ProductRepository productoRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductoMapper productoMapper;

    //  @Transactional(readOnly = true)
    public List<ProductoResponse> findAllProducts() {
        return productoMapper.mapper(productoRepository.findAll());
    }

    public ProductoResponse findOneProduct(Long id) {
        return productoMapper.mapperOne(
                productoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("El username no existe"))
        );
    }

    public void saveProducts(ProductoRequest productoRequest) {
        Producto newProducto = new Producto(productoRequest);
        List<Price> newListPrice = new ArrayList<>();
        List<Category> newListCategory = new ArrayList<>();
        Price listPrice = priceRepository.findById(productoRequest.getPrice())
                .orElseThrow(() -> new RuntimeException("Error: listPrice is not found."));
        Category listCategory = categoryRepository.findById(productoRequest.getCategories())
                .orElseThrow(() -> new RuntimeException("Error: listPrice is not found."));
        newListCategory.add(listCategory);
        newListPrice.add(listPrice);
        newProducto.setCategories(newListCategory);
        newProducto.setPrice(newListPrice);
        productoRepository.save(newProducto);
    }

}
