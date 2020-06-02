package com.example.proyecto2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PerfilDAOImp {

	@PersistenceContext
	EntityManager entityManager;
	
}
