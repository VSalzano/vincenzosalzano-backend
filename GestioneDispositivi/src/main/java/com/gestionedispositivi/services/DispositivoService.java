package com.gestionedispositivi.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.gestionedispositivi.configurations.DispositivoConfig;
import com.gestionedispositivi.enums.Stato;
import com.gestionedispositivi.models.Dispositivo;
import com.gestionedispositivi.models.Laptop;
import com.gestionedispositivi.models.Smartphone;
import com.gestionedispositivi.models.Tablet;
import com.gestionedispositivi.repos.DispositivoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoService {
	
	@Autowired DispositivoRepository dr;
	
	@Autowired @Qualifier("tabletBean") private ObjectProvider<Dispositivo> tabletProvider;
	@Autowired @Qualifier("laptopBean") private ObjectProvider<Dispositivo> laptopProvider;
	@Autowired @Qualifier("smartphoneBean") private ObjectProvider<Dispositivo> smartphoneProvider;
	
	public Laptop creaLaptop(String marca, String modello, String sistemaOperativo, Stato stato, int memoriaRAM) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DispositivoConfig.class);
		Laptop l = (Laptop) appContext.getBean("laptopBean", marca, modello, sistemaOperativo, stato, memoriaRAM);
		appContext.close();
		return l;
	}
	
	public Dispositivo creaTablet(String marca, String modello, String sistemaOperativo, Stato stato, double dimensioneSchermo) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DispositivoConfig.class);
		Tablet t = (Tablet) appContext.getBean("tabletBean", marca, modello, sistemaOperativo, stato, dimensioneSchermo);
		appContext.close();
		return t;
	}
	
	public Dispositivo creaSmartphone(String marca, String modello, String sistemaOperativo, Stato stato, int memoriaInternaGB) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DispositivoConfig.class);
		Smartphone s = (Smartphone) appContext.getBean("smartphoneBean", marca, modello, sistemaOperativo, stato, memoriaInternaGB);
		appContext.close();
		return s;
	}
	
	public Dispositivo salvaDispositivo (Dispositivo d) {
		return dr.save(d);
	}
	
	public Laptop salvaLaptop(Laptop l) {
		return dr.save(l);
	}
	
	public Tablet salvaTablet(Tablet t) {
		return dr.save(t);
	}
	
	public Smartphone salvaSmartphone(Smartphone s) {
		return dr.save(s);
	}
	
	public List<Dispositivo> getAllDispositivi() {
		return (List<Dispositivo>) dr.findAll();
	}

	public Dispositivo getById(Long id) {		
		return dr.findById(id).get();
	}

	public String rimuoviDispositivo(Long id) {
		Dispositivo d = getById(id);
		dr.delete(d);
		return "Dispositivo cancellato";
	}
	
	public Dispositivo aggiornaDispositivo(Long id, Dispositivo dispositivo) {
		if(!dr.existsById(id)) {
			throw new EntityNotFoundException
			("Il dispositivo non esiste");
		}
		if (id != dispositivo.getId()) {
			throw new EntityNotFoundException ("Id e Dispositivo non corrispondono");
		}
		return dr.save(dispositivo);
	}
	
	}
