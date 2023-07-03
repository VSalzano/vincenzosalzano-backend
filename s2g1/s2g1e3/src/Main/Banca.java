package Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Main.Banca;

import classes.ContoCorrente;
import classes.ContoOnLine;
import exceptions.BancaException;

public class Banca {
	public static void main(String args[]) {
		Logger log = LoggerFactory.getLogger(Banca.class);
        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        try {
            conto1.preleva(1750.5);

            System.out.println("Saldo conto: " + conto1.restituisciSaldo());
        } catch (BancaException e) {
            System.out.println("Errore durante il prelievo: " + e);
            e.printStackTrace();
        }

        ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

        conto2.stampaSaldo();

        try {
            conto2.preleva(2000);

            conto2.stampaSaldo();
        } catch (BancaException e) {
            log.error("Errore durante il prelievo: " + e);
            e.printStackTrace();
        }
    }
}
