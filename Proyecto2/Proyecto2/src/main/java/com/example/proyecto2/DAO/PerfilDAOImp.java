package com.example.proyecto2.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.proyecto2.model.Perfil;

@Repository
public class PerfilDAOImp {

	@PersistenceContext
	EntityManager entityManager;

	public List<Perfil> listaPerfilDesconocido(Perfil perfil) {
			Query query = entityManager
					.createNativeQuery("SELECT * FROM perfil WHERE perfil.nickname <> ? AND\r\n" + 
							"nickname NOT IN\r\n" + 
							"                (SELECT nickname2\r\n" + 
							"                FROM contacto\r\n" + 
							"                WHERE nickname1 = ?)\r\n" + 
							"AND\r\n" + 
							"nickname NOT IN\r\n" + 
							"                (SELECT nickname2\r\n" + 
							"                FROM descarte\r\n" + 
							"                WHERE nickname1 = ?) LIMIT 1;", Perfil.class);
			query.setParameter(1, perfil.getNickName());
			query.setParameter(2, perfil.getNickName());
			query.setParameter(3, perfil.getNickName());
			return query.getResultList();
	}
	
	public Perfil findByNick(String nickname) {
		Query query = entityManager
				.createNativeQuery("SELECT * FROM perfil WHERE perfil.nickname=? ;", Perfil.class);
		query.setParameter(1, nickname);
		return (Perfil)query.getSingleResult();
}
}
