package com.example.proyecto2.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.example.proyecto2.model.Perfil;

/**
 * @author Miguel
 * @version 05/06/20
 * @author Alvaro
 * @version 08/06/20
 */
@Repository
public class PerfilDAOImp {

	@PersistenceContext
	EntityManager entityManager;

	// CON ESTA QUERY ESTAMOS DEVOLVIENDO UN PERFIL QUE NO SE ENCUENTRE NI EN LA
	// TABLA CONTACTO NI EN LA TABLA DESCARTE
	// Y QUE ADEMAS SEA DIFERENTE AL USUARIO QUE SE HA LOGEADO

	public List<Perfil> listaPerfilDesconocido(Perfil perfil) {
		Query query = entityManager.createNativeQuery("SELECT * FROM perfil WHERE perfil.nickname <> ? AND\r\n"
				+ "nickname NOT IN\r\n" + "                (SELECT nickname2\r\n" + "                FROM contacto\r\n"
				+ "                WHERE nickname1 = ?)\r\n" + "AND\r\n" + "nickname NOT IN\r\n"
				+ "                (SELECT nickname2\r\n" + "                FROM descarte\r\n"
				+ "                WHERE nickname1 = ?) LIMIT 1;", Perfil.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getNickName());
		query.setParameter(3, perfil.getNickName());
		return query.getResultList();
	}
	
	public List<Perfil> listaPerfilContacto(Perfil perfil) {
		Query query = entityManager.createNativeQuery("select * from perfil\r\n"  
				+"  where nickname in (select nickname2 from contacto\r\n" 
				+"                 where nickname2<>?\r\n" 
				+"                 AND nickname1=?);", Perfil.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getNickName());
		return query.getResultList();
	}

	// USAMOS ESTA QUERY PARA BUSCAR UN PERFIL BASADO EN SU NICKNAME

	public Perfil findByNick(String nickname) {
		Query query = entityManager.createNativeQuery("SELECT * FROM perfil WHERE perfil.nickname=? ;", Perfil.class);
		query.setParameter(1, nickname);
		return (Perfil) query.getSingleResult();
	}

	// ESTA QUERY TE DEVUELVE UNA LISTA DE LOS CONTACTOS QUE HAS DADO LIKE Y TE HAN
	// DADO LIKE

	public List<Perfil> listaPerfilMatch(Perfil perfil) {
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM contacto WHERE nickname1= ? AND nickname2 IN (SELECT nickname1 FROM contacto WHERE nickname2 =?);",
				Perfil.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getNickName());
		return query.getResultList();
	}
}
