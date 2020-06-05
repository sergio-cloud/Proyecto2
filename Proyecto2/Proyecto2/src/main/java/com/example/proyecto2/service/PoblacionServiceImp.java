package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.DAO.PoblacionDAO;
import com.example.proyecto2.model.Poblacion;

@Service
public class PoblacionServiceImp implements PoblacionService{
	
	@Autowired
	PoblacionDAO poblacionDAO;
	
	@Override
	public List<Poblacion> findAll() {
		return poblacionDAO.findAll();
	}

	@Override
	public Optional<Poblacion> findByPoblacion(int idPoblacion) {
		return poblacionDAO.findById(idPoblacion);
	}

}
