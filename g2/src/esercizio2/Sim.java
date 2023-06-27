package esercizio2;

public class Sim {
	public String numeroCel;
	public float credito;
	public String [] ultimeChiamate;
	
	public Sim (String numeroCel, float credito, String [] ultimeChiamate) {
		this.numeroCel = numeroCel;
		this.credito = credito;
		this.ultimeChiamate = ultimeChiamate;
	}
	
	public void stampaSim () {
		System.out.println("Numero : " + this.numeroCel);
		System.out.println("Credito residuo : " + this.credito);
		System.out.println("Ultime chiamate : " + this.ultimeChiamate);
	}
	
}
