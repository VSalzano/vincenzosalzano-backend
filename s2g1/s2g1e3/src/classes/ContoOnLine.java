package classes;

import exceptions.BancaException;

public class ContoOnLine extends ContoCorrente {

	double maxPrelievo;

	public ContoOnLine(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	public void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	public void preleva(double x) throws BancaException {
		if (x <= maxPrelievo) {
			super.preleva(x);
		} else if(x>maxPrelievo) {
			throw new BancaException("il prelievo non è disponibile");
		}
	}
}

