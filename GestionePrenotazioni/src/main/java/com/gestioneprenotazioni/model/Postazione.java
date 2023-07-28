package com.gestioneprenotazioni.model;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="postazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Postazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@Column(name="max_occupanti", nullable=false)
	private int maxOccupanti;
	
	@ManyToOne
	private Edificio edificio;

}
