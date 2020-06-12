package com.example.proyecto2.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.proyecto2.model.Contacto;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;
import com.example.proyecto2.service.PerfilService;
import com.example.proyecto2.service.PoblacionService;
import com.example.proyecto2.service.ContactoService;

/**
 * @author Nino
 * @version 05/06/2020
 */

//REST CONTROLLER DEVUELVE OBJETOS EN FORMATO JSON
@CrossOrigin(origins = "*", maxAge = 5600)
@RestController
@SessionAttributes("perfil")
public class UserRestController {
	@Autowired
	PoblacionService PoblacionService;

	@Autowired
	PerfilService PerfilService;

	@Autowired
	ContactoService ContactoService;

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	// LISTADO DE TODAS LAS POBLACIONES NINO
	@RequestMapping(value = "/poblacion/listado", method = RequestMethod.GET, headers = {
			"Accept=application/json" }, produces = "application/json; charset=utf-8")

	public List<Poblacion> getPoblacion() {
		logger.info("---En listado: Poblaciones");
		return PoblacionService.findAll();
	}

	// DEVUELVE UNA POBLACION (idPoblacion) SERGIO
	@RequestMapping(value = "/poblacion/{idPoblacion}", method = RequestMethod.GET, headers = {
			"Accept=application/json" }, produces = "application/json; charset=utf-8")

	public Optional<Poblacion> getPoblacionByIdPoblacion(@PathVariable int idPoblacion) {
		logger.info("---Obteniendo población por Id---");
		return PoblacionService.findByPoblacion(idPoblacion);
	}

	// DEVUELVE LISTADO DE TODOS LOS PERFILES REGISTRADOS NINO
	@RequestMapping(value = "/perfil/listado", method = RequestMethod.GET, headers = {
			"Accept=application/json" }, produces = "application/json; charset=utf-8")

	public List<Perfil> getPerfiles() {
		logger.info("---En listado: Perfil");
		return PerfilService.findAll();
	}

	// DEVUELVE LISTA DE TODOS LOS CONTACTOS
	// LOGEADO NINO
	@RequestMapping(value = "/contacto/listado", method = RequestMethod.GET)

	public List<Contacto> getContacto() {
		logger.info("---En listado: Contacto");
		return ContactoService.findAll();
	}

	// DEVUELVE LOS CONTACTOS POR SU ID NINO
	@GetMapping(value = "/contacto/{idContacto}")

	public Optional<Contacto> getContactoByIdContacto(@PathVariable int idContacto) {
		logger.info("---Obteniendo contacto por Id---");
		return ContactoService.findById(idContacto);
	}
	
	//DEVUELVE UNA LISTA DE CONTACTOS POR USUARIO
	@RequestMapping(value = "/contacto/listacontacto", method = RequestMethod.GET, headers = {
	"Accept=application/json" }, produces = "application/json; charset=utf-8")
	public List<Perfil> getListaContacto(@RequestBody Perfil perfil){
		logger.info("---Obteniendo lista de personas que han recibido like del perfil entrante---");
		return PerfilService.listaPerfilContacto(perfil);
	}
	
	@GetMapping(value = "/perfil/listadesconocido")
	public List<Perfil> getListaDesconocido(@RequestBody Perfil perfil){
		logger.info("----Obteniendo lista de personas desconocidas por perfil entrante---");
		return PerfilService.listaPerfilDesconocido(perfil);
	}

	// DEVUELVE UN PERFIL REGISTRADO POR SU NICKNAME NINO
	@GetMapping(value = "/perfil/{nickname}")

	public Optional<Perfil> getPerfilByNicknamePerfil(@PathVariable String nickname) {
		logger.info("---Obteniendo Perfil por nickname---");
		return Optional.ofNullable(PerfilService.findByNickname(nickname));
	}

	// AGREGA UN NUEVO PERFIL--REST NINO
	@PostMapping(value = "/addPerfil")

	public ResponseEntity<?> newPerfil(@RequestBody Perfil perfil) {
		logger.info("---Creando un nuevo Perfil en REST---");
		PerfilService.add(perfil);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nickname}")
				.buildAndExpand(perfil.getNickName()).toUri();
		return ResponseEntity.created(location).build();
	}

	/*
	 * no funciona aún NINO
	 * 
	 * @DeleteMapping("/{nickname}") public void deletePerfil(@PathVariable String
	 * nickname) { PerfilService.delete(nickname); }
	 */
}