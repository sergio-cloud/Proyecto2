package com.example.proyecto2.service;

import java.util.List;

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

}
