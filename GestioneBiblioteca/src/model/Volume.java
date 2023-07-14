package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "volumi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Volume {
	
	@Id
	@SequenceGenerator(name = "vol_seq", sequenceName = "vol_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vol_seq")
	protected int id;
	
	@Column(nullable=false, unique=true, name="codice_isbn")
	protected String codiceISBN;
	
	@Column(nullable=false)
	protected String titolo;
	
	@Column(nullable=false, name="anno_pubblicazione")
	protected int annoPubblicazione;
	
	@Column(nullable=false,name="numero_pagine")
	protected int numeroPagine;
	
    @OneToOne(mappedBy = "elementoPrestato")
    private Prestito prestito;
	
	public Volume () {}

	public Volume(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public int getId() {
		return id;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Volume [id=" + id + ", codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}
	
	
	
	
}
