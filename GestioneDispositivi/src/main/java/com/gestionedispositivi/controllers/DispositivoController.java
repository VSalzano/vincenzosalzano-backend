package com.gestionedispositivi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionedispositivi.services.DispositivoService;
import com.gestionedispositivi.models.Dispositivo;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {
	
	@Autowired DispositivoService ds;
	
	@GetMapping
	public ResponseEntity<List<Dispositivo>> getAll() {
		List <Dispositivo> listaDispositivi = 
		ds.getAllDispositivi();
		ResponseEntity<List<Dispositivo>> resp = 
		new ResponseEntity<List<Dispositivo>>(listaDispositivi, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
		Dispositivo d = ds.getById(id);
		return new ResponseEntity<Dispositivo>(d, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> creaDispositivo (@RequestBody Dispositivo disp) {
		try {
		Dispositivo nuovoDisp = ds.salvaDispositivo(disp);
		return new ResponseEntity<Dispositivo>(nuovoDisp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> aggiornaDispositivo (@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
		try {
		Dispositivo d = ds.aggiornaDispositivo(id, dispositivo);
		return new ResponseEntity<Dispositivo>(d, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> rimuoviDispositivo (@PathVariable Long id) {
		try {
		String msg = ds.rimuoviDispositivo(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
