package com.apirest.pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.pasteleria.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}
