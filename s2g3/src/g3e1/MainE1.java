package g3e1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import threads.Thread1;
import threads.Thread2;

public class MainE1 {
	
	private static Logger log = LoggerFactory.getLogger(MainE1.class);


	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.start();
		t2.start();
		
	}

}
