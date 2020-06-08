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
import com.example.proyecto2.util.GeneradorPerfiles;

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

	@GetMapping("/")
	public String login(ModelMap model) throws Exception {
		logger.info("--- UseController > login (/)");
		model.addAttribute("perfil", new Perfil());
		// model.addAttribute("poblacion",new Poblacion());
		return "login";
	}

	@PostMapping("/")
	public String saveLogin(@Valid Perfil perfil, BindingResult result, ModelMap model) {
		logger.info("--- UseController > saveLogin (/)");
		System.out.println("-- Datos del perfil 1" + perfil);
		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "login";
		}

		if (PerfilService.isPerfil(perfil.getNickName(), perfil.getPassword())) {
			model.addAttribute("perfil", perfil);
			model.addAttribute("success", "Estimado " + perfil.getNickName() + " , se ha loggeado de forma correcta");
			System.out.println("--- entro");

			// CADA VEZ QUE TE LOGEAS SE GENERARAN 10 NUEVOS PERFILES ALEATORIOS
			PerfilService.addPerfilFalso();
			model.addAttribute("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
			return "redirect:/bienvenida";

		} else if (!PerfilService.isPerfil(perfil.getNickName(), perfil.getPassword())) {
			model.addAttribute("warning", perfil.getNickName() + " No existe en la base de datos.");
			System.out.println("--- entro");
		}
		return "login";
	}

	@GetMapping("/altaPerfil")
	public String registroPerfil(ModelMap model) throws Exception {
		logger.info("--- UseController > registroPerfil (/altaPerfil)");
		model.addAttribute("perfil", new Perfil());
		model.addAttribute("poblacion", new Poblacion());
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		return "altaPerfil";
	}

	@PostMapping("/altaPerfil")
	public String saveRegistration(@ModelAttribute @Valid Perfil perfil, BindingResult result, ModelMap model) {
		logger.info("--- UseController > saveRegistration (/altaPerfil)");
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "altaPerfil";
		}
		if (!PerfilService.existe(perfil.getNickName())) {
			PerfilService.add(perfil);
			model.addAttribute("success",
					"Estimado " + perfil.getNickName() + " , su registro se ha completado de forma correcta");
			model.addAttribute("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
			return "bienvenida";
		} else {
			model.addAttribute("warning", perfil.getNickName() + " Ya existe en la base de datos.");
			System.out.println("--- entro");
			return "altaPerfil";
		}
	}

	@GetMapping("/bienvenida")
	public ModelAndView  bienvenida(@ModelAttribute Perfil perfil, ModelAndView model) {
		logger.info("--- UseController > Bienvenida (get)");
		model.addObject("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
		System.out.println("-- Datos del perfil 2" + perfil);
		model.setViewName("bienvenida");
		return model;
	}

	@PostMapping("/bienvenida")
	public ModelAndView bienvenida2(@ModelAttribute Perfil perfil, ModelAndView model) {
		logger.info("--- UseController > Bienvenida (post)");
		model.addObject("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));
		System.out.println("---------------------------- Datos del perfil 3" + perfil);
		model.setViewName("bienvenida");
		return model;
	}

	@GetMapping("/like")
	public String like(@ModelAttribute Perfil perfil, @RequestParam("perfil2") String perfil2, ModelAndView model) {
		logger.info("---UseController > like (/like)");
		Perfil perfil3=new Perfil();
		perfil3= PerfilService.findByNickname(perfil2);
		Contacto contacto = new Contacto();
		contacto.setNickname1(perfil);
		contacto.setNickname2(perfil3);
		contactoService.like(contacto);
		return "redirect:/bienvenida";
	}
	
	@GetMapping ("/dislike")
	public String dislike(@ModelAttribute Perfil perfil, @ModelAttribute Perfil perfil2, ModelAndView model) {
		System.out.println("---------------------------- Datos del perfil 5"+perfil);
		Descarte descarte=new Descarte();
		descarte.setNickname1(perfil);
		descarte.setNickname2(perfil2);
		descarteService.dislike(descarte);
		return "redirect:/bienvenida";
	}
}
