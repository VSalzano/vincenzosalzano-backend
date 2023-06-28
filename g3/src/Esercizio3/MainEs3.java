package Esercizio3;

import java.util.Scanner;

public class MainEs3 {
    public static void main(String[] args) {
        splitStringWithComma();
    }

    public static void splitStringWithComma() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Inserisci una stringa (o :q per uscire): ");
            input = scanner.nextLine();

            if (!input.equals(":q")) {
                String[] characters = input.split("");
                String result = String.join(",", characters);
                System.out.println(result);
            }
        } while (!input.equals(":q"));

        scanner.close();
    }
}

