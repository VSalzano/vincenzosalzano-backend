package classes;

import interfaces.IVolume;

public class RegistrazioneAudio extends ElementoMultimediale implements IVolume {
	
	public int volume;
	public int durata;

	public RegistrazioneAudio(String titolo, int durata) {
		super(titolo);
		this.titolo = titolo;
		this.durata = durata;
		this.riproducibile = true;
		this.volume = 2;
		
	}
	
	@Override
	public void play() {
		for (int j = 1; j <= this.durata; j++ ) {
			System.out.print(this.titolo);
			for (int i = 1; i <= this.volume; i ++) {
				System.out.print("!");
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
	public void show() {
		
	}

}
