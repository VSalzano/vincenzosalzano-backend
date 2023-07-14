package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="prestiti")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@ManyToOne
	private Utente utente;
	
	@OneToOne
	private Volume elementoPrestato;
	
	@Column(nullable=false, name="inizio_prestito")
	private LocalDate dataInizioPrestito;
	
	@Column(nullable=false, name="restituzione_prevista")
	private LocalDate restituzionePrevista;
	
	@Column(name="restituzione_effettiva")
	private LocalDate restituzioneEffettiva;
	
	public Prestito () {}

	public Prestito(Utente utente, Volume elementoPrestato, LocalDate dataInizioPrestito) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.restituzionePrevista = dataInizioPrestito.plusDays(30);
	}

	public int getId() {
		return id;
	}


	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Volume getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(Volume elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getRestituzionePrevista() {
		return restituzionePrevista;
	}

	public void setRestituzionePrevista(LocalDate restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista;
	}

	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", elementoPrestato=" + elementoPrestato
				+ ", dataInizioPrestito=" + dataInizioPrestito + ", restituzionePrevista=" + restituzionePrevista
				+ ", restituzioneEffettiva=" + restituzioneEffettiva + "]";
	}
	
	
	
}
