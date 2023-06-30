package classes;

import interfaces.ILuminosita;
import interfaces.IVolume;

public class Video extends ElementoMultimediale implements ILuminosita, IVolume {
	
	public int durata;
	public int volume;
	public int luminosita;
	

	public Video(String titolo, int durata) {
		super(titolo);
		this.durata = durata;
		this.volume = 2;
		this.riproducibile = true;
		this.luminosita = 2;		
	}
	
	@Override
	public void play() {
		for (int j = 1; j <= this.durata; j++ ) {
			System.out.print(this.titolo);
			for (int i = 1; i <= this.volume; i ++) {
				System.out.print("!");
			}
			for (int p = 1; p <= this.luminosita; p ++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Override
	public void aumentaVolume() {
		if (this.volume < 5) {
			System.out.println("Volume aumentato!");
			this.volume ++;
		} else {
			System.out.println("Volume massimo raggiunta");
		}
		
		this.play();
		
	}

	@Override
	public void diminuisciVolume() {
		if (this.volume > 0) {
			System.out.println("Volume diminuito!");
			this.volume --;
		} else {
			System.out.println("Volume già al minimo");
		}
		this.play();
		
	}

	@Override
	public void aumentaLuminosita() {
		if (this.luminosita < 5) {
			System.out.println("Luminosità aumentata!");
			this.luminosita ++;
		} else {
			System.out.println("Luminosità massima raggiunta");
		}

		this.play();
		
	}

	@Override
	public void diminuisciLuminosita() {
		if (this.luminosita > 0) {
			System.out.println("Luminosità diminuita!");
			this.luminosita --;
		} else {
			System.out.println("Luminosità già al minimo");
		}
		this.play();
	}

	@Override
	public void show() {
		
	}

}
