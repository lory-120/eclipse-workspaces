package main;

import java.util.ArrayList;

import presentation.MenuGestioneScuole;
import model.*;

public class MainGestioneScuole {
	
	public static void main(String[] args) {
		ArrayList<Scuola> app=new ArrayList<Scuola>();
		
		app.add(new ScuolaElementare("1234", "Bortolotti", "Viale Pratese", "Sesto Fiorentino", 200, 10, 2, 5));
		app.add(new ScuolaMedia("4567", "Franchi", "Via gramsci", "Firenze", 300, 13, 3, 5));
		app.add(new ScuolaSuperioreLiceo("91421", "Bianchi", "Via Firenze", "Prato", 150, 10, 1, 1));
		app.add(new ScuolaSuperioreProfessionale("1462", "Meucci", "Piazza Mercatale", "Milano", 250, 15, 1, 10, 1500));
		app.add(new ScuolaSuperioreTecnico("01230", "Buzzi", "Viale della Repubblica", "Roma", 700, 75, 5, 50));
		
		GestioneScuole app2=new GestioneScuole(app);
		
		MenuGestioneScuole menu=new MenuGestioneScuole(app2);
		menu.eseguiMenu();
	}
	
}
