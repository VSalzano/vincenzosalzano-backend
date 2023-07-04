package s2g2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import classes.LogicaListe;

public class MainE2 {
	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(MainE2.class);
		
        int n = 10;

        List<Integer> listaCasuale = LogicaListe.generaListaCasuale(n);
        log.info("Lista casuale: " + listaCasuale);

        List<Integer> listaInvertita = LogicaListe.creaListaInvertita(listaCasuale);
        log.info("Lista invertita: " + listaInvertita);

        boolean stampaPari = true;
        LogicaListe.stampaValori(listaInvertita, stampaPari);
    }
	}
