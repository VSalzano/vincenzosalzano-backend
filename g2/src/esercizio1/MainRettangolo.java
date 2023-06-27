package esercizio1;

public class MainRettangolo {
	public static void main(String[] args) {
		
		Rettangolo r1 = new Rettangolo (12, 23);		
		Rettangolo r2 = new Rettangolo (8, 15);
		
		stampaRettangolo(r1.altezza, r1.larghezza);
		System.out.println(" ************************ ");
		stampaDueRettangoli(r1.altezza, r1.larghezza, r2.altezza, r2.larghezza);
		

	}
	
	public static void stampaRettangolo (int altezza, int larghezza) {
		int areaRettangolo = altezza * larghezza;
		int perimetroRettangolo = (altezza + larghezza) * 2;
		
		System.out.println("Area rettangolo : " + areaRettangolo);
		System.out.println("Perimetro rettangolo : " + perimetroRettangolo);
	}
	
	public static void stampaDueRettangoli (int alt1, int lar1, int alt2, int lar2 ) {
		int area1 = alt1 * lar1;
		int perimetro1 = (alt1 + lar1) * 2;
		int area2 = alt2 * lar2;
		int perimetro2 = (alt2 + lar2) * 2;
		int sommaPerim = perimetro1 + perimetro2;
		
		System.out.println("Area primo rettangolo : " + area1);
		System.out.println("Perimetro primo rettangolo : " + perimetro1);
		System.out.println("Area secondo rettangolo : " + area2);
		System.out.println("Perimetro secondo rettangolo : " + perimetro2);
		System.out.println("Somma del perimetro dei due rettangoli : " + sommaPerim);
	}

}
