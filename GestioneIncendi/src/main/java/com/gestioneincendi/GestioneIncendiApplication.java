package com.gestioneincendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestioneincendi.models.Sonda;
import com.gestioneincendi.observers.SondaObs;

@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		Sonda sonda = new Sonda(1, "lat", "long", 6); // Creo una sonda con intFumo >= 5
        SondaObs sondaObs = new SondaObs();

        sonda.addObserver(sondaObs);
        sonda.setIntFumo(6);
	}

}
