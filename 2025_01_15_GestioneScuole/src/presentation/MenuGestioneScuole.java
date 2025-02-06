package presentation;

import java.util.ArrayList;
import model.GestioneScuole;
import model.Scuola;
import utilities.ScuolaNonPresenteException;

public class MenuGestioneScuole {
	
	private GestioneScuole gestione;
	
	public MenuGestioneScuole() {
		
	}
	
	public MenuGestioneScuole(GestioneScuole gestione) {
		this.gestione=gestione;
	}
	
	private void stampaMenu() {
		System.out.println("\nMenù gestione scuole:");
		System.out.println("\n1 --> Filtra scuole per tipo");
		System.out.println("\n2 --> Filtra scuole per città");
		System.out.println("\n3 --> Filtra scuole con contributi sopra una soglia");
		System.out.println("\n4 --> Filtra scuole con più di un certo numero di studenti");
		System.out.println("\n5 --> Visualizzare le scuole con più di 500 studenti e almeno 5 laboratori");
		System.out.println("\n6 --> Visualizzare i dati di una scuola data la sua denominazione");
		System.out.println("\n7 --> Visualizzare tutte le scuole");
		System.out.println("\n8 --> Esci dal programma");
	}
	
	public void eseguiMenu() {
		boolean esci=false;
		
		while (!esci) {
			
			stampaMenu();
			
			int scelta=Tastiera.leggiInt("Cosa vuoi fare? ");
			
			switch (scelta) {
			
				case 1 -> scelta1();
				case 2 -> scelta2();
				case 3 -> scelta3();
				case 4 -> scelta4();
				case 5 -> scelta5();
				case 6 -> scelta6();
				case 7 -> scelta7();
				case 8 -> {
					
					System.out.println("Arrivederci");
					esci=true;
					
				}
				
				default -> System.out.println("Carattere inserito non valido");
			
			}
			
		}
	}

	private void scelta1() {
		String tipo="";
		
		do {
			tipo=Tastiera.leggiStringa("Inserisci il tipo di scuola (Elementare/Media/Liceo/Professionale/Tecnico)");
			if(!tipo.equalsIgnoreCase("elementare") && !tipo.equalsIgnoreCase("media") && !tipo.equalsIgnoreCase("liceo") && !tipo.equalsIgnoreCase("professionale") && !tipo.equalsIgnoreCase("Tecnico"))
				System.out.println("Stringa inserita non valida");
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
			
			System.out.println("Ecco tutte le scuole del tipo " + tipo.toLowerCase());
			
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
			citta=Tastiera.leggiStringa("Inserisci la citta: ");
			if(citta.equals(""))
				System.out.println("Stringa inserita non valida");
		} while(citta.equals(""));
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuolePerCitta(citta);
			
			System.out.println("Scuole presenti nella città " + citta);
			
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
			if(soglia<0)
				System.out.println("Valore inserito non valido");
		} while(soglia<0);
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuoleSopraSoglia(soglia);
			
			System.out.println("Scuole con contributi sopra i " + soglia + "€");
			
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
			studenti=Tastiera.leggiInt("Inserisci il numero di studenti: ");
			if(studenti<0)
				System.out.println("Valore inserito non valido");
		} while(studenti<0);
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuoleSopraStudenti(studenti);
			
			System.out.println("Scuole con più di " + studenti + " studenti");
			
			for(int i=0;i<scuole.size();i++) {
				System.out.println("\n" + scuole.get(i).toString());
			}
		} catch (ScuolaNonPresenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void scelta5() {
		
		try {
			ArrayList<Scuola> scuole = gestione.getScuoleSopraStudenti_Laboratori(500,5);
			
			System.out.println("Scuole con più di 500 studenti e 5 laboratori");
			
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
			denominazione=Tastiera.leggiStringa("Inserisci la denominazione: ");
			if(denominazione.equals(""))
				System.out.println("Stringa inserita non valida");
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
