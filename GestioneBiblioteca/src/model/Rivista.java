package model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import classes.Periodicita;

@Entity
@Table(name="riviste")
@NamedQuery(name = "ricercaRPerAnno", query = "SELECT r FROM Rivista r WHERE r.annoPubblicazione=:anno")
@NamedQuery(name = "ricercaRPerIsbn", query = "SELECT r FROM Rivista r WHERE r.codiceISBN=:codiceISBN")
@NamedQuery(name = "ricercaRPerTitolo", query = "SELECT r FROM Rivista r WHERE LOWER(r.titolo) LIKE LOWER(:titolo)")
public class Rivista extends Volume {
		
		@Enumerated(EnumType.STRING)
		@Column(nullable=false)
		private Periodicita periodicita;
		
	    @OneToOne(mappedBy = "elementoPrestato")
	    private Prestito prestito;
		
		
		public Rivista() {}
		
		public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,
				Periodicita periodicita) {
			super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
			this.periodicita = periodicita;
		}

		public Periodicita getPeriodicita() {
			return periodicita;
		}

		public void setPeriodicita(Periodicita periodicita) {
			this.periodicita = periodicita;
		}

		@Override
		public String toString() {
			return "Rivista [periodicita=" + periodicita + ", id=" + id + ", codiceISBN=" + codiceISBN + ", titolo="
					+ titolo + ", annoPubblicazione=" + annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
		}
		
		
		
		
		
		
}
