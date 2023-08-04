package com.gestionedispositivi.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.gestionedispositivi.enums.Stato;
import com.gestionedispositivi.services.DispositivoService;

public class DispositivoRunner implements CommandLineRunner {
	
	@Autowired DispositivoService ds;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("disp runner");
		
		ds.salvaDispositivo(ds.creaLaptop("DELL", "XPS 15", "Windows 10", Stato.DISPONIBILE, 16));
		ds.salvaDispositivo(ds.creaTablet("Samsung", "Galaxy Tab S7", "Android 11", Stato.DISPONIBILE, 10.5));
		ds.salvaDispositivo(ds.creaSmartphone("Apple", "iPhone 13", "iOS 15", Stato.DISPONIBILE, 128));
		
	}

}
