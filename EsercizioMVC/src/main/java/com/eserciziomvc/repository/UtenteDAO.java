package com.eserciziomvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.eserciziomvc.model.Utente;


public interface UtenteDAO extends CrudRepository <Utente, Long> {

}
