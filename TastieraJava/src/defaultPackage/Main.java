package defaultPackage;

import presentation.Tastiera;

public class Main {
	public static void main(String args[]) {
		//NON SERVE ISTANZIARE L'OGGETTO PERCHE' E' STATICO
		System.out.println("Test di I/O");
		
		String str = Tastiera.leggiString("Inserisci una stringa: ");
		System.out.println("Stringa letta: " + str);
		
		int n1 = Tastiera.leggiInt("Inserisci un numero intero: ");
		System.out.println("Intero letto: " + n1);
		
		double n2 = Tastiera.leggiDouble("Inserisci un numero double: ");
		System.out.println("Double letto: " + n2);
		
		float n3 = Tastiera.leggiFloat("Inserisci un numero float: ");
		System.out.println("Float letto: " + n3);
		
		System.out.println("Arrivederci!");
		
	}
}
