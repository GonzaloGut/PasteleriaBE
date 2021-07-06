package com.apirest.pasteleria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.pasteleria.entity.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	Boolean existsByUsername(String username);
	Optional<Login> findByUsername(String username);

}
