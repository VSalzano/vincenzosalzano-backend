package classes;

import interfaces.ILuminosita;

public class Immagine extends ElementoMultimediale implements ILuminosita {
	
	public int luminosita;

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		
		this.titolo = titolo;
		this.riproducibile = false;
		this.luminosita = luminosita;
	}
	
	@Override
	public void show() {		
		System.out.print(titolo);
		for (int j = 1; j <= this.luminosita ; j++) {
			System.out.print("*");
		}
		System.out.println();
	}

	@Override	
	public void aumentaLuminosita() {
		if (this.luminosita < 5) {
			System.out.println("Luminosità aumentata!");
			this.luminosita ++;
		} else {
			System.out.println("Luminosità massima raggiunta");
		}

		this.show();
		
	}

	@Override
	public void diminuisciLuminosita() {
		if (this.luminosita > 0) {
			System.out.println("Luminosità diminuita!");
			this.luminosita --;
		} else {
			System.out.println("Luminosità già al minimo");
		}
		this.show();
		
	}

	@Override
	public void play() {		
	}

}
