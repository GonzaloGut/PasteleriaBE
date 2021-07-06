/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service.mapper;
import com.apirest.pasteleria.entity.Price;
import com.apirest.pasteleria.service.dto.response.PriceResponse;
import java.util.ArrayList;;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {
    public List<PriceResponse> mapper(List<Price> priceEntitys) {
        List<PriceResponse> PriceDTO = new ArrayList<>();
        for(Price price:priceEntitys){
            PriceDTO.add(new PriceResponse(price));
        }
        return PriceDTO;
    }
    
}
