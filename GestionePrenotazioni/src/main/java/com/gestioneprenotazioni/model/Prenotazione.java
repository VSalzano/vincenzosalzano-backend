package com.gestioneprenotazioni.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prenotazioni", uniqueConstraints = @UniqueConstraint(columnNames = {"data", "utente_id"}))
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private LocalDate data;
	
	@ManyToOne
	private Postazione postazione;
	
	@ManyToOne
	private Utente utente;

}
