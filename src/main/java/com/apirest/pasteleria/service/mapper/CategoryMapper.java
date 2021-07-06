/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.mapper;

import com.apirest.pasteleria.entity.Category;
import com.apirest.pasteleria.entity.Price;
import com.apirest.pasteleria.service.dto.response.CategoryResponse;
import com.apirest.pasteleria.service.dto.response.PriceResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
        public List<CategoryResponse> mapper(List<Category> categoryEntitys) {
        List<CategoryResponse> CategoryDTO = new ArrayList<>();
        for(Category category:categoryEntitys){
            CategoryDTO.add(new CategoryResponse(category));
        }
        return CategoryDTO;
    }
}
