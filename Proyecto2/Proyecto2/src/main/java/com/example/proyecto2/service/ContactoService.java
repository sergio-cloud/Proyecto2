package com.example.proyecto2.service;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Contacto;

@Service
public interface ContactoService {
	
	public void like(Contacto contacto);

}