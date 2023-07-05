package g3e3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainE3 {
	
	private static File file = new File("doc/test.txt");
	private static Logger log = LoggerFactory.getLogger(MainE3.class);

	public static void main(String[] args) {
		
		try {
			aggiungiPresenza("Mario Rossi", "5");
			aggiungiPresenza("Luca Verdi", "3");
			aggiungiPresenza("Vincenzo Salzano", "7");
		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}
	
	public static void aggiungiPresenza (String nome, String giorni) throws IOException {
		String testo = nome + "@" + giorni + "#";
		FileUtils.writeStringToFile(file, testo, "UTF-8", true);
		log.info("Presenza aggiunta");
	}
	
	public static String leggiRegistro() throws IOException {
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		return textFile;
	}

}
