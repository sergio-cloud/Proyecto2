package com.example.proyecto2.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.proyecto2.model.Contacto;
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

    //ESTE METODO NOS PERMITE SACAR UNA LISTA DE PERFILES DESCONOCIDOS POR UL PERFIL LOGGEADO
	//DE LA TABLA "perfil"
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
	
	//ESTE METODO NOS PERMITE OBTENER UNA LISTA DE PERFILES QUE HAN RECIBIDO "like" DEL
	//PERFIL LOGGEADO
	public List<Perfil> listaPerfilContacto(Perfil perfil) {
		Query query = entityManager.createNativeQuery("select * from perfil\r\n"  
				+"  where nickname in (select nickname2 from contacto\r\n" 
				+"                 where nickname2<>?\r\n" 
				+"                 AND nickname1=?);", Perfil.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getNickName());
		return query.getResultList();
	}

	
    //ESTE METODO NOS PERMITE ENCONTRAR UN PERFIL EN LA TABLA "perfil" A TRAVES DE SU NICKNAME
	public Perfil findByNick(String nickname) {
		Query query = entityManager.createNativeQuery("SELECT * FROM perfil WHERE perfil.nickname=? ;", Perfil.class);
		query.setParameter(1, nickname);
		return (Perfil) query.getSingleResult();
	}

	
	//ESTE METODO DEVUELVE UNA LISTA CON LOS PERFILES QUE HAN DADO LIKE AL PERFIL LOGGEADO Y VICEVERSA
	public List<Contacto> listaPerfilMatch(Perfil perfil) {
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM contacto WHERE nickname1= ? AND nickname2 IN (SELECT nickname1 FROM contacto WHERE nickname2 =?);",
				Contacto.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getNickName());
		return query.getResultList();
	}
	
	//ESTE METODO PERMITE OBTENER UNA LISTA CON LOS PERFILES QUE HA DESCARTADO EL PERFIL LOGGEADO
	public List<Perfil> listaPerfilDescarte(Perfil perfil) {
		Query query = entityManager.createNativeQuery("select * from perfil\r\n"  
				+"  where nickname in (select nickname2 from descarte\r\n" 
				+"                 where nickname2<>?\r\n" 
				+"                 AND nickname1=?);", Perfil.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getNickName());
		return query.getResultList();
	}
	
	
	//ESTE METODO PERMITE OBTENER UNA LISTA DE PERFILES QUE NO HAN RECIBIDO "like" NI "dislike" DEL USUARIO LOGGEADO
	//Y ADEMAS FILTRARLOS POR GENERO
	public List<Perfil> listaPerfilDesconocidoGenero(Perfil perfil) {
		Query query = entityManager.createNativeQuery("SELECT * FROM perfil WHERE perfil.nickname <> ? AND\r\n"
				+ "perfil.genero = ? AND\r\n"
				+ "nickname NOT IN\r\n" + "                (SELECT nickname2\r\n" + "                FROM contacto\r\n"
				+ "                WHERE nickname1 = ?)\r\n" + "AND\r\n" + "nickname NOT IN\r\n"
				+ "                (SELECT nickname2\r\n" + "                FROM descarte\r\n"
				+ "                WHERE nickname1 = ?) LIMIT 1;", Perfil.class);
		query.setParameter(1, perfil.getNickName());
		query.setParameter(2, perfil.getGenero());
		query.setParameter(3, perfil.getNickName());
		query.setParameter(4, perfil.getNickName());

		return query.getResultList();
	}
}
