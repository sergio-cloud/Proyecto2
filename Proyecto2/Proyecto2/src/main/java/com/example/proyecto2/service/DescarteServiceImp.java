package com.example.proyecto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.DAO.DescarteDAO;
import com.example.proyecto2.model.Descarte;

/**
 * @author Miguel
 * @version 04/06/2020
 *
 */
@Service
public class DescarteServiceImp implements DescarteService {
	
	@Autowired
	private DescarteDAO descarteDAO;
	
	/**
	 * @author Miguel
	 * @version 04/06/2020
	 *
	 */
	//MÉTODO QUE LLAMA AL MÉTODO "descarteDAO" de la capa DAO
	public void dislike(Descarte descarte) {
		descarteDAO.save(descarte);
	}

}
