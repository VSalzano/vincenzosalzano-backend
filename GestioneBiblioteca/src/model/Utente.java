package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private LocalDate dataNascita;
	
	@Column(nullable=false, unique=true)
	private int numeroTessera;
	
	public Utente() {}

	public Utente(String nome, String cognome, LocalDate dataNascita, int numeroTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroTessera = numeroTessera;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public int getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(int numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", numeroTessera=" + numeroTessera + "]";
	}
	
	
	
	
	
}
