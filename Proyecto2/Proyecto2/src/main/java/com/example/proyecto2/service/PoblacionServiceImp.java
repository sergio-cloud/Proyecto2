package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.DAO.PoblacionDAO;
import com.example.proyecto2.model.Poblacion;

/**
 * @author Sergio
 * @version 04/06/2020
 *
 */
@Service
public class PoblacionServiceImp implements PoblacionService{
	
	@Autowired
	PoblacionDAO poblacionDAO;
	
	/**
	 * @author Nino
	 * @version 05/06/2020
	 *
	 */
	//MÉTODO QUE DEVUELVE UNA LISTA CON TODAS LAS POBLACIONES EN LA TABLA "poblacion" DE LA BASE DE DATOS
	@Override
	public List<Poblacion> findAll() {
		return poblacionDAO.findAll();
	}

	/**
	 * @author Sergio
	 * @version 06/06/2020
	 *
	 */
	//MÉTODO QUE DEVUELVE LA POBLACIÓN DETERMINADA POR EL ID INTRODUCIDO
	@Override
	public Optional<Poblacion> findByPoblacion(int idPoblacion) {
		return poblacionDAO.findById(idPoblacion);
	}

}
