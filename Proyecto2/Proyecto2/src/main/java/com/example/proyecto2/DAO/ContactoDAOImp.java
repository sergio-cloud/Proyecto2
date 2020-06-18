package com.example.proyecto2.DAO;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * @author Miguel
 * @version 04/06/20
 *
 */

//CLASE CUYOS OBJETOS SE RELACIONAN DIRECTAMENTE CON LA TABLA "contacto"
@Repository
public class ContactoDAOImp {

	@PersistenceContext
	EntityManager entityManager;
}
