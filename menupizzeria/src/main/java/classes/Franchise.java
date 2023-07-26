package classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Franchise {
	
	private String name;
	private Double price;

	public Franchise(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getMenuLine() {
		return this.name + " - name: " + this.name + " - price: " + this.price;  
	}

}
