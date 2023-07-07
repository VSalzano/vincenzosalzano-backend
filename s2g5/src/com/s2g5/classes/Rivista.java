package com.s2g5.classes;

import java.time.Year;

public class Rivista extends Volume {
	
	@Override
	public String toString() {
		return "Rivista [titolo=" + titolo + "]";
	}

	private Periodicita periodicita;

	public Rivista(String codiceISBN, String titolo, Year annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	

}
