package com.gestioneprenotazioni.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioneprenotazioni.model.Edificio;
import com.gestioneprenotazioni.model.Postazione;
import com.gestioneprenotazioni.model.Prenotazione;
import com.gestioneprenotazioni.model.TipoPostazione;
import com.gestioneprenotazioni.model.Utente;
import com.gestioneprenotazioni.repository.EdificioDAO;
import com.gestioneprenotazioni.repository.PostazioneDAO;
import com.gestioneprenotazioni.repository.PrenotazioneDAO;
import com.gestioneprenotazioni.repository.UtenteDAO;

@Service
public class UfficioService {
	
	@Autowired @Qualifier ("utenteBean") ObjectProvider <Utente> utenteProvider;
	@Autowired @Qualifier ("edificioBean") ObjectProvider <Edificio> edificioProvider;
	@Autowired @Qualifier ("postazioneBean") ObjectProvider <Postazione> postazioneProvider;
	@Autowired @Qualifier ("prenotazioneBean") ObjectProvider <Prenotazione> prenotazioneProvider;
	
	@Autowired UtenteDAO utenteCrud;
	@Autowired PostazioneDAO postazioneCrud;
	@Autowired EdificioDAO edificioCrud;
	@Autowired PrenotazioneDAO prenotazioneCrud;

	
	public Utente nuovoUtente(String username, String nomeCompleto, String email) {
		Utente u = utenteProvider.getObject();
		u.setUsername(username);
		u.setNomeCompleto(nomeCompleto);
		u.setEmail(email);
		return u;
	}
	
	public Edificio nuovoEdificio (String nome, String indirizzo, String citta) {
		Edificio e = edificioProvider.getObject();
		e.setNome(nome);
		e.setIndirizzo(indirizzo);
		e.setCitta(citta);
		return e;
	}
	
	public Postazione nuovaPostazione (String descrizione, TipoPostazione tipo, int maxOccupanti, Edificio edificio) {
		Postazione p = postazioneProvider.getObject();
		p.setDescrizione(descrizione);
		p.setTipo(tipo);
		p.setMaxOccupanti(maxOccupanti);
		p.setEdificio(edificio);
		return p;
	}
	
	public Prenotazione nuovaPrenotazione (LocalDate data, Postazione postazione, Utente utente) {
		Prenotazione pr = prenotazioneProvider.getObject();
		pr.setData(data);
		pr.setPostazione(postazione);
		pr.setUtente(utente);
		return pr;
	}
	
	public void salvaPrenotazione (Prenotazione pr) {
		
		int contoPrenotazioni = prenotazioneCrud.contaPrenotazioni(pr.getData(), pr.getPostazione());
		
		
		
		try {
			if(contoPrenotazioni < pr.getPostazione().getMaxOccupanti()) {
				prenotazioneCrud.save(pr);
				System.out.println("Utente " + pr.getUtente().getUsername() + " prenotato nel giorno " + pr.getData());
			} else {
				System.out.println("Postazione già piena nella data selezionata");
			}
			} catch(Exception e) {
				System.out.println("Esiste già una prenotazione per la data impostata.");
			}
	}
	
	public void salvaPostazione (Postazione p) {
		postazioneCrud.save(p);
		System.out.println("Nuova postazione aggiunta nell'edificio " + p.getEdificio().getNome());
	}
	
	public void salvaEdificio(Edificio e) {
		edificioCrud.save(e);
		System.out.println(e.getNome() + " salvato nel database");
	}
	
	public void salvaUtente(Utente u) {
		utenteCrud.save(u);
		System.out.println(u.getNomeCompleto() + " salvato nel database");
	}
	
	public Edificio getEdificioById(long id) {
		Optional<Edificio> e = edificioCrud.findById(id);				
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public Utente getUtenteById(long id) {
		Optional<Utente> e = utenteCrud.findById(id);				
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public Postazione getPostazioneById(long id) {
		Optional<Postazione> e = postazioneCrud.findById(id);				
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public Prenotazione getPrenotazioneById(long id) {
		Optional<Prenotazione> e = prenotazioneCrud.findById(id);				
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public List <Postazione> controllaPostazioni (TipoPostazione tipo, String citta) {
		List <Postazione> l = postazioneCrud.findByTipoAndCitta(tipo, citta);
		
		l.forEach(p -> System.out.println(p));
		
		return l;		
	}
}
