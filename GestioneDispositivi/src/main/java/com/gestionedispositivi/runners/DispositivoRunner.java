package com.gestionedispositivi.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gestionedispositivi.enums.Stato;
import com.gestionedispositivi.models.Smartphone;
import com.gestionedispositivi.models.Tablet;
import com.gestionedispositivi.services.DispositivoService;

@Component
public class DispositivoRunner implements CommandLineRunner {
	
	@Autowired DispositivoService ds;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("disp runner");
		
		ds.salvaLaptop(ds.creaLaptop("DELL", "XPS 15", "Windows 10", Stato.DISPONIBILE, 16));
		ds.salvaTablet((Tablet) ds.creaTablet("Samsung", "Galaxy Tab S7", "Android 11", Stato.DISPONIBILE, 10.5));
		ds.salvaSmartphone((Smartphone) ds.creaSmartphone("Apple", "iPhone 13", "iOS 15", Stato.DISPONIBILE, 128));
		
	}

}
