package com.apirest.pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.pasteleria.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
