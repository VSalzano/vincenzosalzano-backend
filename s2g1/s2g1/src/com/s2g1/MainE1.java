package com.s2g1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.PosizioneSbagliata;

public class MainE1 {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(MainE1.class);
		int[] array = new int[5];
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }


        System.out.println("Array iniziale: " + Arrays.toString(array));

        int valore;
        int posizione;

        do {

            System.out.print("Inserisci il valore (0 per terminare): ");
            valore = sc.nextInt();


            if (valore == 0) {
                break;
            }


            System.out.print("Inserisci la posizione (0-4): ");
            posizione = sc.nextInt();

            try {

                if (posizione >= 0 && posizione < array.length) {

                    array[posizione] = valore;


                    System.out.println("Nuovo stato dell'array: " + Arrays.toString(array));
                } else {
                    throw new PosizioneSbagliata("La posizione inserita non è valida. Riprova.");
                }
            } catch (PosizioneSbagliata e) {
                log.error(e.getMessage());
            }
        } while (true);

        System.out.println("Programma terminato.");
    }

	}
