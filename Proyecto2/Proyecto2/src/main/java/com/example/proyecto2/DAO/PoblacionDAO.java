package com.example.proyecto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto2.model.Poblacion;

@Repository
public interface PoblacionDAO extends JpaRepository<Poblacion, Integer> {
	
}
