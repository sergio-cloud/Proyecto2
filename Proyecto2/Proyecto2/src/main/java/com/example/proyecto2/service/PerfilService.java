package com.example.proyecto2.service;

import java.util.List;

import com.example.proyecto2.model.Contacto;
import com.example.proyecto2.model.Perfil;

/**
 * @author Sergio
 * @author Alvaro
 * @author Nino
 * @author Miguel
 * @version 04/06/2020
 *
 */
public interface PerfilService {

	public List<Perfil> findAll();
	
	public void add(Perfil perfil);
	
	public boolean existe(String nombre);
	
	public boolean isPerfil(String nombre, String pass);
	
	public List<Perfil> listaPerfilDesconocido(Perfil perfil);
	
	public List<Perfil> listaPerfilDesconocidoGenero(Perfil perfil);
	
	public List<Perfil> listaPerfilContacto(Perfil perfil);
	
	public void add(List<Perfil> lista);
	
	public void addPerfilFalso();
	
	public void addPerfilFalso(int num);
	
	public Perfil findByNickname(String nickname);
	
	public void delete(String nickname);

	public List<Perfil> listaPerfilDescarte(Perfil perfil);

	public List<Contacto> listaPerfilMatch(Perfil perfil);
}
