package com.example.proyecto2.service;

import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Descarte;

@Service
public interface DescarteService {
	
	public void dislike(Descarte descarte);

}
