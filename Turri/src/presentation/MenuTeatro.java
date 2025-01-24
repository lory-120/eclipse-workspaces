package presentation;
import model.*;
import java.time.*;
import java.util.*;

public class MenuTeatro {

	private int nSale;
	private Sala sale[];
	
	public MenuTeatro(int nSale) {
		this.nSale = nSale;
		sale = new Sala[nSale];
		for(Sala s:sale) {
			s = new Sala(50);
		}
	}
	
	private void printMenu() {
		System.out.println("Scegli l'opzione:\n"
				+ "1 - aggiungi uno spettacolo;\n"
				+ "2 - visualizza la durata di una proiezione, dato il nome;\n"
				+ "3 - visualizza le sale libere;\n"
				+ "4 - visualizza lo spettacolo in una determinata sala;"
				+ "5 - visualizza il genere di una rappresentazione, dato il nome;\n"
				+ "0 - esci dal programma.");
	}
	
	public void runMenu() {
		boolean exit = false;
		int choice;
		do {
			printMenu();
			choice = Tastiera.leggiInt("Scelta: ");
			switch(choice) {
			case 1 -> addSpettacolo();
			case 2 -> viewProiezioneDurata();
			case 3 -> viewSaleLibere();
			case 4 -> viewSpettacoloInSala();
			case 5 -> viewRappresentazioneGenere();
			case 0 -> {
				System.out.println("Alla prossima!");
				exit = true;
			}
			default -> System.out.println("Scelta non valida. Riprova.");
			}
		} while(!exit);
	}	
	
	private void addSpettacolo() {
		
		String nome = Tastiera.leggiString("Inserisci il nome dello spettacolo:");
		double prezzo;
		do {
			prezzo = Tastiera.leggiDouble("Inserisci il prezzo dello spettacolo: ");
			System.out.println((prezzo < 0) ? "Il prezzo non può essere negativo." : "");
		} while(prezzo < 0);
		
		int giorno, mese, anno;
		boolean valid = true;
		LocalDate data = null;
		do {
			valid = true;
			giorno = Tastiera.leggiInt("Inserisci il giorno: ");
			mese = Tastiera.leggiInt("Inserisci il mese: ");
			anno = Tastiera.leggiInt("Inserisci l'anno: ");
			try {
				data = LocalDate.of(anno, mese, giorno);
			} catch(DateTimeException e) {
				System.out.println("Data errata. Riprova.");
				valid = false;
			}
		} while(!valid);
		
		int ora, minuto;
		LocalTime time = null;
		do {
			valid = true;
			ora = Tastiera.leggiInt("Inserisci l'ora: ");
			minuto = Tastiera.leggiInt("Inserisci il minuto:");
			try {
				time = LocalTime.of(ora, minuto);
			} catch(DateTimeException e) {
				System.out.println("Ora errata. Riprova.");
				valid = false;
			}
		} while(!valid);
		
		int choice;
		do {
			choice = Tastiera.leggiInt("Inserisci 1 se vuoi scegliere la sala, 2 se prendi la prima disponibile: ");
			System.out.println((choice > 2 || choice < 1) ? "Scelta errata, riprova." : "");
		} while(choice > 2 || choice < 1);
		
		int nSala = -1;
		if(choice == 1) {
			do {
				valid = true;
				nSala = Tastiera.leggiInt("Inserisci il numero di sala che vuoi perndere: ");
				if(!sale[nSala].isOccupata() && sale[nSala] != null) {
					sale[nSala].setOccupata(true);
					System.out.println("Hai preso la sala " + nSala);
				} else {
					System.out.println("La sala è occupata o non esiste. Riprova.");
					valid = false;
				}
			} while(!valid);
		} else {
			for(int i=0; i<nSale; i++) {
				if(sale[i] != null) {
					if(!sale[i].isOccupata()) {
						sale[i].setOccupata(true);
						nSala = i;
						System.out.println("Hai preso la sala " + nSala);
					}
				}				
			}
		}
		
		choice = -1;
		do {
			choice = Tastiera.leggiInt("Inserisci 1 se è una proiezione, 2 se è una rappresentazione: ");
			System.out.println((choice > 2 || choice < 1) ? "Scelta errata, riprova." : "");
		} while(choice > 2 || choice < 1);
		
		if(choice == 1) {
			int durataMinuti;
			do {
				durataMinuti = Tastiera.leggiInt("Inserisci la durata in minuti della proiezione: ");
				System.out.println((durataMinuti < 0) ? "I minuti non possono essere negativi, riprova." : "");
			} while(durataMinuti < 0);
			
			try {
				Proiezione p = new Proiezione(nome, prezzo, data, time, sale[nSala], durataMinuti);
				sale[nSala].setSpettacoloAssegnato(p);
			} catch(Exception e) {
				System.out.println("Errore generale.\n" + e.toString());
			}
		} else {
			GenereRappresentazione genere;
			do {
				valid = true;
				String genereStr = null;
				try {
					genereStr = Tastiera.leggiString("Inserisci il genere della rappresentazione (dramma, commedia, tragedia o musical)");
					genere = GenereRappresentazione.valueOf(genereStr.toUpperCase());
				} catch(IllegalArgumentException e) {
					System.out.println("Non esiste il genere '" + genereStr + "'. Riprova.");
				}
			} while(!valid);
		}
		
	}
	
	private void viewProiezioneDurata() { //(non finito)
		String src = Tastiera.leggiString("Inserisci il nome della proiezione: ");
		for(Sala s:sale) {
			//try {
				
			//}
		}
	}
	
	private void viewSaleLibere() {
		System.out.println("Le sale libere sono: ");
		for(int i=0; i<nSale; i++) {
			if(!sale[i].isOccupata()) {
				System.out.println(i + " ");
			}
		}
	}
	
	private void viewSpettacoloInSala() {
		int choice;
		do {
			choice = Tastiera.leggiInt("Inserisci la sala dove vedere: ");
			if(choice < 0 || choice > nSale) {
				System.out.println("Non esiste la sala " + choice + ". Riprova.");
			} else {
				if(sale[choice].isOccupata()) {
					System.out.println("Il nome dello spettacolo è: " + sale[choice].getSpettacoloAssegnato().getNome());
				} else {
					System.out.println("Nella sala " + choice + "non c'è nessuno spettacolo.");
				}
			}
		} while(choice < 0 || choice > nSale);
	}
	
	private void viewRappresentazioneGenere() {
		
	}
	
	
	
}
