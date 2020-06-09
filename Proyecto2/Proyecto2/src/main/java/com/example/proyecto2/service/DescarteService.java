package com.example.proyecto2.service;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Descarte;


/**
 * @author Miguel
 * @version 06/06/2020
 *
 */
@Service
public interface DescarteService {
	
	public void dislike(Descarte descarte);

}
