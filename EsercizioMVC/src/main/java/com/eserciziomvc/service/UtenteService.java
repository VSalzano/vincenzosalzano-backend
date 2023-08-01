package com.eserciziomvc.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.eserciziomvc.model.Utente;
import com.eserciziomvc.repository.UtenteDAO;

@Service
public class UtenteService {
	
	@Autowired @Qualifier ("utenteBean") ObjectProvider <Utente> utenteProvider;
	@Autowired UtenteDAO utenteCrud;

    public void salvaUtente(String name, String surname, String email) {
        Utente u=utenteProvider.getObject();
        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        utenteCrud.save(u);
    }
    
    public Utente creaUtente (Utente u) {
    	return utenteCrud.save(u);
    }
    
    public List<Utente> getAllUsers() {
        return (List<Utente>) utenteCrud.findAll();
    }
    
	public Utente getUtenteByID(Long id) {
		return utenteCrud.findById(id).get();
	}
}
