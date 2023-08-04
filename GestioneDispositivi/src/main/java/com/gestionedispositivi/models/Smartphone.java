package com.gestionedispositivi.models;

import com.gestionedispositivi.enums.Stato;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("smartphone")
@Getter
@Setter
@NoArgsConstructor
public class Smartphone extends Dispositivo {
	
	@Column(name="memoria_interna_GB",nullable=false)
    private int memoriaInternaGB;

	public Smartphone(String marca, String modello, String sistemaOperativo, Stato stato, int memoriaInternaGB) {
		super(marca, modello, sistemaOperativo, stato);
		this.memoriaInternaGB = memoriaInternaGB;
	}
	
	
}
