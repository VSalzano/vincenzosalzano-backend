package com.eserciziomvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.eserciziomvc.model.Utente;


@Configuration
public class UtenteConfiguration {
	
	@Bean("utenteBean")
	@Scope("prototype")
	public Utente nuovoUtente () {
		return new Utente ();
	}

}
