package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Contacto;
;


@Service
public interface ContactoService {
	
	public void like(Contacto contacto);
	
	public List<Contacto> findAll();
	
	public Optional<Contacto> findById(int IdContacto);

}