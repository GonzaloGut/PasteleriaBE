package com.apirest.pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.pasteleria.entity.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long>{
}
