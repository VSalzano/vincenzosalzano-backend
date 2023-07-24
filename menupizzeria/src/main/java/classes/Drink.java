package classes;

public class Drink {
	
	private String name;
	private Double price;
	private Double calories;

	public Drink(String name, Double price, Double calories) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	public String getMenuLine() {
		return this.name + " - caloreis: " + this.calories + " - price: " + this.price;  
	}

}
