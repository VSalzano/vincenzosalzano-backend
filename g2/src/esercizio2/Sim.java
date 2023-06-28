package esercizio2;

public class Sim {
	public String numeroCel;
	public double credito;
	Chiamata[] ultimeChiamate;
	
	public Sim (String numeroCel) {
		this.numeroCel = numeroCel;
		this.credito = 0;
		this.ultimeChiamate = new Chiamata[5];
	}
	
	public void stampaSim () {
		System.out.println("Numero : " + this.numeroCel);
		System.out.println("Credito residuo : " + this.credito);
		System.out.println("Ultime chiamate : ");
		for (int i = 0; i < ultimeChiamate.length; i++) {
			if(ultimeChiamate[i] != null) {
				System.out.println(ultimeChiamate[i].numeroChiamato + "durata: " + ultimeChiamate[i].durata);
			}
		}
	}
	
}
