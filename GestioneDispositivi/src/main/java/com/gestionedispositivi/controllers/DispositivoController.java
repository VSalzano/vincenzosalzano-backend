package com.gestionedispositivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionedispositivi.models.Dispositivo;
import com.gestionedispositivi.models.Laptop;
import com.gestionedispositivi.models.Smartphone;
import com.gestionedispositivi.models.Tablet;
import com.gestionedispositivi.services.DispositivoService;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {
	
	@Autowired DispositivoService ds;
	
	
	@PostMapping("/laptop")
	public ResponseEntity<?> creaLaptop(@RequestBody Laptop laptop) {
		Dispositivo l = ds.creaLaptop(laptop);
		return new ResponseEntity<Dispositivo>(l, HttpStatus.CREATED);
	}
	
	@PostMapping("/tablet")
	public ResponseEntity<?> creaTablet(@RequestBody Tablet tablet) {
		Dispositivo t = ds.creaTablet(tablet);
		return new ResponseEntity<Dispositivo>(t, HttpStatus.CREATED);
	}
	
	@PostMapping("/smartphone")
	public ResponseEntity<?> creaSmartphone(@RequestBody Smartphone smartphone) {
		Dispositivo s = ds.creaSmartphone(smartphone);
		return new ResponseEntity<Dispositivo>(s, HttpStatus.CREATED);
	}

}
