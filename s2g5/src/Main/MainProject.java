package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.s2g5.classes.Libro;
import com.s2g5.classes.Periodicita;
import com.s2g5.classes.Rivista;
import com.s2g5.classes.Volume;

public class MainProject {
	
	private static File file = new File("doc/test.txt");
    private static Logger log = LoggerFactory.getLogger(MainProject.class);
	private static List<Volume> archivio = new ArrayList<Volume>();

	public static void main(String[] args) throws IOException {
		

		
		Libro l1 = new Libro("978-8808180157", "1984", "George Orwell", "Romanzo distopico", Year.of(1949), 328);
		Libro l2 = new Libro("978-8804642866", "Il signore degli anelli", "J.R.R. Tolkien", "Fantasy", Year.of(1955), 1216);
		Libro l3 = new Libro("978-8804668231", "Il codice da Vinci", "Dan Brown", "Thriller", Year.of(2003), 592);
		Libro l4 = new Libro("978-8804682565", "Harry Potter e la pietra filosofale", "J.K. Rowling", "Fantasy", Year.of(1997), 336);
		Libro l5 = new Libro("978-8804678889", "Cime tempestose", "Emily Brontë", "Romanzo gotico", Year.of(1846), 448);
		
		Rivista r1 = new Rivista("978-1234567890", "Fashion Weekly", Year.of(1980), 60, Periodicita.SETTIMANALE);
		Rivista r2 = new Rivista("978-0987654321", "National Geographic", Year.of(1830), 100, Periodicita.MENSILE);
		Rivista r3 = new Rivista("978-2468135790", "Tech Trends", Year.of(1999), 48, Periodicita.MENSILE);
		Rivista r4 = new Rivista("978-1357902468", "Travel Explorer", Year.of(2010), 72, Periodicita.MENSILE);
		Rivista r5 = new Rivista("978-5678901234", "Science Quarterly", Year.of(2010), 80, Periodicita.SEMESTRALE);
		
		archivio.add(l1);
		archivio.add(l2);
		archivio.add(l3);
		archivio.add(l4);
		archivio.add(l5);
		archivio.add(r1);
		archivio.add(r2);
		archivio.add(r3);
		archivio.add(r4);
		archivio.add(r5);
		
		eliminaVolume("123");
		eliminaVolume("978-1234567890");
		
		cercaPerCodice("978-1234567890");
		cercaPerCodice("978-2468135790");
		
		cercaPerAnno(Year.of(2010));
		
		cercaPerAutore("J.R.R. Tolkien");
		cercaPerAutore("Pippo Baudo");
		
		salvaSuFile();
		caricaDaFile();
		
		System.out.println(caricaDaFile());
	

		
		
	}
	
	public static void eliminaVolume(String codice) {		
	    Optional<Volume> volumeDaEliminare = archivio.stream()
	            .filter(volume -> volume.getCodiceISBN().equals(codice))
	            .findFirst();

	    volumeDaEliminare.ifPresent(volume -> {
	        String titoloEliminato = volume.getTitolo();
	        archivio.remove(volume);
	        log.info("Il volume " + titoloEliminato + " è stato eliminato con successo.");

	    });

	    if (volumeDaEliminare.isPresent() == false) {
	        log.error("Non esiste alcun volume con il codice " + codice);
	    }
	}
	
	public static Optional<Volume> cercaPerCodice(String codice) {
	    Optional<Volume> volumeTrovato = archivio.stream()
	            .filter(volume -> volume.getCodiceISBN().equals(codice))
	            .findFirst();

	    volumeTrovato.ifPresent(volume -> log.info("Al codice impostato corrisponde il volume " + volume.getTitolo()));

	    if (volumeTrovato.isPresent() == false) {
	        System.out.println("Nessun volume trovato con il codice ISBN " + codice);
	    }

	    return volumeTrovato;
	}
	
	public static void cercaPerAnno(Year annoPubblicazione) {
	    List<Volume> ricerca = archivio.stream()
	            .filter(volume -> volume.getAnnoPubblicazione().equals(annoPubblicazione))
	            .collect(Collectors.toList());

	    if (ricerca.size() > 0) {
	        System.out.println("Volumi pubblicato nell' anno " + annoPubblicazione + " : ");
	        for (Volume volume : ricerca) {
	        	System.out.println(volume);
	        }
	    } else {
	    	log.error("Nessun volume corrisponde ai criteri di ricerca");
	    }
	}
		
	public static void cercaPerAutore(String autore) {
	    List<Volume> ricerca = archivio.stream()
	            .filter(volume -> volume instanceof Libro && ((Libro) volume).getAutore().equals(autore))
	            .collect(Collectors.toList());

	    if (ricerca.size() > 0) {
	        System.out.println("Volumi scritti da " + autore + " : ");
	        for (Volume volume : ricerca) {
	            System.out.println(volume);
	        }
	    } else {
	    	log.error("Nessun volume corrisponde ai criteri di ricerca");
	    }
	}
	
	public static void salvaSuFile() throws IOException {
	    Map<String, Volume> archivioMap = new HashMap<>();

	    for (Volume vol : archivio) {
	        if (vol instanceof Libro) {
	            Libro libro = (Libro) vol;
	            archivioMap.put(libro.getCodiceISBN(), libro);
	        } else if (vol instanceof Rivista) {
	            Rivista rivista = (Rivista) vol;
	            archivioMap.put(rivista.getCodiceISBN(), rivista);
	        }
	    }

	    try (PrintWriter writer = new PrintWriter(file, "UTF-8")) {
	        for (Map.Entry<String, Volume> entry : archivioMap.entrySet()) {
	            String key = entry.getKey();
	            Volume volume = entry.getValue();

	            if (volume instanceof Libro) {
	                Libro libro = (Libro) volume;
	                String line = libro.getCodiceISBN() + "@" + libro.getTitolo() + "@" + libro.getAutore() + "@" + libro.getGenere() + "@" + libro.getAnnoPubblicazione() + "@" + libro.getNumeroPagine();
	                writer.println(line);
	            } else if (volume instanceof Rivista) {
	                Rivista rivista = (Rivista) volume;
	                String line = rivista.getCodiceISBN() + "@" + rivista.getTitolo() + "@" + rivista.getAnnoPubblicazione() + "@" + rivista.getNumeroPagine() + "@" + rivista.getPeriodicita();
	                writer.println(line);
	            }
	        }
	    }

	    log.info("Testo scritto su file " + file.getPath());
	}

	public static Map<String, Volume> caricaDaFile() throws IOException {
	    Map<String, Volume> archivioMap = new HashMap<>();

	    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

	    for (String line : lines) {
	        String[] properties = line.split("@");

	        if (properties.length == 6) {
	            String codiceISBN = properties[0];
	            String titolo = properties[1];
	            String autore = properties[2];
	            String genere = properties[3];
	            Year annoPubblicazione = Year.parse(properties[4]);
	            int numeroPagine = Integer.parseInt(properties[5]);

	            Volume volume = new Libro(codiceISBN, titolo, autore, genere, annoPubblicazione, numeroPagine);
	            archivioMap.put(codiceISBN, volume);
	        } else if (properties.length == 5) {
	            String codiceISBN = properties[0];
	            String titolo = properties[1];
	            Year annoPubblicazione = Year.parse(properties[2]);
	            int numeroPagine = Integer.parseInt(properties[3]);
	            Periodicita periodicita = Periodicita.valueOf(properties[4]);

	            Volume volume = new Rivista(codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicita);
	            archivioMap.put(codiceISBN, volume);
	        }
	    }

	    return archivioMap;
	}
	
	
}
