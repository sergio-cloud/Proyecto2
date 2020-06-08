package com.example.proyecto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.DAO.DescarteDAO;
import com.example.proyecto2.model.Descarte;

@Service
public class DescarteServiceImp {
	
	@Autowired
	private DescarteDAO descarteDAO;
	
	public void dislike(Descarte descarte) {
		descarteDAO.save(descarte);
	}

}
