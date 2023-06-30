package classes;

public abstract class ElementoMultimediale {
	
	protected String titolo;
	public boolean riproducibile;
	
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}

	public abstract void play();

	public abstract void show();


	

}
