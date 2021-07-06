/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.pasteleria.service;

import com.apirest.pasteleria.entity.Login;
import com.apirest.pasteleria.entity.Pedido;
import com.apirest.pasteleria.entity.Producto;
import com.apirest.pasteleria.repository.LoginRepository;
import com.apirest.pasteleria.repository.PedidoRepository;
import com.apirest.pasteleria.repository.ProductRepository;
import com.apirest.pasteleria.service.dto.request.PedidoRequest;
import com.apirest.pasteleria.service.dto.response.PedidoResponse;
import com.apirest.pasteleria.service.dto.response.PersonaResponse;
import com.apirest.pasteleria.service.dto.response.ProductoResponse;
import com.apirest.pasteleria.service.mapper.ProductoMapper;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public String generarPedido(Principal userP, PedidoRequest pedidoR) {
        String response = "No se Guardo";
        Login user = loginRepository.findByUsername(
                userP.getName())
                .orElseThrow(() -> new RuntimeException("El username no existe"));
        Pedido newPedido = new Pedido(pedidoR.getCantidad(), user.getPersona().getIdpersona(), pedidoR.getFkproduct());
        newPedido.setEst(true);
        try {
            pedidoRepository.save(newPedido);
            response = "Resgistro Exitoso";
        } catch (Exception e) {
            System.out.println(e);
            response = "Np se guardo";
        }
        return response;
    }

    public List<PedidoResponse> listPedido(Principal userP) {
        String username = userP.getName();

        Login user = loginRepository.findByUsername(
                username)
                .orElseThrow(() -> new RuntimeException("El username no existe"));
        List<PedidoResponse> pedidoResponse = new ArrayList<>();
        for (Pedido pedido : user.getPersona().getFkpedido()) {
            Producto producto = productRepository.findById(pedido.getFkproduct())
                    .orElseThrow(() -> new RuntimeException("El producto no existe"));
            pedidoResponse.add(new PedidoResponse(pedido, productoMapper.mapperOne(producto)));
        }
        return pedidoResponse;
    }
}
