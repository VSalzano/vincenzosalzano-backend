package com.gestioneprenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gestioneprenotazioni.model.Edificio;
import com.gestioneprenotazioni.model.Postazione;
import com.gestioneprenotazioni.model.Prenotazione;
import com.gestioneprenotazioni.model.Utente;

@Configuration
public class GestioneUfficioConfiguration {
	
	@Bean("utenteBean")
	@Scope("prototype")
	public Utente nuovoUtente () {
		return new Utente ();
	}
	
	@Bean("edificioBean")
	@Scope("prototype")
	public Edificio nuovoEdificio () {
		return new Edificio ();
	}
	
	@Bean("postazioneBean")
	@Scope("prototype")
	public Postazione nuovaPostazione() {
		return new Postazione();
	}
	
	@Bean("prenotazioneBean")
	@Scope("prototype")
	public Prenotazione nuovaPrenotazione() {
		return new Prenotazione();
	}

}
