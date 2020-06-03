package com.example.proyecto2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Poblacion;

@Service
public interface PoblacionService {
	
	public List<Poblacion> findAll();

}
