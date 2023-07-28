package com.gestioneprenotazioni.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="utenti")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
	private String username;
	
	@Column(name="nome_completo", nullable=false)
	private String nomeCompleto;
	
	@Column(unique=true)
	private String email;
	

}
