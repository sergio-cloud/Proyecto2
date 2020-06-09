package com.example.proyecto2.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.proyecto2.service.PerfilService;
import com.example.proyecto2.service.PoblacionService;
import com.example.proyecto2.service.ContactoService;
import com.example.proyecto2.service.DescarteService;

import com.example.proyecto2.model.Contacto;
import com.example.proyecto2.model.Descarte;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Controller
@SessionAttributes("perfil")
public class UseController {

	@Autowired
	PoblacionService PoblacionService;
	@Autowired
	PerfilService PerfilService;
	@Autowired
	ContactoService contactoService;
	@Autowired
	DescarteService descarteService;

	private static final Logger logger = LoggerFactory.getLogger(UseController.class);

	// GENERAMOS Y ENVIAMOS UN PERFIL VACIO AL HMTL LOGGIN
	@GetMapping("/")
	public String login(ModelMap model) throws Exception {
		logger.info("--- UseController > login (/)");
		model.addAttribute("perfil", new Perfil());
		return "login";
	}

	// VALIDA EL EL USERNAME Y LA PASS EL PERFIL QUE SE QUIERE LOGGEAR
	@PostMapping("/")
	public String saveLogin(@Valid Perfil perfil, BindingResult result, ModelMap model) {
		logger.info("--- UseController > saveLogin (/)");
		logger.info("-- Datos del perfil 1" + perfil);
		// EN EL CASO DE TENER ERRORES TE VUELVE AL LOGIN MOSTRANOTE LOS ERRORES
		if (result.hasErrors()) {
			logger.info("--- Hay algunos errores");
			return "login";
		}
		// SI TE LOGEAS BIEN, ENTRAS EN LA APLICACION
		if (PerfilService.isPerfil(perfil.getNickName(), perfil.getPassword())) {
			model.addAttribute("perfil", perfil);
			model.addAttribute("success", "Estimado " + perfil.getNickName() + " , se ha loggeado de forma correcta");
			logger.info("--- entro");
			PerfilService.addPerfilFalso();
			model.addAttribute("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
			return "redirect:/bienvenida";
			// EN EL CASO DE TENER ERRORES TE VUELVE AL LOGIN MOSTRANOTE LOS ERRORES
		} else if (!PerfilService.isPerfil(perfil.getNickName(), perfil.getPassword())) {
			model.addAttribute("warning", perfil.getNickName() + " No existe en la base de datos.");
			logger.info("--- entro");
		}
		return "login";
	}

	// GENERAMOS Y ENVIAMOS UN PERFIL Y UNA POBLACION VACIA, TMBN ENVIAMOS LA LISTA
	// DE POBLACION, PARA GENERAR UN PERFIL NUEVO
	@GetMapping("/altaPerfil")
	public String registroPerfil(ModelMap model) throws Exception {
		logger.info("--- UseController > registroPerfil (/altaPerfil)");
		model.addAttribute("perfil", new Perfil());
		model.addAttribute("poblacion", new Poblacion());
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		return "altaPerfil";
	}

	// VALIDAMOS LOS DATOS DEL NUEVO PERFIL
	@PostMapping("/altaPerfil")
	public String saveRegistration(@ModelAttribute @Valid Perfil perfil, BindingResult result, ModelMap model) {
		logger.info("--- UseController > saveRegistration (/altaPerfil)");
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		// SI TIENE ERRORES, VUELVES AL FORMULARIO DEL PERFIL Y TE MUESTRA LOS ERRORES
		if (result.hasErrors()) {
			logger.info("--- Hay algunos errores");
			return "altaPerfil";
		}
		//SI ENCUENTRA EL PERFIL EN LA BBDD Y EL NICKNAME Y LA PASS SON LOS MISMOS ENTRAS EN LA APP
		if (!PerfilService.existe(perfil.getNickName())) {
			PerfilService.add(perfil);
			model.addAttribute("success",
					"Estimado " + perfil.getNickName() + " , su registro se ha completado de forma correcta");
			model.addAttribute("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
			return "bienvenida";
		// SI EL PERFIL YA EXISTE (NICKNAME) TE DEVUELVE AL FORMULARIO Y TE MUESTRA EL MENSAJE
		} else {
			model.addAttribute("warning", perfil.getNickName() + " Ya existe en la base de datos.");
			logger.info("--- entro");
			return "altaPerfil";
		}
	}
	
	//TE MUESTRA LA PAGINA CON LA LISTA DE PERFILES DESCONOCIDOS PARA AR LIKE O DISLIKE
	@GetMapping("/bienvenida")
	public ModelAndView bienvenida(@ModelAttribute Perfil perfil, ModelAndView model) {
		logger.info("--- UseController > Bienvenida (get)");
		model.addObject("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
		logger.info("-- Datos del perfil 2" + perfil);
		model.setViewName("bienvenida");
		return model;
	}
	
	/*
	@PostMapping("/bienvenida")
	public ModelAndView bienvenida2(@ModelAttribute Perfil perfil, ModelAndView model) {
		logger.info("--- UseController > Bienvenida (post)");
		model.addObject("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
		logger.info("---------------------------- Datos del perfil 3" + perfil);
		model.setViewName("bienvenida");
		return model;
	}*/
	
	//RECOGEMOS EL NICKNAME DEL PERFIL QUE RECIBE EL 'LIKE' + EL DE LA SESSION Y LOS INSERTAMOS EN LA TABLA CONTACTO
	@GetMapping("/like")
	public String like(@ModelAttribute Perfil perfil, @RequestParam("perfil2") String perfil2, ModelAndView model) {
		logger.info("---UseController > like (/like)");
		Perfil perfil3 = new Perfil();
		perfil3 = PerfilService.findByNickname(perfil2);
		Contacto contacto = new Contacto();
		contacto.setNickname1(perfil);
		contacto.setNickname2(perfil3);
		contactoService.like(contacto);
		return "redirect:/bienvenida";
	}
	//RECOGEMOS EL NICKNAME DEL PERFIL QUE RECIBE EL 'DISLIKE' + EL DE LA SESSION Y LOS INSERTAMOS EN LA TABLA DESCARTE
	@GetMapping("/dislike")
	public String dislike(@ModelAttribute Perfil perfil, @RequestParam("perfil2") String perfil2, ModelAndView model) {
		logger.info("---------------------------- Datos del perfil 5" + perfil);
		Perfil perfil3 = new Perfil();
		perfil3 = PerfilService.findByNickname(perfil2);
		Descarte descarte = new Descarte();
		descarte.setNickname1(perfil);
		descarte.setNickname2(perfil3);
		descarteService.dislike(descarte);
		return "redirect:/bienvenida";
	}
}
