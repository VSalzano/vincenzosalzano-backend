package com.gestionedispositivi.models;

import com.gestionedispositivi.enums.Stato;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dispositivi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dispositivo {

    @Id
	@SequenceGenerator(name = "my_seq", sequenceName = "my_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
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