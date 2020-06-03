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
		if (PerfilService.isPerfil(perfil.getNickName(),perfil.getPassword())) {
			model.addAttribute("perfil",perfil);
		//	System.out.println("\n\n\nperfil: "+model.getAttribute("perfil"));//---------------------------------------------------------------------------------------------------------------------
		return "bienvenida";
		}
		else return "login";
	}
	
	/*@GetMapping("/bienvenida")
	public String bienvenida(ModelMap model, @ModelAttribute Perfil perfil) throws Exception {
		Perfil p = (Perfil)model.getAttribute("perfil");
		model.addAttribute("success",
				"Estimaoodo " + p.getNickName() + " , su registro se ha completado de forma correcta");
		System.out.println("perfil2: "+p);//------------------------------------------------------------------------------------------------------------------------------ 
		return "bienvenida";
	}*/
	
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
					perfil.getNickName() + " ya existe en la base de datos.");
			return "altaPerfil";
		}
	}

}
