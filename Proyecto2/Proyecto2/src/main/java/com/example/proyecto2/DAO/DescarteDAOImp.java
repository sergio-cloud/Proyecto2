package com.example.proyecto2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * @author Miguel
 * @version 04/06/20
 *
 */
@Repository
public class DescarteDAOImp {

	@PersistenceContext
	EntityManager entityManager;

}
