package com.gestionedispositivi.models;

import com.gestionedispositivi.enums.Stato;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_dispositivo", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@Table(name="dispositivi")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private String modello;
    
	@Column(name="sistema_operativo")
    private String sistemaOperativo;
    
    @Enumerated(EnumType.STRING)
    private Stato stato;
}