package com.epicode.menupizzeria;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import classes.Menu;
import configurations.MenupizzeriaConfiguration;

public class GestioneMenu {
	
	AnnotationConfigApplicationContext appContext;
	Menu menu;

	public GestioneMenu() {
		appContext = new AnnotationConfigApplicationContext(MenupizzeriaConfiguration.class);
		menu = (Menu) appContext.getBean("menu");
	}
	
	public void stampaMenu() {
		System.out.println("***** Menu *****");
		System.out.println("Pizzas");
		
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuLine()));
		
		System.out.println();
		
		System.out.println("Drink");
		
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
		
		System.out.println();
		
		System.out.println("Franchise");
		
		menu.getFranchise();
		
		System.out.println("***** FINE *****");
		
	}

}
