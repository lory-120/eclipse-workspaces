package main;
import model.*;

public class MainServiziFinanziari {

	public static void main(String[] args) {

		//istanzio le carte
		CartaBronze cBronze = new CartaBronze(100);
		CartaSilver cSilver = new CartaSilver(200);
		CartaGold cGold = new CartaGold(50);
		
		//istanzio l'oggetto per gestire le carte
		GestioneCarte gestione = new GestioneCarte();
		
		//aggiungo le carte
		gestione.addCarta(cBronze);
		gestione.addCarta(cSilver);
		gestione.addCarta(cGold);
		
		
	}

}
