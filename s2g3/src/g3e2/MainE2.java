package g3e2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import threads.NumThread1;

public class MainE2 {
	
	private static Logger log = LoggerFactory.getLogger(MainE2.class);


	public static void main(String[] args) throws InterruptedException {
		
		
		
		NumThread1 t1 = new NumThread1();
		NumThread1 t2 = new NumThread1();
		NumThread1 t3 = new NumThread1();
		
		t1.start();
		t1.join();
		int s1 = t1.somma();
		log.info("La somma dei numeri nel primo array  è : " + s1);
		t2.start();
		t2.join();
		int s2 = t2.somma();
		log.info("La somma dei numeri nel secondo array  è : " + s2);
		t3.start();
		t3.join();
		int s3 = t3.somma();
		log.info("La somma dei numeri nel terzo array  è : " + s3);
		
		int sommaTotale = s1 + s2 + s3;
		log.info("La somma totale di tutti i numeri contenuti negli array è : " + sommaTotale);
		
		

	}

}
