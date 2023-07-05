package threads;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumThread1 extends Thread {
	
	private Logger log = LoggerFactory.getLogger(NumThread1.class);
	
    private static Random rn = new Random();
    private static int[] numArr = new int[1000];

    @Override
    public void run() {
    	generaRn();
    }

    private void generaRn() {
        for (int i = 0; i < 1000; i++) {
            numArr[i] = rn.nextInt(100);
        }
        log.info(Arrays.toString(numArr));
    }

    public int somma () {
        int s = 0;
        for (int number : numArr) {
            s += number;
        }
        return s;
    }
}