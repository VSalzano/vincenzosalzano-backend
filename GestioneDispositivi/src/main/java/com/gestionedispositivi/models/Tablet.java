package com.gestionedispositivi.models;

import com.gestionedispositivi.enums.Stato;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("tablet")
@Getter
@Setter
@NoArgsConstructor
public class Tablet extends Dispositivo {
	
	
	@Column(name="dimensioni_schermo", nullable=false)
    private double dimensioneSchermo;

	public Tablet(String marca, String modello, String sistemaOperativo, Stato stato, double dimensioneSchermo) {
		super(marca, modello, sistemaOperativo, stato);
		this.dimensioneSchermo = dimensioneSchermo;
	}

	
	
	
}
