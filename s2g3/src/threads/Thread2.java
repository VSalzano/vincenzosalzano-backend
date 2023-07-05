package threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread2 extends Thread {

	private Logger log = LoggerFactory.getLogger(Thread2.class);
	private String message;
	
	public Thread2 () {
	}
	
	@Override
	public void run () {
			try {
				for ( int i = 1 ; i <= 10 ; i++) {
				log.info(i + "*");
				Thread1.sleep(1000);
			}
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
}
