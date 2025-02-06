package presentation;

import java.util.ArrayList;
import model.GestioneScuole;
import model.Scuola;
import utilities.ScuolaNonPresenteException;

public class MenuMinistroIstruzione {
	
	private GestioneScuole gestione;
	
	public MenuMinistroIstruzione() {
	}
	
	public MenuMinistroIstruzione(GestioneScuole gestione) {
		this.gestione=gestione;
	}
	
	private void printMenu() {
		System.out.println("\nScegli l'opzione:");
		System.out.println("1. - Filtra scuole per tipo;");
		System.out.println("2. - Filtra scuole per città;");
		System.out.println("3. - Filtra scuole con contributi sopra una soglia;");
		System.out.println("4. - Filtra scuole con più di un certo numero di studenti;");
		System.out.println("5. - Visualizza le scuole con più di 500 studenti e almeno 5 laboratori;");
		System.out.println("6. - Visualizza i dati di una scuola dato il suo nome;");
		System.out.println("7. - Visualizza tutte le scuole;");
		System.out.println("0. - Esci dal programma.");
	}
	
	public void runMenu() {
		boolean exitFlag=false;
		while (!exitFlag) {
			printMenu();
			int scelta=Tastiera.leggiInt("Scelta: ");
			switch (scelta) {			
				case 1 -> scelta1();
				case 2 -> scelta2();
				case 3 -> scelta3();
				case 4 -> scelta4();
				case 5 -> scelta5();
				case 6 -> scelta6();
				case 7 -> scelta7();
				case 0 -> {					
					System.out.println("Alla prossima!");
					exitFlag=true;					
				}
				default -> System.out.println("Scelta non valida. Riprova.");			
			}			
		}
	}

	private void scelta1() {
		String tipo="";
		
		do {
			tipo=Tastiera.leggiString("Inserisci il tipo di scuola (Elementare/Media/Liceo/Professionale/Tecnico): ");
			if(!tipo.equalsIgnoreCase("elementare") && !tipo.equalsIgnoreCase("media") && !tipo.equalsIgnoreCase("liceo") && !tipo.equalsIgnoreCase("professionale") && !tipo.equalsIgnoreCase("Tecnico"))
				System.out.println("Tipo inserito non valido. Riprova.");
		} while(!tipo.equalsIgnoreCase("elementare") && !tipo.equalsIgnoreCase("media") && !tipo.equalsIgnoreCase("liceo") && !tipo.equalsIgnoreCase("professionale") && !tipo.equalsIgnoreCase("Tecnico"));
		
		try {
			ArrayList<Scuola> scuole = null;

			switch (tipo.toLowerCase()) {
				case "elementare" -> scuole = gestione.getElementari();
				case "media" -> scuole = gestione.getMedie();
				case "liceo" -> scuole = gestione.getLicei();
				case "professionale" -> scuole = gestione.getProfessionali();
				case "tecnico" -> scuole = gestione.getTecnici();
			}
			
			System.out.println("Ecco tutte le scuole del tipo " + tipo.toLowerCase() + ":");
			
			for(int i=0;i<scuole.size();i++) {
				System.out.println("\n" + scuole.get(i));
			}
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta2() {
		String citta="";
		
		do {
			citta=Tastiera.leggiString("Inserisci la città: ");
			if(citta.equals(""))
				System.out.println("Città inserita non valida. Riprova.");
		} while(citta.equals(""));
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuolePerCitta(citta);
			
			System.out.println("Scuole presenti nella città " + citta + ":");
			
			for(int i=0;i<scuole.size();i++) {
				System.out.println("\n" + scuole.get(i).toString());
			}
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta3() {
		double soglia=0;
		
		do {
			soglia=Tastiera.leggiDouble("Inserisci la soglia: ");
			if(soglia < 0)
				System.out.println("Valore inserito non valido. Riprova.");
		} while(soglia < 0);
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuoleSopraSoglia(soglia);
			
			System.out.println("Scuole con contributi sopra i " + soglia + "€:");
			
			for(int i=0;i<scuole.size();i++) {
				System.out.println("\n" + scuole.get(i).toString());
			}
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta4() {
		int studenti=0;
		
		do {
			studenti = Tastiera.leggiInt("Inserisci il numero di studenti: ");
			if(studenti < 0)
				System.out.println("Valore inserito non valido. Riprova.");
		} while(studenti < 0);
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuoleSopraStudenti(studenti);
			
			System.out.println("Scuole con più di " + studenti + " studenti:");
			
			for(int i=0;i<scuole.size();i++) {
				System.out.println("\n" + scuole.get(i).toString());
			}
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta5() {
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuoleSopraStudenti_Laboratori(500, 5);
			
			System.out.println("Scuole con più di 500 studenti e 5 laboratori: ");
			
			for(int i=0;i<scuole.size();i++) {
				System.out.println("\n" + scuole.get(i).toString());
			}
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta6() {
		String denominazione="";
		
		do {
			denominazione=Tastiera.leggiString("Inserisci il nome della scuola: ");
			if(denominazione.equals(""))
				System.out.println("Nome inserito non valido. Riprova.");
		} while(denominazione.equals(""));
		
		try {
			Scuola scuola = gestione.getScuolaPerDenominazione(denominazione);
			
			System.out.println(scuola.toString());
			
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta7() {
		System.out.println(gestione.toString());
	}
	
}
