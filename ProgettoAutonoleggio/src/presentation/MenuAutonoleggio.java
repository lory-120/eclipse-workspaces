package presentation;
import model.*;

public class MenuAutonoleggio {

	private Autonoleggio autonoleggio;
	
	public MenuAutonoleggio(Autonoleggio autonoleggio) {
		this.autonoleggio = autonoleggio;
	}
	
	private void printMenu() {
		System.out.println("Scegli l'opzione: \n"
				+ "1 - aggiungi veicolo;\n"
				+ "2 - elimina veicolo per codice o targa;\n"
				+ "3 - ricerca veicolo per codice o targa:\n"
				+ "4 - visualizza tutti i veicoli;\n"
				+ "5 - visualizza tutti i veicoli con un determinato numero di posti;\n"
				+ "6 - visualizza quanti veicoli ci sono di una data marca;\n"
				+ "0 - esci dal programma.");							
	}
	
	public void runMenu() {
		boolean exit = false;
		int choice;
		do {
			printMenu();
			choice = Tastiera.leggiInt("Scelta: ");
			switch(choice) {
			case 1 -> addVeicolo();
			case 2 -> delVeicolo();
			case 3 -> searchVeicolo();
			case 4 -> viewAllVeicoli();
			case 5 -> viewVeicoliPerPosti();
			case 6 -> countVeicoliPerMarca();
			case 0 -> {
				System.out.println("Alla prossima!");
				exit = true;
			}
			default -> System.out.println("\n\nScelta errata. Riprova.");
			}
		} while(!exit);
	}
 	
	private void addVeicolo() {
		Veicolo veicolo = createVeicolo();
		boolean added = autonoleggio.addVeicolo(veicolo);
		System.out.println(added ? "Veicolo aggiunto con successso." : "Autonoleggio pieno, impossibile aggiungere il veicolo.");
	}
	private Veicolo createVeicolo() {
		String targa = "";
		do {
			targa = Tastiera.leggiString("Inserisci la targa (7 caratteri): ");
			if(targa.length() != 7) {
				System.out.println("La targa inserita non ha 7 caratteri. Riprova.");
			}
		} while(targa.length() != 7);
		
		String modello = Tastiera.leggiString("Inserisci il modello: ");
		String marca = Tastiera.leggiString("Inserisci la marca: ");
		int nPosti = Tastiera.leggiInt("Insrrisci il numero di posti: ");
		
		return new Veicolo(targa, marca, modello, nPosti);
	}
	
	
	private void delVeicolo() {
		int choice;
		do {
			choice = Tastiera.leggiInt("1 - per rimuovere col codice;\n2 - per rimuovere con la targa.\nScelta: ");
			if(choice < 1 || choice > 2) {
				System.out.println("Scelta non valida. Riprova.");
			}
		} while(choice < 1 || choice > 2);
		
		
		boolean removed = false;
		
		if(choice == 1) {
			int codice, codiceMax = GeneratoreCodice.getCodice();
			do {
				codice = Tastiera.leggiInt("Immetti codice del veicolo da eliminare: ");
				if(codice < 0 || codice > codiceMax) {
					System.out.println("Il codice può essere compreso tra 0 e " + codiceMax + ". Riprova.");
				}
			} while(codice < 0 || codice > codiceMax);
			
			removed = autonoleggio.deleteVeicolo(codice);
		} else {
			String targa = "";
			do {
				targa = Tastiera.leggiString("Immetti la targa del veicolo da eliminare (7 caratteri): ");
				if(targa.length() != 7) {
					System.out.println("La targa deve contenere 7 caratteri. Riprova.");
				}
			} while(targa.length() != 7);
			removed = autonoleggio.deleteVeicolo(targa);
		}
		
		
		if(removed) {
			System.out.println("Veicolo eliminato.\n");
		} else {
			System.out.println("Errore nell'eliminazione del veicolo o\nveicolo non esistente.");
		}
	}
	
	
	private void searchVeicolo() {
		int choice;
		do {
			choice = Tastiera.leggiInt("1 - per cercare col codice;\n2 - per cercare con la targa.\nScelta: ");
			if(choice < 1 || choice > 2) {
				System.out.println("Scelta non valida. Riprova.");
			}
		} while(choice < 1 || choice > 2);
		
		
		Veicolo result;
		if(choice == 1) {
			int codice, codiceMax = GeneratoreCodice.getCodice();
			do {
				codice = Tastiera.leggiInt("Immetti codice del veicolo da cercare: ");
				if(codice < 0 || codice > codiceMax) {
					System.out.println("Il codice può essere compreso tra 0 e " + codiceMax + ". Riprova.");
				}
			} while(codice < 0 || codice > codiceMax);
			
			result = autonoleggio.searchVeicolo(codice);
		} else {
			String targa = "";
			do {
				targa = Tastiera.leggiString("Immetti la targa del veicolo da cercare (7 caratteri): ");
				if(targa.length() != 7) {
					System.out.println("La targa deve contenere 7 caratteri. Riprova.");
				}
			} while(targa.length() != 7);
			
			result = autonoleggio.searchVeicolo(targa);
		}
		
		if(result != null) {
			System.out.println("Veicolo trovato:");
			System.out.println(result.toString());
		} else {
			System.out.println("Non e' stato trovato un veicolo.");
		}
	}
	
	
	private void viewAllVeicoli() {
		Veicolo listVeicoli[] = autonoleggio.getVeicoli();
		
		System.out.println("Elenco tutti i veicoli:");		
		for(Veicolo v:listVeicoli) {
			if(v != null) {
				System.out.println(v.toString() + "\n\n");
			}
		}
	}
	
	
	private void viewVeicoliPerPosti() {
		int search = Tastiera.leggiInt("Inserisci il numero di posti: ");
		Veicolo result[] = autonoleggio.searchPerPosti(search);
		System.out.println("Sono stati trovati " + result.length + " veicoli con " + search + " posti.");
		if(result.length != 0) {
			for(Veicolo v:result) {
				System.out.println(v.toString());
			}
		}
	}
	
	
	private void countVeicoliPerMarca() {
		String search = Tastiera.leggiString("Inserisci la marca del veicolo da cercare: ");
		int result = autonoleggio.searchPerMarca(search);
		System.out.println("Ci sono " + result + " veicoli di marca '" + search + "'.");
	}
 	
}
