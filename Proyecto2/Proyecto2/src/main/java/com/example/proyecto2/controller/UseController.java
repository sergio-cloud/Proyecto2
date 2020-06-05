package com.example.proyecto2.controller;

//import java.util.ArrayList;
//import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import com.example.proyecto2.service.*;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Controller
public class UseController {

	@Autowired
	PoblacionService PoblacionService;
	@Autowired
	PerfilService PerfilService;
	// @Autowired
	// GeneradorPerfiles Perfilutil;

	@GetMapping("/")
	public String login(ModelMap model) throws Exception {
		model.addAttribute("perfil", new Perfil());
		// model.addAttribute("poblacion",new Poblacion());
		return "login";
	}

	@PostMapping("/")
	public String saveLogin(@Valid Perfil perfil, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "login";
		}

		if (PerfilService.isPerfil(perfil.getNickName(), perfil.getPassword())) {
			model.addAttribute("perfil", perfil);
			model.addAttribute("success", "Estimado " + perfil.getNickName() + " , se ha loggeado de forma correcta");
			System.out.println("--- entro");
			model.addAttribute("listaDesconocido", PerfilService.listaPerfilDesconocido(perfil));

			return "bienvenida";
		} else if (!PerfilService.isPerfil(perfil.getNickName(), perfil.getPassword())) {

			model.addAttribute("warning", perfil.getNickName() + " No existe en la base de datos.");
			System.out.println("--- entro");

		}
		return "login";
	}

	@GetMapping("/altaPerfil")
	public String registroPerfil(ModelMap model) throws Exception {
		model.addAttribute("perfil", new Perfil());
		model.addAttribute("poblacion", new Poblacion());
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		return "altaPerfil";
	}

	@PostMapping("/altaPerfil")
	public String saveRegistration(@ModelAttribute @Valid Perfil perfil, BindingResult result, ModelMap model) {
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "altaPerfil";
		}
		if (!PerfilService.existe(perfil.getNickName())) {
			PerfilService.add(perfil);
			model.addAttribute("success",
					"Estimado " + perfil.getNickName() + " , su registro se ha completado de forma correcta");
			return "bienvenida";
		} else {
			model.addAttribute("warning",
					perfil.getNickName() + " Ya existe en la base de datos.");
			System.out.println("--- entro");
			return "altaPerfil";
		}
	}

	@GetMapping("/like")
	public ModelAndView like(ModelMap model,@RequestParam("nickname2") String Nickname2) {
		System.out.println(Nickname2+"\n\n\n\n\n\n");
		//LLAMAR A UN SERVICIO QUE  AÑADA a LA TABRA LIKE el LIKE
		
		//model.addAttribute("nickname2", Nickname2);
		return new ModelAndView("redirect:/");
	}
}
