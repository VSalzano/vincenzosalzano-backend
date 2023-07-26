package configurations;

import java.time.LocalTime;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.menupizzeria.Tavolo;

import classes.Drink;
import classes.Franchise;
import classes.Ordine;
import classes.PizzaBase;
import classes.StatoOrdine;
import classes.Water;

@Configuration
public class OrdiniConfiguration {
	
	@Bean("tavoloBean")
	@Scope("prototype")
	public Tavolo getTavolo(int numero, int maxCoperti, boolean libero) {
		return new Tavolo(numero, maxCoperti, libero);
	}
	
	@Bean("ordineBean")
	@Scope("prototype")
	public Ordine getOrdine(int numeroOrdine, LocalTime oraAcquisizione, double costoCoperto, 
			int numeroCoperti, List <PizzaBase> pizzeOrdinate, List <Drink> drinkOrdinati, List <Franchise> oggettiOrdinati,
			String nota, StatoOrdine stato) {
		return new Ordine(numeroOrdine, oraAcquisizione, costoCoperto, numeroCoperti, pizzeOrdinate, drinkOrdinati, oggettiOrdinati, nota, stato);
	}

}
