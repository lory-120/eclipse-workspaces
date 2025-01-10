package main;
import presentation.*;

public class MainMensola {
	public static void main(String args[]) {
		System.out.println("Benvenuto/a.");
		int nPosti;
		do {
			nPosti = Tastiera.leggiInt("Quanti posti ci sono sulla mensola? ");
			if(nPosti < 0) {
				System.out.println("La mensola non può avere posti negativi. Riprova.");
			}
		} while(nPosti < 0);
		
		MenuMensola menu = new MenuMensola(nPosti);
		menu.runMenu();
		System.out.println("\n\nAlla prossima!");
	}
}
