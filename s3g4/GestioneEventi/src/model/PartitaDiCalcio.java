package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import classes.TipoEvento;

@Entity
public class PartitaDiCalcio extends Evento {

	
	@Column(name="squadra_casa", nullable=false)
	private String squadraDiCasa;
	
	@Column(name="squadra_ospite", nullable=false)
	private String squadraOspite;
	
	@Column(name="squadra_vincente")
	private String squadraVincente;
	
	@Column(name="gol_casa", nullable=false)
	private int golCasa;
	
	@Column(name="gol_ospite", nullable=false)
	private int golOspite;

	public PartitaDiCalcio() {
		super();
	}

	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, String squadraDiCasa, String squadraOspite,
			String squadraVincente, int golCasa, int golOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
		
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golCasa = golCasa;
		this.golOspite = golOspite;
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getGolCasa() {
		return golCasa;
	}

	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}

	public int getGolOspite() {
		return golOspite;
	}

	public void setGolOspite(int golOspite) {
		this.golOspite = golOspite;
	}

	@Override
	public String toString() {
		return "PartitaDiCalcio [squadraDiCasa=" + squadraDiCasa + ", squadraOspite=" + squadraOspite
				+ ", squadraVincente=" + squadraVincente + ", golCasa=" + golCasa + ", golOspite=" + golOspite + "]";
	}
	
	
}
