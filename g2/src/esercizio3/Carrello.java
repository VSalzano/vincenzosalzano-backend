package esercizio3;

public class Carrello {
	
	public String clienteAssociato;
	public String [] elencoArticoli;
	public float costoTotale;
	
	public Carrello (String clienteAssociato, String [] elencoArticoli, float costoTotale ) {
		this.clienteAssociato = clienteAssociato;
		this.elencoArticoli = elencoArticoli;
		this.costoTotale = costoTotale;
	}

}
