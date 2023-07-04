package s2g2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import classes.Rubrica;
import classes.RubricaException;

public class MainE3 {
		
		public static void main(String[] args) throws RubricaException {
			Logger log = LoggerFactory.getLogger(MainE3.class);
	        Rubrica rubrica = new Rubrica();

	        rubrica.inserisciContatto("Ermenegilda", "1112223344");
	        rubrica.inserisciContatto("Astolfo", "3332229988");
	        rubrica.inserisciContatto("Luigi", "2223334455");
	        rubrica.inserisciContatto("Bernarndo", "1119998877");
	        rubrica.inserisciContatto("Alfonso", "3334445566");

	        rubrica.stampaRubrica();

	        log.info("Ricerca per nome: " + rubrica.ricercaTelefono("Luigi"));
	        log.info("Ricerca per numero: " + rubrica.ricercaPersona("3334445566"));

	        rubrica.cancellaContatto("Alfonso");

	        rubrica.stampaRubrica();
	    }

	}

