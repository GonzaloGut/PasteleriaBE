/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service;

import com.apirest.pasteleria.entity.Category;
import com.apirest.pasteleria.entity.Producto;
import com.apirest.pasteleria.repository.CategoryRepository;
import com.apirest.pasteleria.repository.ProductRepository;
import com.apirest.pasteleria.service.dto.request.CategoryRequest;
import com.apirest.pasteleria.service.dto.response.CategoryResponse;
import com.apirest.pasteleria.service.dto.response.ProductoResponse;
import com.apirest.pasteleria.service.mapper.CategoryMapper;
import com.apirest.pasteleria.service.mapper.ProductoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private CategoryMapper categoryMapper;

    //  @Transactional(readOnly = true)
    public  List<CategoryResponse> findAllCategorys() {
        return categoryMapper.mapper(categoryRepository.findAll());
    }

    public void saveCategory(CategoryRequest categoryRequest) {
        categoryRepository.save(new Category(categoryRequest));
    }

}

