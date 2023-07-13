package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

import classes.TipoEvento;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Evento {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(nullable = false, unique = true)
	protected String titolo;
	
	@Column(name = "data", nullable = false)
	protected LocalDate dataEvento;
	
	@Column(nullable = false)
	protected String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_evento", nullable = false)
	protected TipoEvento tipoEvento;
	
	@Column(name = "num_partecipanti")
	protected int numeroMassimoPartecipanti;
	
	@OneToMany(mappedBy="evento")
	protected List<Partecipazione> partecipazioni;
	
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    protected Location location;

	public Evento() {}

	public Evento(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.partecipazioni = partecipazioni;
		this.location = location;
	}
	
	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, List <Partecipazione> partecipazioni, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public List<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(List<Partecipazione> partecipazioni) {
		this.partecipazioni = partecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti
				+ ", partecipazioni=" + partecipazioni + ", location=" + location + "]";
	}
	
	
	
	
}


