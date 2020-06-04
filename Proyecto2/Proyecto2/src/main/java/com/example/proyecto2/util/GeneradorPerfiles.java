package com.example.proyecto2.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;
import com.example.proyecto2.service.PoblacionService;
import com.github.javafaker.Faker;

public class GeneradorPerfiles {
	public static Perfil generar() {

		Poblacion poblacion=new Poblacion();
		Faker faker = new Faker();
		Perfil aux = new Perfil();
		aux.setNickName(faker.name().fullName() + faker.number().numberBetween(15, 99));
		aux.setEdad(faker.number().numberBetween(18, 60));
		if (faker.number().numberBetween(0, 1) == 0) {
			aux.setGenero("Hombre");
		} else
			aux.setGenero("Mujer");
		aux.setPassword("1234");
		poblacion.setIdPoblacion(faker.number().numberBetween(5, 54));
		poblacion.setNombrePoblacion("Esto ha sido hecho por Nino y Alvaro");
		aux.setPoblacion(poblacion);
		System.out.println(aux.toString());
		return aux;
	}
}
