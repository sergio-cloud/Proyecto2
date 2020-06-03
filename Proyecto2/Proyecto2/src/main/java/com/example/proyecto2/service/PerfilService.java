package com.example.proyecto2.service;

import java.util.List;

import com.example.proyecto2.model.Perfil;

public interface PerfilService {

	public List<Perfil> findAll();
	
	public void add(Perfil perfil);
	
	public boolean comprobar(Perfil perfil);
}
