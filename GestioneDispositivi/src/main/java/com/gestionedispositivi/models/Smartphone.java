package com.gestionedispositivi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("smartphone")
@Data
@NoArgsConstructor
public class Smartphone extends Dispositivo {
	
	@Column(name="memoria_interna_GB",nullable=false)
    private int memoriaInternaGB;
}
