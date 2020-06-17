package com.example.proyecto2.service;

import java.util.List;
import com.example.proyecto2.util.GeneradorPerfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto2.model.Contacto;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.DAO.PerfilDAO;
import com.example.proyecto2.DAO.PerfilDAOImp;

/**
 * @author Sergio
 * @author Alvaro
 * @author Nino
 * @author Miguel
 * @version 04/06/2020
 *
 */
@Service
public class PerfilServiceImp implements PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;

	@Autowired
	private PerfilDAOImp perfilDAOImp;

	// MÉTODO QUE PERMITE OBTENER TODOS LOS PERFILES DE LA BASE DE DATOS
	@Override
	public List<Perfil> findAll() {
		return perfilDAO.findAll();
	}

	// MÉTODO QUE PERMITE GUARDAR UN PERFIL EN LA BASE DE DATOS
	@Override
	public void add(Perfil perfil) {
		perfilDAO.save(perfil);
	}

	// MÉTODO QUE PERMITE SABER SI UN NICKNAME EXISTE EN LA BASE DE DATOS
	public boolean existe(String nombre) {
		List<Perfil> comprobar = perfilDAO.findAll();
		for (int i = 0; i < comprobar.size(); i++) {
			if (comprobar.get(i).getNickName().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	// MÉTODO QUE PERMITE SABER SI UN NICKNAME Y UNA PASWORD PERTENCEN A UN PERFIL
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

	// MÉTODO QUE PERMITE OBTENER LOS PERFILES QUE AUN NO HAN RECIBIDO LIKE O
	// DISLIKE DEL PERFIL QUE ESTA UTILIZANDO LA APLICACIÓN
	public List<Perfil> listaPerfilDesconocido(Perfil perfil) {
		List<Perfil> lista = perfilDAOImp.listaPerfilDesconocido(perfil);
		return lista;
	}

	public List<Perfil> listaPerfilContacto(Perfil perfil) {
		List<Perfil> lista = perfilDAOImp.listaPerfilContacto(perfil);
		return lista;
	}

	// MÉTODO QUE PERMITE AÑADIR UN PERFIL FALSO A LA BASE DE DATOS GENERADO POR EL
	// MÉTODO "Generar"
	@Override
	public void addPerfilFalso() {
		perfilDAO.save(GeneradorPerfiles.Generar());
	}

	// MÉTODO QUE PERMITE AÑADIR UN NUMERO DETERMINADO POR EL PARÁMETRO DE ENTRADA
	// PERFIL FALSO A LA BASE DE DATOS GENERADO POR EL MÉTODO "Generar"
	public void addPerfilFalso(int num) {
		for (int i = 0; i < num; i++) {
			perfilDAO.save(GeneradorPerfiles.Generar());
		}
	}

	// MÉTODO QUE LLAMA AL MÉTODO "findByNick" DE LA CAPA DAO Y DEVUELVE TODOS LOS
	// DATOS DE SU PERFIL
	@Override
	public Perfil findByNickname(String nickname) {
		return perfilDAOImp.findByNick(nickname);
	}

	// MÉTODO QUE LLAMA AL MÉTODO "findByNick" DE LA CAPA DAO Y BORRA EL PERFIL CON
	// EL NICKNAME SELECCIONADO
	public void delete(String nickname) {
		perfilDAO.delete(perfilDAOImp.findByNick(nickname));
	}

	@Override
	public void add(List<Perfil> lista) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Perfil> listaPerfilDescarte(Perfil perfil) {
		List<Perfil> lista = perfilDAOImp.listaPerfilDescarte(perfil);
		return lista;
	}
	
	public List<Contacto> listaPerfilMatch(Perfil perfil) {
		List<Contacto>lista=perfilDAOImp.listaPerfilMatch(perfil);
		return lista;
	}

	@Override
	public List<Perfil> listaPerfilDesconocidoGenero(Perfil perfil) {
		List<Perfil> lista = perfilDAOImp.listaPerfilDesconocidoGenero(perfil);
		return lista;
	}
}
