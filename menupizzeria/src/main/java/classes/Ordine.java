package classes;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ordine {
	
	private int numeroOrdine;
	private LocalTime oraAcquisizione;
	@Value("${ordine.costoCoperto}")
	private double costoCoperto;
	private int numeroCoperti;
	private List <PizzaBase> pizzeOrdinate;
	private List <Drink> drinkOrdinati;
	private List <Franchise> oggettiOrdinati;
	private String nota;
	private StatoOrdine stato;
	
	
	
    public double calcolaPrezzoTotale() {
        double prezzoPizze = pizzeOrdinate.stream().mapToDouble(PizzaBase::getPrice).sum();
        double prezzoDrink = drinkOrdinati.stream().mapToDouble(Drink::getPrice).sum();
        double prezzoOggetti = oggettiOrdinati.stream().mapToDouble(Franchise::getPrice).sum();
        
        double prezzoTot = prezzoPizze + prezzoDrink + prezzoOggetti + (this.costoCoperto * this.numeroCoperti);
        return prezzoTot;

    }
	

}
