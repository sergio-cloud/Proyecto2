package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Contacto;
;

/**
 * @author Miguel
 * @version 04/06/2020
 *
 */

@Service
public interface ContactoService {
	
	/**
	 * @author Miguel
	 * @version 04/06/2020
	 *
	 */
	public void like(Contacto contacto);
	
	
	/**
	 * @author Nino
	 * @version 07/06/2020
	 *
	 */
	public List<Contacto> findAll();
	
	/**
	 * @author Nino
	 * @version 07/06/2020
	 *
	 */
	public Optional<Contacto> findById(int IdContacto);

}