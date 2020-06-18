package com.example.proyecto2.util;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.proyecto2.controller.UseController;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;
import com.github.javafaker.Faker;


/**
 * @author Alvaro
 * @version 05/06/2020
 */
public class GeneradorPerfiles {
	EntityManager em;
	private static final Logger logger = LoggerFactory.getLogger(UseController.class);
	 
	//METODO QUE GENERA UN PERFIL CON TODOS LOS ATRIBUTOS ALEATORIOS Y LO DEVUELVE
	
	public static Perfil Generar() {
		Poblacion poblacion = new Poblacion();
		Faker faker = new Faker();
		Perfil aux = new Perfil();
		aux.setNickName(faker.name().firstName() + faker.number().numberBetween(15, 99));
		aux.setEdad(faker.number().numberBetween(18, 60));
		if (faker.number().numberBetween(0, 100) % 2==0) {
			aux.setGenero("Hombre");
		} else
			aux.setGenero("Mujer");
		aux.setPassword("1234");
		poblacion.setIdPoblacion(faker.number().numberBetween(4, 54));
		poblacion.setNombrePoblacion("Madrid");
		aux.setPoblacion(poblacion);
		logger.info(aux.toString());
		return aux;
	}

}