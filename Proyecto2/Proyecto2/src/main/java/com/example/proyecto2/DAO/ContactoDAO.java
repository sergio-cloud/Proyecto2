package com.example.proyecto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto2.model.Contacto;
import com.example.proyecto2.model.Perfil;

@Repository
public interface ContactoDAO extends JpaRepository<Contacto, Integer> {
	
}