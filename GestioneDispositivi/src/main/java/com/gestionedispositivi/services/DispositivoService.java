package com.gestionedispositivi.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestionedispositivi.models.Dispositivo;
import com.gestionedispositivi.models.Laptop;
import com.gestionedispositivi.models.Smartphone;
import com.gestionedispositivi.models.Tablet;
import com.gestionedispositivi.repos.DispositivoRepository;

@Service
public class DispositivoService {
	
	@Autowired DispositivoRepository dr;
	
	@Autowired @Qualifier("tabletBean") private ObjectProvider<Dispositivo> tabletProvider;
	@Autowired @Qualifier("laptopBean") private ObjectProvider<Dispositivo> laptopProvider;
	@Autowired @Qualifier("smartphoneBean") private ObjectProvider<Dispositivo> smartphoneProvider;
	
	public Dispositivo creaLaptop(Laptop laptop) {
		return  dr.save(laptop);
	}
	
	public Dispositivo creaTablet(Tablet tablet) {
		return  dr.save(tablet);
	}
	
	public Dispositivo creaSmartphone(Smartphone smartphone) {
		return  dr.save(smartphone);
	}

	
	}
