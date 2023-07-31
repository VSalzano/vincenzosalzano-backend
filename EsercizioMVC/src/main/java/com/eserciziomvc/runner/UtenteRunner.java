package com.eserciziomvc.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.eserciziomvc.service.UtenteService;

@Component
public class UtenteRunner implements CommandLineRunner {
	
	@Autowired UtenteService us;

	@Override
	public void run(String... args) throws Exception {
		
		us.salvaUtente("Mario", "Rossi", "m.rossi@gmail.com");
		us.salvaUtente("Vincenzo", "Salzano", "v.salzano@gmail.com");
		us.salvaUtente("Giovanni", "Salzano", "g.salzano@gmail.com");
		us.salvaUtente("Ersilia", "Fabrazzo", "e.fabrazzo@gmail.com");
		us.salvaUtente("Caterina", "Salzano", "c.salzano@gmail.com");
		us.salvaUtente("Luca", "Neri", "l.neri@gmail.com");
		us.salvaUtente("Antonio", "Bianchi", "a.bianchi@gmail.com");
		us.salvaUtente("Armando", "Verdi", "a.verdi@gmail.com");
		us.salvaUtente("Stefano", "Rossini", "s.rossini@gmail.com");
		
		
	}

}
