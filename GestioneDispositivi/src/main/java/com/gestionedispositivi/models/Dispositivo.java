package com.gestionedispositivi.models;

import com.gestionedispositivi.enums.Stato;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_dispositivo", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@Table(name="dispositivi")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
	protected String marca;
    
    @Column(nullable = false)
    protected String modello;
    
	@Column(name="sistema_operativo")
    protected String sistemaOperativo;
    
    @Enumerated(EnumType.STRING)
    protected Stato stato;

	public Dispositivo(String marca, String modello, String sistemaOperativo, Stato stato) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.sistemaOperativo = sistemaOperativo;
		this.stato = stato;
	}
    
    
}