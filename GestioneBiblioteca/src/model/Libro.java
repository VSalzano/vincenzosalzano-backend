package model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="libri")
@NamedQuery(name = "ricercaLPerAnno", query = "SELECT l FROM Libro l WHERE l.annoPubblicazione=:anno")
@NamedQuery(name = "ricercaLPerIsbn", query = "SELECT l FROM Libro l WHERE l.codiceISBN=:codiceISBN")
@NamedQuery(name = "ricercaLPerAutore", query = "SELECT l FROM Libro l WHERE LOWER(l.autore) = LOWER(:autore)")
@NamedQuery(name = "ricercaLPerTitolo", query = "SELECT l FROM Libro l WHERE LOWER(l.titolo) LIKE LOWER(:titolo)")
public class Libro extends Volume {
	
	@Column(nullable=false)
	private String autore;
	
	@Column(nullable=false)
	private String genere;
	
    @OneToOne(mappedBy = "elementoPrestato")
    private Prestito prestito;
	
	public Libro() {}
	
	public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", id=" + id + ", codiceISBN=" + codiceISBN
				+ ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione + ", numeroPagine=" + numeroPagine
				+ "]";
	}

	
		
	
}
