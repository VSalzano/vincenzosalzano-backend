package com.gestioneprenotazioni.runner;

import java.time.LocalDate;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gestioneprenotazioni.model.Postazione;
import com.gestioneprenotazioni.model.TipoPostazione;
import com.gestioneprenotazioni.repository.EdificioDAO;
import com.gestioneprenotazioni.service.UfficioService;

@Component
public class UfficioRunner implements CommandLineRunner {
	
	@Autowired private UfficioService us;

	@Override
	public void run(String... args) throws Exception {
		
		//creo e istanzio utenti
		
		us.salvaUtente(us.nuovoUtente("mrossi", "Mario Rossi", "m.rossi@gmail.com"));
		us.salvaUtente(us.nuovoUtente("vsalzano", "Vincenzo Salzano", "v.salzano@gmail.com"));
		us.salvaUtente(us.nuovoUtente("lneri", "Luca Neri", "l.neri@gmail.com"));
		us.salvaUtente(us.nuovoUtente("abianchi", "Anna Bianchi", "a.bianchi@gmail.com"));
		us.salvaUtente(us.nuovoUtente("crossini", "Claudia Rossini", "c.rossinii@gmail.com"));
		
		//creo e istanzio edifici
		
		us.salvaEdificio(us.nuovoEdificio("Studio 1", "Via Caracciolo 1", "Napoli"));
		us.salvaEdificio(us.nuovoEdificio("Studio 2", "Via Roma 3", "Napoli"));
		us.salvaEdificio(us.nuovoEdificio("Studio 3", "C.so Enrico De Nicola 28", "Afragola"));
		us.salvaEdificio(us.nuovoEdificio("Studio 4", "Piazza Municipio 4", "Caserta"));
		us.salvaEdificio(us.nuovoEdificio("Studio 5", "C.so Vittorio Emanuele 39", "Salerno"));
		
		//creo e istanzio postazioni
		
		us.salvaPostazione(us.nuovaPostazione("Ufficio numero 1", TipoPostazione.PRIVATO, 1 , us.getEdificioById(1)));
		us.salvaPostazione(us.nuovaPostazione("Sala convegni 1", TipoPostazione.SALA_RIUNIONI, 20 , us.getEdificioById(1)));
		us.salvaPostazione(us.nuovaPostazione("Ufficio numero 2", TipoPostazione.PRIVATO, 2 , us.getEdificioById(1)));
		
		us.salvaPostazione(us.nuovaPostazione("Open Space 1", TipoPostazione.OPEN_SPACE, 10 , us.getEdificioById(2)));
		us.salvaPostazione(us.nuovaPostazione("Ufficio 3", TipoPostazione.PRIVATO, 5 , us.getEdificioById(2)));
		us.salvaPostazione(us.nuovaPostazione("Ufficio 4", TipoPostazione.PRIVATO, 1 , us.getEdificioById(2)));
		
		us.salvaPostazione(us.nuovaPostazione("Sala convegni 1", TipoPostazione.SALA_RIUNIONI, 50 , us.getEdificioById(3)));
		us.salvaPostazione(us.nuovaPostazione("Open Space 2", TipoPostazione.OPEN_SPACE, 10 , us.getEdificioById(3)));
		us.salvaPostazione(us.nuovaPostazione("Ufficio 5", TipoPostazione.PRIVATO, 1 , us.getEdificioById(3)));
		
		us.salvaPostazione(us.nuovaPostazione("Ufficio 6", TipoPostazione.PRIVATO, 3 , us.getEdificioById(4)));
		us.salvaPostazione(us.nuovaPostazione("Ufficio 7", TipoPostazione.PRIVATO, 3 , us.getEdificioById(4)));
		us.salvaPostazione(us.nuovaPostazione("Ufficio 8", TipoPostazione.PRIVATO, 3 , us.getEdificioById(4)));
		
		us.salvaPostazione(us.nuovaPostazione("Open Space 3", TipoPostazione.OPEN_SPACE, 10 , us.getEdificioById(5)));
		us.salvaPostazione(us.nuovaPostazione("Open Space 4", TipoPostazione.OPEN_SPACE, 12 , us.getEdificioById(5)));
		us.salvaPostazione(us.nuovaPostazione("Open Space 5", TipoPostazione.OPEN_SPACE, 15 , us.getEdificioById(5)));
		
		//creo prenotazioni		
		us.salvaPrenotazione(us.nuovaPrenotazione(LocalDate.now(), us.getPostazioneById(1), us.getUtenteById(1)));
		us.salvaPrenotazione(us.nuovaPrenotazione(LocalDate.of(2023, 8, 15), us.getPostazioneById(10), us.getUtenteById(3)));
		
//		//prenotazione sbagliata - Lo stesso utente fa due prenotazioni con la stessa data
		us.salvaPrenotazione(us.nuovaPrenotazione(LocalDate.of(2023, 8, 15), us.getPostazioneById(10), us.getUtenteById(3)));
		
//		//prenotazione sbagliata - Un utente prova a prenotarsi per una postazione già piena nella data inserita
		us.salvaPrenotazione(us.nuovaPrenotazione(LocalDate.now(), us.getPostazioneById(1), us.getUtenteById(2)));
		
//		//ricerca delle postazioni
		us.controllaPostazioni(TipoPostazione.PRIVATO, "Napoli");
		
	}

}
