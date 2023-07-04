package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import classes.LogicaListe;

public class LogicaListe {
	
	Logger log = LoggerFactory.getLogger(LogicaListe.class);

    public static List<Integer> generaListaCasuale(int n) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int numeroCasuale = random.nextInt(101);
            lista.add(numeroCasuale);
        }

        Collections.sort(lista);

        return lista;
    }

    public static List<Integer> creaListaInvertita(List<Integer> lista) {
        List<Integer> listaInvertita = new ArrayList<>(lista);
        Collections.reverse(listaInvertita);
        listaInvertita.addAll(lista);

        return listaInvertita;
    }

    public static void stampaValori(List<Integer> lista, boolean pari) {
        System.out.println("Valori in posizioni " + (pari ? "pari:" : "dispari:"));

        for (int i = (pari ? 0 : 1); i < lista.size(); i += 2) {
            System.out.println(lista.get(i));
        }
    }
}