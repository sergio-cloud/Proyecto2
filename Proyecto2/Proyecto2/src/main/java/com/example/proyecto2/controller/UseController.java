package com.example.proyecto2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
 
	@GetMapping("/")
	public String login(ModelMap model)throws Exception {
		model.addAttribute("perfil", new Perfil());
		//model.addAttribute("poblacion",new Poblacion());
		return "login"; 
	}

	@GetMapping("/altaPerfil")
	public String registroPerfil(ModelMap model)throws Exception {
		model.addAttribute("perfil", new Perfil());
		model.addAttribute("poblacion", new Poblacion());
		model.addAttribute("ListaPoblacion", PoblacionService.findAll());
		return "altaPerfil"; 
	}
	//Nino ver mañana
	@PostMapping("/save1")
	public String saveLogin(
							@Valid Perfil perfil,
							BindingResult result, 
							ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "login";
		}

		model.addAttribute("success", "Estimado " + perfil.getNickName()
				+ " , su registro se ha completado de forma correcta");
		return  "bienvenida";
	}
	
	@PostMapping("/save2")
	public String saveRegistration(
							@Valid Perfil perfil,
							BindingResult result, 
							ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "altaPerfil";
		}

		model.addAttribute("success", "Estimado " + perfil.getNickName()
				+ " , su registro se ha completado de forma correcta");
		return  "bienvenida";
	}
	
}
