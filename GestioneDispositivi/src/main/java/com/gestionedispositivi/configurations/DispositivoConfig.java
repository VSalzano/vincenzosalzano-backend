package com.gestionedispositivi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gestionedispositivi.enums.Stato;
import com.gestionedispositivi.models.Laptop;
import com.gestionedispositivi.models.Smartphone;
import com.gestionedispositivi.models.Tablet;

@Configuration
public class DispositivoConfig {
	
	@Bean("laptopBean")
	@Scope("prototype")
	public Laptop nuovoLaptop(String marca, String modello, String sistemaOperativo, Stato stato, int memoriaRAM) {
		return new Laptop(marca, modello, sistemaOperativo, stato, memoriaRAM);
	}
	
	@Bean("tabletBean")
	@Scope("prototype")
	public Tablet nuovoTablet(String marca, String modello, String sistemaOperativo, Stato stato, double dimensioneSchermo) {
		return new Tablet(marca, modello, sistemaOperativo, stato, dimensioneSchermo);
	}
	
	@Bean("smartphoneBean")
	@Scope("prototype")
	public Smartphone nuovoSmartphone(String marca, String modello, String sistemaOperativo, Stato stato, int memoriaInternaGB) {
		return new Smartphone(marca, modello, sistemaOperativo, stato, memoriaInternaGB);
	}

}
