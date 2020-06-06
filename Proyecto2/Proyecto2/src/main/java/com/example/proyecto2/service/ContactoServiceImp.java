package com.example.proyecto2.service;

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
}