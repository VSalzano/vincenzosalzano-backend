package com.s2g5.classes;

import java.time.Year;

public class Libro extends Volume {
	


	private String autore;
	private String genere;
	
	public Libro(String codiceISBN, String titolo, String autore, String genere, Year annoPubblicazione, int numeroPagine) {
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
	    return "Libro{" +
	            "codiceISBN='" + getCodiceISBN() + '\'' +
	            ", titolo='" + getTitolo() + '\'' +
	            ", autore='" + getAutore() + '\'' +
	            ", genere='" + getGenere() + '\'' +
	            ", annoPubblicazione=" + getAnnoPubblicazione() +
	            ", numeroPagine=" + getNumeroPagine() +
	            '}';
	}
	
}
