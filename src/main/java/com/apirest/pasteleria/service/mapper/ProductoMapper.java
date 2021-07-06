/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.mapper;

import com.apirest.pasteleria.entity.Producto;
import com.apirest.pasteleria.service.dto.response.ProductoResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private PriceMapper priceMapper;
    
    @Autowired
    private CategoryMapper categoryMapper;

    public List<ProductoResponse> mapper(List<Producto> productoEntitys) {
        List<ProductoResponse> ProductoDTO = new ArrayList<>();
        for (Producto producto : productoEntitys) {
            ProductoDTO.add(new ProductoResponse(
                    producto,
                    priceMapper.mapper(producto.getPrice()),
                    categoryMapper.mapper(producto.getCategories())
            ));
        }
        return ProductoDTO;
    }
    
     public ProductoResponse mapperOne(Producto productoEntity) {
        return new ProductoResponse(
                productoEntity,
                priceMapper.mapper(productoEntity.getPrice()),
                categoryMapper.mapper(productoEntity.getCategories())
        );
    }
}
