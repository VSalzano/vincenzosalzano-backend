package s2g2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainE1 {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(MainE1.class);
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci il numero di elementi: ");
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> paroleSet = new HashSet<String>();
        Set<String> paroleDuplicateSet = new HashSet<String>();

        log.info("Inserisci le parole:");
        for (int i = 0; i < n; i++) {
            String parola = sc.nextLine();

            if (!paroleSet.add(parola)) {
                paroleDuplicateSet.add(parola);
            }
        }

        log.info("Parole duplicate:");
        for (String parola : paroleDuplicateSet) {
            System.out.println(parola);
        }

       log.info("Numero di parole distinte: " + paroleSet.size());

       log.info("Elenco delle parole distinte:");
        for (String parola : paroleSet) {
        	log.info(parola);
        }
    }
}