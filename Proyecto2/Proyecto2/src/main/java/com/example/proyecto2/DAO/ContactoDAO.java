package com.example.proyecto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto2.model.Contacto;

/**
 * @author Miguel
 * @version 04/06/20
 *
 */
@Repository
public interface ContactoDAO extends JpaRepository<Contacto, Integer> {
	
}