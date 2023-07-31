package com.eserciziomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eserciziomvc.model.Utente;
import com.eserciziomvc.service.UtenteService;

@Controller
public class PageController {
	
	@Autowired UtenteService us;
	
	@GetMapping("/home")
	public String getHomePage() {
		return "temp";
	}
	
	@GetMapping("/listautenti")
	public ModelAndView getLista() {
		
		List <Utente> listaUtenti = us.getAllUsers();
		ModelAndView model = new ModelAndView("listautenti");
		model.addObject("listaUtenti", listaUtenti);
		return model;
	}

}
