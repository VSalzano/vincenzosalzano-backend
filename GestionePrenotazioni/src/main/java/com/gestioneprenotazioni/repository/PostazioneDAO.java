package com.gestioneprenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gestioneprenotazioni.model.Postazione;
import com.gestioneprenotazioni.model.TipoPostazione;

public interface PostazioneDAO extends CrudRepository <Postazione, Long> {
	
	@Query("SELECT p From Postazione p WHERE p.tipo=:tipo AND p.edificio.citta=:citta")
	List <Postazione> findByTipoAndCitta (TipoPostazione tipo, String citta);

}
