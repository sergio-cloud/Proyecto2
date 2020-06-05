package com.example.proyecto2.util;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;
import com.example.proyecto2.service.PerfilService;
//import com.example.proyecto2.service.PoblacionService;
import com.github.javafaker.Faker;
public class GeneradorPerfiles {
	EntityManager em;
	 
	public static Perfil Generar() {
		Poblacion poblacion = new Poblacion();
		Faker faker = new Faker();
		Perfil aux = new Perfil();
		aux.setNickName(faker.name().fullName() + faker.number().numberBetween(15, 99));
		aux.setEdad(faker.number().numberBetween(18, 60));
		if (faker.number().numberBetween(0, 1) == 0) {
			aux.setGenero("Hombre");
		} else
			aux.setGenero("Mujer");
		aux.setPassword("1234");
		poblacion.setIdPoblacion(faker.number().numberBetween(4, 54));
		poblacion.setNombrePoblacion("Madrid");
		aux.setPoblacion(poblacion);
		System.out.println("\n"+aux.toString());
		return aux;
	}
/*
	public static List<Perfil> generarLista(int cantidad) {
		List<Perfil> listPerfil = new ArrayList<Perfil>();
		for (int i = 0; i < cantidad; i++) {
			listPerfil.add(Generar());
		}
		return listPerfil;
	}*/
}