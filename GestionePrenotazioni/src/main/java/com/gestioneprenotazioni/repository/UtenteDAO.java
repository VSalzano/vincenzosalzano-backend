package com.gestioneprenotazioni.repository;

import org.springframework.data.repository.CrudRepository;

import com.gestioneprenotazioni.model.Utente;

public interface UtenteDAO extends CrudRepository <Utente, Long> {

}
