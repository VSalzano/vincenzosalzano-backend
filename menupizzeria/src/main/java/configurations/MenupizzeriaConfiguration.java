package configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import classes.Lemonade;
import classes.Menu;
import classes.Mug;
import classes.PizzaHawaiian;
import classes.PizzaMargherita;
import classes.PizzaSalami;
import classes.Shirt;
import classes.Water;
import classes.Wine;

@Configuration
public class MenupizzeriaConfiguration {
	
	@Bean
	@Scope("singleton") 
	public Menu menu() {
		Menu m = new Menu();
		
		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(pizzaHawaiian());
		m.getMenuPizza().add(pizzaSalami());
		
		m.getMenuDrink().add(drinkLemonade());
		m.getMenuDrink().add(drinkWater());
		m.getMenuDrink().add(drinkWine());
		
		m.getFranchise().add(mug());
		m.getFranchise().add(shirt());
		
		return m;
	}
	
	// bean Pizza
	
	@Bean
	@Scope("singleton")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	@Scope("singleton")
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}
	
	@Bean
	@Scope("singleton")
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	// bean Drink
	
	@Bean
	@Scope("singleton")
	public Lemonade drinkLemonade() {
		return new Lemonade();
	}
	
	@Bean
	@Scope("singleton")
	public Water drinkWater() {
		return new Water();
	}
	
	@Bean
	@Scope("singleton")
	public Wine drinkWine() {
		return new Wine();
	}
	
	@Bean
	@Scope("singleton")
	public Mug mug() {
		return new Mug();
	}
	
	@Bean
	@Scope("singleton")
	public Shirt shirt() {
		return new Shirt();
	}
	

}
