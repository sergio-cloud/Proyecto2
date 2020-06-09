package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Poblacion;

/**
 * @author Sergio
 * @version 05/06/2020
 *
 */
@Service
public interface PoblacionService {
	
	public List<Poblacion> findAll();

	public Optional<Poblacion> findByPoblacion(int idPoblacion);

}
