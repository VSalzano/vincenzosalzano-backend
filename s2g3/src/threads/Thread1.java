package threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread1 extends Thread {

	private Logger log = LoggerFactory.getLogger(Thread1.class);
	private String message;
	
	public Thread1 () {

	}
	
	@Override
	public void run () {
			try {
				for ( int i = 1 ; i <= 10 ; i++) {
				log.info(i + "!");
				Thread1.sleep(1000);
			}
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

