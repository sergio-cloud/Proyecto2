package com.example.proyecto2.service;

import java.util.List;

import com.example.proyecto2.model.Perfil;

public interface PerfilService {

	public List<Perfil> findAll();
	
	public void add(Perfil perfil);
	
	public boolean existe(String nombre);
	
	public boolean isPerfil(String nombre, String pass);
	
	public List<Perfil> getListaRandom (int id);
}
