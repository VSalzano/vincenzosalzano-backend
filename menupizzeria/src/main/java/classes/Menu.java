package classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<PizzaBase> menuPizza = new ArrayList<PizzaBase>();
	private List<Drink> menuDrink = new ArrayList<Drink>();
	private List<Franchise> franchise = new ArrayList<Franchise>();

	
	public List<PizzaBase> getMenuPizza() {
		return menuPizza;
	}

	public List<Drink> getMenuDrink() {
		return menuDrink;
	}
	
	public List <Franchise> getFranchise() {
		return franchise;
	}


}
