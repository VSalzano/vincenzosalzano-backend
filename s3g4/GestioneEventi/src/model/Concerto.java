package model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import classes.Genere;
import classes.TipoEvento;

@Entity
public class Concerto extends Evento {
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Genere genere;
	
	@Column(name="in_streaming", nullable=false)
	private boolean inStreaming;

	public Concerto() {
		super();
	}

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, Genere genere,
			boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}
	
	
   
}
