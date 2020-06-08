package com.example.proyecto2.service;

import java.util.List;
import java.util.Optional;
import com.example.proyecto2.util.GeneradorPerfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.DAO.PerfilDAO;
import com.example.proyecto2.DAO.PerfilDAOImp;
import com.example.proyecto2.util.*;

@Service
public class PerfilServiceImp implements PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;
	
	@Autowired
	private PerfilDAOImp perfilDAOCustom;

	@Override
	public List<Perfil> findAll() {
		return perfilDAO.findAll();
	}
	
	@Override
	public void add(Perfil perfil) {
		perfilDAO.save(perfil);
	}

	public boolean existe(String nombre) {
		List<Perfil> comprobar = perfilDAO.findAll();
		for (int i = 0; i < comprobar.size(); i++) {
			if (comprobar.get(i).getNickName().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPerfil(String nombre, String pass) {
		List<Perfil> comprobar = perfilDAO.findAll();
		for (int i = 0; i < comprobar.size(); i++) {
			if ((comprobar.get(i).getNickName().equalsIgnoreCase(nombre))
					&& (comprobar.get(i).getPassword().equals(pass))) {
				return true;
			}
		}
		return false;

	}
/*
	@Override
	 public List<Perfil> getListaRandom (int cantidad) {
	   
	     List<Perfil> listPerfil= GeneradorPerfiles.generarLista(cantidad);
	    
	    
		return listPerfil;
	  
	  }
*/	
	public List<Perfil> listaPerfilDesconocido(Perfil perfil) {
		List<Perfil>lista=perfilDAOCustom.listaPerfilDesconocido(perfil);
		return lista;
	}

	@Override
	public void add(List<Perfil> lista) {
		for (Perfil p : lista) {
			perfilDAO.save(p);
		}
		
	}

	@Override
	public void addPerfilFalso() {
		perfilDAO.save(GeneradorPerfiles.Generar());
	}
	
	public void addPerfilFalso(int num) {
		for (int i = 0; i < num; i++) {
			perfilDAO.save(GeneradorPerfiles.Generar());
		}
	}

	@Override
	public Perfil findByNickname(String nickname) {		
		return perfilDAOCustom.findByNick(nickname);
	}
	
	public void delete(String nickname) {
		perfilDAO.delete(perfilDAOCustom.findByNick(nickname));
	}
}
