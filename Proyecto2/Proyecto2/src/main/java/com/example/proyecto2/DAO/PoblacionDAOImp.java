package com.example.proyecto2.DAO;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.proyecto2.model.Poblacion;

@Repository
public class PoblacionDAOImp {
	
	@PersistenceContext
	EntityManager entityManager;


}
