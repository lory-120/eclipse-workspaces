package main;
import model.*;
import presentation.*;
//import java.time.LocalDate;

/**
 * Nel main, avendo creato tutto il resto nelle altre classi, si crea solo:
 * - l'oggetto del progetto;
 * - il menu relativo al progetto. 
 */

public class MainOrganizzazioneConsulenza {

	public static void main(String[] args) {
		Progetto progetto = new Progetto();
		MenuOrganizzazioneConsulenza menu = new MenuOrganizzazioneConsulenza(progetto);
		menu.runMenu();
	}

}