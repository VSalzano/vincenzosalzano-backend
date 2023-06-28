package Esercizio1;

public class MainEs1 {

	public static void main(String[] args) {
		String str1 = "Aspirapolvere";
		String str2 = "Ciao";
		
		
		System.out.println(stringaPariDispari(str1));
		System.out.println(stringaPariDispari(str2));

	}
	
	public static boolean stringaPariDispari (String str) {
		if (str.length()%2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}