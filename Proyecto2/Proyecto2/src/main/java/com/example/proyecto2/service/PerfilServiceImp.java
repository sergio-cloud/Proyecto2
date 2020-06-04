package com.example.proyecto2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.DAO.PerfilDAO;

@Service
public class PerfilServiceImp implements PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;

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
}
