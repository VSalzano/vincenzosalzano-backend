package com.gestionedispositivi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("laptop")
@NoArgsConstructor
@Data
public class Laptop extends Dispositivo {

	
	@Column(name="memoria_ram", nullable=false)
    private int memoriaRAM;
}
