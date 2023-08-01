package com.eserciziomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eserciziomvc.model.Utente;
import com.eserciziomvc.service.UtenteService;

@RestController
@RequestMapping("/api/utente")
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
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAll() {
		List<Utente> listaContatti = us.getAllUsers();
		ResponseEntity<List<Utente>> resp = new ResponseEntity<List<Utente>>(listaContatti, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {
		try {
			Utente u = us.getUtenteByID(id);
			return new ResponseEntity<Utente>(u, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}
