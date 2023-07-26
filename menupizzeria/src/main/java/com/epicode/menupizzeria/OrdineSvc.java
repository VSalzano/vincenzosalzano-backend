package com.epicode.menupizzeria;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import classes.Drink;
import classes.Franchise;
import classes.Ordine;
import classes.Ordine.OrdineBuilder;
import classes.PizzaBase;
import classes.StatoOrdine;
@Service
public class OrdineSvc {
	
	@Autowired @Qualifier ("ordineBean") private ObjectProvider<Ordine> ordineProvider;
	@Autowired @Qualifier ("tavoloBean") private ObjectProvider<Tavolo> tavoloProvider;
	
	public Ordine createOrdine(int numeroOrdine, LocalTime oraAcquisizione, double costoCoperto, 
			int numeroCoperti, List <PizzaBase> pizzeOrdinate, List <Drink> drinkOrdinati, List <Franchise> oggettiOrdinati,
			String nota, StatoOrdine stato) {
		Ordine o = ordineProvider.getObject();
		
		o.builder()
				.numeroOrdine(numeroOrdine)
				.oraAcquisizione(oraAcquisizione)
				.costoCoperto(costoCoperto)
				.numeroCoperti(numeroCoperti)
				.pizzeOrdinate(pizzeOrdinate)
				.drinkOrdinati(drinkOrdinati)
				.oggettiOrdinati(oggettiOrdinati)
				.nota(nota)
				.stato(stato);
		
		return o;
	}
	
	public Tavolo createTavolo(int numero, int maxCoperti, boolean libero) {
		
		Tavolo t = tavoloProvider.getObject();
		
		t.builder()
			.numero(numero)
			.maxCoperti(maxCoperti)
			.libero(libero);
		
		return t;
	}
}
