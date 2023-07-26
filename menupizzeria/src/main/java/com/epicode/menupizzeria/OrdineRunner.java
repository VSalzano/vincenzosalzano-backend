package com.epicode.menupizzeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import classes.Ordine;

@Component
public class OrdineRunner implements CommandLineRunner {
	
	@Autowired private OrdineSvc os;

	@Override
	public void run(String... args) throws Exception {		
		System.out.println("run..");
		
		Tavolo t1 = os.createTavolo(1, 6, false);		
		
//		Ordine o1 = os.createOrdine(1, 15.30, 1.5, 2, null, null, null, null, null);
		
		
			
	}

}
