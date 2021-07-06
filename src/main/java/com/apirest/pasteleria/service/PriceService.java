/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service;

import com.apirest.pasteleria.entity.Price;
import com.apirest.pasteleria.entity.Producto;
import com.apirest.pasteleria.repository.PriceRepository;
import com.apirest.pasteleria.repository.ProductRepository;
import com.apirest.pasteleria.service.dto.request.PriceRequest;
import com.apirest.pasteleria.service.dto.response.PriceResponse;
import com.apirest.pasteleria.service.dto.response.ProductoResponse;
import com.apirest.pasteleria.service.mapper.PriceMapper;
import com.apirest.pasteleria.service.mapper.ProductoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    //  @Transactional(readOnly = true)
    public List<PriceResponse> findAllPrices() {
        return priceMapper.mapper(priceRepository.findAll());
    }

    public void savePrice(PriceRequest priceRequest) {
        priceRepository.save(new Price(priceRequest));
    }

}
