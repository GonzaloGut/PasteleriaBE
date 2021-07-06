package com.apirest.pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.pasteleria.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
