package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.DAO.ContactoDAO;
import com.example.proyecto2.model.Contacto;


@Service
public class ContactoServiceImp implements ContactoService {
	
	@Autowired
	private ContactoDAO contactoDAO;
	
	public void like(Contacto contacto) {
		contactoDAO.save(contacto);
	}
	
	public List<Contacto> findAll() {
		
		return contactoDAO.findAll();
	}

	@Override
	public Optional<Contacto> findById(int IdContacto) {
		
		return contactoDAO.findById(IdContacto);
	}
	
	
}