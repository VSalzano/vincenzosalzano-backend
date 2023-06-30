import java.util.Scanner;

import classes.ElementoMultimediale;
import classes.Immagine;
import classes.RegistrazioneAudio;
import classes.Video;

public class LettoreMultimediale {

	public static void main(String[] args) {
		
		System.out.println("La luminosità e il volume di default di tutti i file sono impostati a 2. È possibile aumentare e diminuire luminosità e volume con i rispettivi metodi");
		
		RegistrazioneAudio c1 = new RegistrazioneAudio("prima canzone", 4);
		Immagine i1 = new Immagine ("foto compleanno");
		Video v1 = new Video ("video vacanze", 3);
		Immagine i2 = new Immagine ("foto laurea");
		Video v2 = new Video ("video concerto", 4);
		
		ElementoMultimediale[] archivio = new ElementoMultimediale[5];
		archivio [0] = c1;
		archivio [1] = i1;
		archivio [2] = v1;
		archivio [3] = i2;
		archivio [4] = v2;
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Digita un numero qualsiasi per avviare il player:");
	    int elementoScelto = sc.nextInt();
	    
	    do {
	        System.out.println("Scegli un elemento da 1 a " + archivio.length + " (oppure inserisci 0 per uscire): ");
	        elementoScelto = sc.nextInt();
	        
	        if (elementoScelto >= 1 && elementoScelto <= 5) {
	            if (archivio[elementoScelto - 1].riproducibile) {
	                archivio[elementoScelto - 1].play();
	            } else {
	                archivio[elementoScelto - 1].show();
	            }
	        }
	    } while (elementoScelto != 0);
	}
	


}
