package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rubrica {

	private Map<String, String> rubrica;

    public Rubrica() {
        rubrica = new HashMap<>();
    }

    public void inserisciContatto(String nome, String telefono) throws RubricaException {
		if(rubrica.containsKey(nome)) {
			throw new RubricaException ("Numero già presente in rubrica");
		} else {
			rubrica.put(nome, telefono);
			System.out.println("Contatto aggiunto in rubrica!");
		}
    }

    public void cancellaContatto(String nome) throws RubricaException {
		if(rubrica.containsKey(nome)) {
			rubrica.remove(nome);
			System.out.println("Contatto rimosso dalla rubrica!");
		} else {
			throw new RubricaException ("Chiave NON presente nella rubrica!!!");
		}
    }

    public String ricercaPersona(String telefono) {
		Set<String> key = rubrica.keySet();
		for (String k : key) {
			if(telefono.equals(rubrica.get(k))) {
				return k;
			}
		}
		return null;
    }

    public String ricercaTelefono(String nome) {
        return rubrica.get(nome);
    }

    public void stampaRubrica() {
		System.out.println("Lista contatti:");
	    Set<String> key = rubrica.keySet();
	    for (String k : key) {
			System.out.println("Nome: " + k + " Numero: " + rubrica.get(k));
		}
	}
}
