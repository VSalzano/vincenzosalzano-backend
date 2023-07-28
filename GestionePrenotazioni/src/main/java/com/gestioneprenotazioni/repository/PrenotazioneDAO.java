package com.gestioneprenotazioni.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gestioneprenotazioni.model.Postazione;
import com.gestioneprenotazioni.model.Prenotazione;

public interface PrenotazioneDAO extends CrudRepository <Prenotazione, Long> {
	
	@Query("SELECT COUNT(p) FROM Prenotazione p WHERE p.data = :data AND p.postazione = :postazione ")
	public int contaPrenotazioni (LocalDate data, Postazione postazione);
}
