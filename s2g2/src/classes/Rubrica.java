package classes;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {

	private Map<String, String> rubrica;

    public Rubrica() {
        rubrica = new HashMap<>();
    }

    public void inserisciContatto(String nome, String telefono) {
        rubrica.put(nome, telefono);
    }

    public void cancellaContatto(String nome) {
        rubrica.remove(nome);
    }

    public String ricercaPersona(String telefono) {
        for (Map.Entry<String, String> entry : rubrica.entrySet()) {
            if (entry.getValue().equals(telefono)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String ricercaTelefono(String nome) {
        return rubrica.get(nome);
    }

    public void stampaRubrica() {
        System.out.println("Contatti nella rubrica:");
        for (Map.Entry<String, String> entry : rubrica.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + ", Telefono: " + entry.getValue());
        }
    }
}
