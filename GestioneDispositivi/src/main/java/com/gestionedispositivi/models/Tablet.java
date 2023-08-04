package com.gestionedispositivi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("tablet")
@Data
@NoArgsConstructor
public class Tablet extends Dispositivo {
	
	
	@Column(name="dimensioni_schermo", nullable=false)
    private double dimensioneSchermo;
}
