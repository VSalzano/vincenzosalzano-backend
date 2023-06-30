import java.util.Scanner;

import classes.ElementoMultimediale;
import classes.Immagine;
import classes.RegistrazioneAudio;
import classes.Video;

public class LettoreMultimediale {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);

		ElementoMultimediale[] archivio = new ElementoMultimediale[5];

		for (int i = 0; i < 5; i++) {
		    System.out.println("Seleziona il tipo di elemento:");
		    System.out.println("1. Immagine");
		    System.out.println("2. Video");
		    System.out.println("3. Registrazione Audio");
		    System.out.print("Scelta: ");
		    int scelta = scanner.nextInt();
		    scanner.nextLine();

		    System.out.print("Titolo: ");
		    String titolo = scanner.nextLine();
		    
		    int luminosita = 0;

		    if (scelta == 1 || scelta == 2) {
		        System.out.print("Luminosità: ");
		        luminosita = scanner.nextInt();
		        scanner.nextLine();
		    }

		    switch (scelta) {
		        case 1:
		            archivio[i] = new Immagine(titolo, luminosita);
		            break;
		        case 2:
		            System.out.print("Volume: ");
		            int volume = scanner.nextInt();
		            System.out.print("Durata: ");
		            int durata = scanner.nextInt();
		            scanner.nextLine();
		            archivio[i] = new Video(titolo, luminosita, volume, durata);
		            break;
		        case 3:
		            System.out.print("Volume: ");
		            int volume1 = scanner.nextInt();
		            System.out.print("Durata: ");
		            int durata1 = scanner.nextInt();
		            scanner.nextLine();
		            archivio[i] = new RegistrazioneAudio(titolo, volume1, durata1);
		            break;
		        default:
		            System.out.println("Scelta non valida.");
		            i--;
		    }
		}


		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Digita un numero qualsiasi per avviare il player:");
	    int elementoScelto = sc.nextInt();
	    
	    do {
	        System.out.println("Scegli un elemento da 1 a " + archivio.length + "(oppure inserisci 0 per uscire): ");
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
