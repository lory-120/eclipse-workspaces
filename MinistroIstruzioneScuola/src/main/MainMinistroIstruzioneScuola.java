package main;
import presentation.MenuMinistroIstruzione;
import model.GestioneScuole;

public class MainMinistroIstruzioneScuola {
	public static void main(String args[]) {
		GestioneScuole g = new GestioneScuole();
		MenuMinistroIstruzione menu = new MenuMinistroIstruzione(g);
		menu.runMenu();
	}
}
