package com.gestionedispositivi.models;

import com.gestionedispositivi.enums.Stato;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("laptop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Laptop extends Dispositivo {
	

	@Column(name="memoria_ram")
    private int memoriaRAM;

	public Laptop(String marca, String modello, String sistemaOperativo, Stato stato, int memoriaRAM) {
		super(marca, modello, sistemaOperativo, stato);
		this.memoriaRAM = memoriaRAM;
	}
	

}
