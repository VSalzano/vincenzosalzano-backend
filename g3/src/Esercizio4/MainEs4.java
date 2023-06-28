package Esercizio4;

import java.util.Scanner;

public class MainEs4 {

	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Inserisci un numero intero: ");
	        int numero = sc.nextInt();

	        contoAllaRovescia(numero);
	    }

	    public static void contoAllaRovescia(int numero) {
	        if (numero <= 0) {
	            System.out.println("Il numero deve essere maggiore di zero.");
	            return;
	        }

	        System.out.println("Conto alla rovescia:");

	        for (int i = numero; i >= 0; i--) {
	            System.out.println(i);
	        }
	    }
	}