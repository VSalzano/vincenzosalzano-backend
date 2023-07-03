package com.s2g1e2;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainE2 {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(MainE2.class);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Inserisci il numero di km percorsi: ");
            double km = sc.nextDouble();

            System.out.print("Inserisci i litri di carburante consumati: ");
            double litri = sc.nextDouble();

            if (litri == 0) {
                throw new ArithmeticException("Divisione per 0 impossibile");
            }

            double kmPerLitro = km / litri;
            System.out.println("Il numero di km/litro percorsi è: " + kmPerLitro);
        } catch (ArithmeticException e) {
            log.error(e.getMessage());
        }
    }

	}
