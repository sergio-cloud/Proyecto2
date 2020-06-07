package com.example.proyecto2.restcontroller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;
import com.example.proyecto2.service.PerfilService;
import com.example.proyecto2.service.PoblacionService;
@RestController
public class UserRestController {
	@Autowired
	PoblacionService PoblacionService;
	
	@Autowired
	PerfilService PerfilService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	//LISTADO DE TODAS LAS POBLACIONES   NINO
	@RequestMapping(
			value = "/poblacion/listado",
			method = RequestMethod.GET,
			headers = {"Accept=application/json" },
			produces = "application/json; charset=utf-8")
	
	public List<Poblacion> getPoblacion() {
		logger.info("---En listado: Poblaciones");
		return PoblacionService.findAll();
	}
	
	//DEVUELVE UNA POBLACION (idPoblacion)    SERGIO
	@RequestMapping(
			value = "/poblacion/{idPoblacion}",
			method = RequestMethod.GET,
			headers = {"Accept=application/json" },
			produces = "application/json; charset=utf-8")
	
	public Optional<Poblacion> getPoblacionByIdPoblacion(@PathVariable int idPoblacion) {
		logger.info("---Obteniendo población por Id---");
		return PoblacionService.findByPoblacion(idPoblacion);
	}
	

	
	//DEVUELVE LISTADO DE TODOS LOS PERFILES REGISTRADOS   NINO
	@RequestMapping(
			value = "/perfil/listado",
			method = RequestMethod.GET,
			headers = {"Accept=application/json" },
			produces = "application/json; charset=utf-8")
	
	public List<Perfil> getPerfiles() {
		logger.info("---En listado: Perfil");
		return PerfilService.findAll();
	}
	
}