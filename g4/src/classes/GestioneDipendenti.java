package classes;

public class GestioneDipendenti {

	public static void main(String[] args) {
		Dipendente d1 = new Dipendente (1, Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente (2, Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente (3, 1200, 12, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente (4, 2000, 0, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		
		d1.promuovi();
		d3.promuovi();
		
		System.out.println();
		System.out.println("***********************");
		
		d1.stampaDatiDipendente();
		System.out.println("***********************");
		d2.stampaDatiDipendente();
		System.out.println("***********************");
		d3.stampaDatiDipendente();
		System.out.println("***********************");
		d4.stampaDatiDipendente();
		
		System.out.println();
		System.out.println("***********************");
		
		double paga1 = Dipendente.calcolaPaga(d1, 5);
		double paga2 = Dipendente.calcolaPaga(d2, 5);
		double paga3 = Dipendente.calcolaPaga(d3, 5);
		double paga4 = Dipendente.calcolaPaga(d4, 5);
		double totPaga = paga1 + paga2 + paga3 + paga4;
		
		System.out.println("Totale da pagare ai dipendenti: " + totPaga);
		

	}

}
