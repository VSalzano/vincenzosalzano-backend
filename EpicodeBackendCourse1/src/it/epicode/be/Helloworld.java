package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		Scanner stringa = new Scanner (System.in);
		
		System.out.print("Scrivi stringa 1:");
		String str = stringa.nextLine();
		System.out.print("Scrivi stringa 2:");
		String str1 = stringa.nextLine();
		System.out.print("Scrovo stringa 3:");
		String str2 = stringa.nextLine();
		
		System.out.println("Ordine 1 : " + str + " " + str1 + " " + str2);
		System.out.println("Ordine 2 : " + str2 + " " + str1 + " " + str);
		}

	public static int prodotto (int x, int y) {
		return x * y;
	}
	
	public static String stringa (String x, int y) {
		return x + y;
	}
	
	public static String[] editArr(String str[], String newStr)
    {
        String[] newArr=new String[6];
        if(str.length!=5) return newArr;
        else
        {
            for(int i=0; i<newArr.length; i++)
            {
                if(i<2) newArr[i]=str[i];
                else if(i==2) newArr[i]=newStr;
                else newArr[i]=str[i-1];
            }
            return newArr;
        }
    }
	
	public static float perimetroRettangolo (float base, float altezza) {
		return (base + altezza) * 2;
	}
	
	public static int pariDispari (int x) {
		return x%2;
	}
	
	public static float areaTriangolo (float base, float altezza) {
		return (base * altezza) / 2;
	}
	
}
	

		
	



