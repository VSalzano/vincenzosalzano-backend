package com.gestionedispositivi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gestionedispositivi.models.Laptop;
import com.gestionedispositivi.models.Smartphone;
import com.gestionedispositivi.models.Tablet;

@Configuration
public class DispositivoConfig {
	
	@Bean("laptopBean")
	@Scope("prototype")
	public Laptop nuovoLaptop() {
		return new Laptop();
	}
	
	@Bean("tabletBean")
	@Scope("prototype")
	public Tablet nuovoTablet() {
		return new Tablet();
	}
	
	@Bean("smartphonetBean")
	@Scope("prototype")
	public Smartphone nuovoSmartphone() {
		return new Smartphone();
	}

}
