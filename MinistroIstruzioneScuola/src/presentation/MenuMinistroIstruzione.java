package presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.*;
import utilities.ScuolaNonPresenteException;

public class MenuMinistroIstruzione {
	
	private GestioneScuole gestione;
	
	public MenuMinistroIstruzione() {
	}
	
	public MenuMinistroIstruzione(GestioneScuole gestione) {
		this.gestione = gestione;
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
		System.out.println("8. - Aggiungi una scuola;");
		System.out.println("9. - Rimuovi una scuola dato il nome;");
		System.out.println("10. - Salva le scuole in un file CSV;");
		System.out.println("11. - Carica le scuole da un file CSV;");
		System.out.println("0. - Esci dal programma.");
	}
	
	public void runMenu() {
		boolean exitFlag = false;
		while (!exitFlag) {
			printMenu();
			int choice=Tastiera.leggiInt("Scelta: ");
			switch (choice) {			
				case 1 -> scelta1();
				case 2 -> scelta2();
				case 3 -> scelta3();
				case 4 -> scelta4();
				case 5 -> scelta5();
				case 6 -> scelta6();
				case 7 -> scelta7();
				case 8 -> scelta8();
				case 9 -> scelta9();
				case 10 -> scelta10();
				case 11 -> scelta11();
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
	
	
	private void scelta8() { //aggiungi scuola		
		String nome = ""; //si prende in input il nome della scuola
		do {
			nome = Tastiera.leggiString("Inserisci il nome della scuola da aggiungere: ");
			System.out.println((nome.equals("")) ? "Il nome non può essere vuoto." : "Il nome della scuola è " + nome);
		} while(nome.equals(""));
		
		String city = ""; //si prende in input la città della scuola
		do {
			city = Tastiera.leggiString("Inserisci la città della scuola: ");
			System.out.println((city.equals("")) ? "La città non può essere vuota." : "La città della scuola è " + city);
		} while(city.equals(""));
		
		int nStudenti = 0; //si prende in input il numero degli studenti
		do {
			nStudenti = Tastiera.leggiInt("Inserisci il numero degli studenti nella scuola '" + nome + "':");
			System.out.println((nStudenti < 0) ? "Il numero non può essere negativo." : "Il n° di studenti è " + nStudenti);
		} while(nStudenti < 0);
		
		int nClassi = 0; //si prende in input il numero delle classi
		do {
			nClassi = Tastiera.leggiInt("Inserisci il numero delle classi nella scuola '" + nome + "':");
			System.out.println((nClassi < 0) ? "Il numero non può essere negativo." : "Il n° di classi è " + nClassi);
		} while(nClassi < 0);
		
		int nSediAggiuntive = 0; //si prende in input il numero di sedi aggiuntive
		do {
			nSediAggiuntive = Tastiera.leggiInt("Inserisci il numero delle sedi aggiuntive nella scuola '" + nome + "':");
			System.out.println((nSediAggiuntive < 0) ? "Il numero non può essere negativo." : "Il n° di sedi aggiuntive è " + nSediAggiuntive);
		} while(nSediAggiuntive < 0);
		
		int nLab = 0; //si prende in input il numero di laboratori
		do {
			nLab = Tastiera.leggiInt("Inserisci il numero di laboratori nella scuola '" + nome + "':");
			System.out.println((nLab < 0) ? "Il numero non può essere negativo." : "Il n° di laboratori è " + nLab);
		} while(nLab < 0);
		
		//si prende in input il tipo di scuola (Elementare, Media, Liceo, Professionale, Tecnico)
		String choice = "";
		boolean isValid = true;
		do {
			isValid = true;
			choice = Tastiera.leggiString("Inserisci il tipo di scuola che aggiungi (Elementare, Media, Liceo, Professionale, Tecnico): ");
			switch(choice.toLowerCase()) {
				case "elementare" -> gestione.aggiungiScuola(new ScuolaElementare(nome, city, nStudenti, nClassi, nSediAggiuntive, nLab));
				case "media" -> gestione.aggiungiScuola(new ScuolaMedia(nome, city, nStudenti, nClassi, nSediAggiuntive, nLab));
				case "liceo" -> gestione.aggiungiScuola(new Liceo(nome, city, nStudenti, nClassi, nSediAggiuntive, nLab));
				case "professionale" -> gestione.aggiungiScuola(new Professionale(nome, city, nStudenti, nClassi, nSediAggiuntive, nLab));
				case "tecnico" -> gestione.aggiungiScuola(new Tecnico(nome, city, nStudenti, nClassi, nSediAggiuntive, nLab));
				default -> isValid = false;
			}
			System.out.println((isValid) ? "Scuola aggiunta." : "Tipo non valido. Riprova.");
		} while(!isValid);
		
	}
	
	private void scelta9() { //rimuovi scuola
		String src = Tastiera.leggiString("Inserisci il nome della scuola da eliminare: ");
		System.out.println((gestione.rimuoviScuola(src)) ? "Scuola eliminata." : "Scuola '" + src + "' non trovata.");
	}
	
	
	private void scelta10() { //salva su un file csv
		String fileName = Tastiera.leggiString("Inserisci il nome del file sul quale caricare i dati delle scuole: ");
		
		try {
			gestione.salvaScuole(fileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Scuole salvate.");
	}
	
	private void scelta11() { //carica da file csv
		String fileName = Tastiera.leggiString("Inserisci il nome del file dal quale caricare le scuole: ");
		
		try {
			gestione.caricaScuole(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Non è stato trovato il file '" + fileName + "':\n" + e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Scuole caricate. Adesso le puoi visualizzare.");
	}
	
}
