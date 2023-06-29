package classes;

public class Dipendente {
	
	private static final double stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente (int matricola, Dipartimento dipartimento) {
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.matricola = matricola;
		this.dipartimento = dipartimento;		
	}
	
	public Dipendente (int matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public Livello getLivello() {
        return livello;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setImportoOrarioStraordinario(double importo) {
        this.importoOrarioStraordinario = importo;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }
	
    public void stampaDatiDipendente() {
        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Importo orario straordinario: " + importoOrarioStraordinario);
        System.out.println("Livello: " + livello);
        System.out.println("Dipartimento: " + dipartimento);
    }
    
    public Livello promuovi() {
        Livello promozione = null;

        switch (livello) {
            case OPERAIO:
                promozione = Livello.IMPIEGATO;
                stipendio = stipendioBase * 1.2;
                System.out.println("Impiegato promosso a: " + promozione);
                break;
            case IMPIEGATO:
                promozione = Livello.QUADRO;
                stipendio = stipendioBase * 1.5;
                System.out.println("Impiegato promosso a: " + promozione);
                break;
            case QUADRO:
                promozione = Livello.DIRIGENTE;
                stipendio = stipendioBase * 2;
                System.out.println("Impiegato promosso a: " + promozione);
                break;
            case DIRIGENTE:
            	promozione = Livello.DIRIGENTE;
            	System.out.println("Questo dipendente non può essere promosso ulteriormente.");
            	break;            	
        }

        livello = promozione;
        return promozione;
    }
    
    public static double calcolaPaga (Dipendente dipendente) {
    	return dipendente.getStipendio();
    }
    

    public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
        double pagaStraordinario = dipendente.getImportoOrarioStraordinario() * oreStraordinario;
        return dipendente.getStipendio() + pagaStraordinario;
    }

}
