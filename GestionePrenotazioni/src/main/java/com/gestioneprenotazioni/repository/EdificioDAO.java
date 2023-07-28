package com.gestioneprenotazioni.repository;

import org.springframework.data.repository.CrudRepository;

import com.gestioneprenotazioni.model.Edificio;

public interface EdificioDAO extends CrudRepository<Edificio, Long> {
	
	
}
