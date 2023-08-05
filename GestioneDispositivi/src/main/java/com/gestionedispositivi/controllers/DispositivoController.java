package com.gestionedispositivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionedispositivi.services.DispositivoService;
import com.gestionedispositivi.models.Dispositivo;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {
	
	@Autowired DispositivoService ds;
	

}
