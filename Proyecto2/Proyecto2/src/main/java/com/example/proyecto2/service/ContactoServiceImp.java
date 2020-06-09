package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.DAO.ContactoDAO;
import com.example.proyecto2.model.Contacto;


/**
 * @author Miguel
 * @version 04/06/2020
 *
 */
@Service
public class ContactoServiceImp implements ContactoService {
	
	@Autowired
	private ContactoDAO contactoDAO;
	
	/**
	 * @author Miguel
	 * @version 04/06/2020
	 *
	 */
	//MÉTODO QUE LLAMA AL MÉTODO "save" DE LA CAPA DAO
	public void like(Contacto contacto) {
		contactoDAO.save(contacto);
	}
	
	/**
	 * @author Nino
	 * @version 07/06/2020
	 *
	 */
	//LISTA DE TODOS LOS CONCATOS DE UN PERFIL
	public List<Contacto> findAll() {
		
		return contactoDAO.findAll();
	}

	/**
	 * @author Nino
	 * @version 04/06/2020
	 *
	 */
	//ENCUENTRA A UN PERFIL POR SU NICKNAME
	@Override
	public Optional<Contacto> findById(int IdContacto) {
		
		return contactoDAO.findById(IdContacto);
	}
	
	
}