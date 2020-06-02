package com.example.proyecto2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.model.Poblacion;

/**
 * @author Sergio
 * @version 02/06/2020
 *
 */

@Controller
public class UseController {
 
	@GetMapping("/")
	public String logion(ModelMap model)throws Exception {
		model.addAttribute("perfil", new Perfil());
		//model.addAttribute("poblacion",new Poblacion());
		return "login"; 
	}
	
	@GetMapping("/altaPerfil")
	public String registroPerfil(ModelMap model)throws Exception {
		model.addAttribute("perfil", new Perfil());
		model.addAttribute("poblacion", new Poblacion());
		return "altaPerfil"; 
	}
	
}
