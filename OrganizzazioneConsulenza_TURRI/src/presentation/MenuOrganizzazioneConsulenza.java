package presentation;
//import java.util.ArrayList;
import java.time.LocalDate;
import model.*;
//import main.*;

/**
 * Classe menu dell'organizzazione di consulenza, che opera un oggetto di tipo progetto ad essa passato.
 * Ogni funzione è destinata a prendere l'input dall'utente con la classe "Tastiera" e operare con le
 * funzioni relative al menu.
 */

public class MenuOrganizzazioneConsulenza {
	//progetto su cui operare, si inizializza quando viene creato l'oggetto del menu
	private Progetto progetto;
	
	//metodo costruttore
	public MenuOrganizzazioneConsulenza(Progetto progetto) {
		this.progetto = progetto;
	}
	
	
	//mostra il menu
	private void printMenu() {
		System.out.println("Immetti la tua scelta:\n"
				+ "1 - inserisci membro del personale;\n"
				+ "2 - visualizza informazioni di un impiegato;\n"
				+ "3 - visualizza tutti gli impiegati di una competenza;\n"
				+ "4 - visualizza tutti i funzionari;\n"
				+ "5 - visualizza tutti i funzionari senior;\n"
				+ "6 - visualizza tutti i dirigenti;\n"
				+ "7 - visualizza il costo del progetto per un impiegato;\n"
				+ "8 - visualizza il costo totale del progetto;\n"
				+ "9 - inserisci un nuovo progetto e aggiungi i membri;\n"
				+ "0 - esci dal programma.\n");
	}
	
	/**
	 * Metodo che esegue il menu. All'utente si chiede un numero da 0 a 9 per navigarci.
	 * Una volta scelta l'opzione, si usa il metodo dedicato.
	 */
	public void runMenu() {		
		boolean exit = false;
		int choice;
		do {
			printMenu();
			choice = Tastiera.leggiInt("Scelta: ");
			switch(choice) {
			case 1 -> addMembroPersonale();
			case 2 -> viewInfoImpiegato();
			case 3 -> viewImpiegatiCompetenza();
			case 4 -> viewAllFunzionari();
			case 5 -> viewFunzionariSenior();
			case 6 -> viewAllDirigenti();
			case 7 -> viewCostoImpiegato();
			case 8 -> viewCostoTot();
			case 9 -> createNewProgetto();
			case 0 -> {
				System.out.println("Alla prossima!");
				exit = true;
			}
			default -> System.out.println("\n\nScelta errata. Riprova.");
			}
		} while(!exit);
	}


	//metodi della funzione di ogni scelta dal menu
	
	private void addMembroPersonale() { //aggiungi un membro del personale
		//si raccoglie nome e cognome
		String nome = Tastiera.leggiString("Inserisci il nome: ");
		String cognome = Tastiera.leggiString("Inserisci il cognome: ");
		
		//si raccoglie l'anno di inizio/assunzione
		int annoInizio;
		do {
			annoInizio = Tastiera.leggiInt("Inserisci l'anno in cui è stato/a assunto: ");
			if(annoInizio > LocalDate.now().getYear()) { //l'anno di assunzione non deve essere nel futuro
				System.out.println("L'anno di inizio non può essere nel futuro, ma prima dell'anno " + LocalDate.now().getYear() + ". Riprova.");
			}
		} while(annoInizio > LocalDate.now().getYear());
		
		//si raccoglie l'area di competenza, che per ora è un int, ma poi verrà convertita
		int type;
		do {
			System.out.println("Inserisci il tipo di membro:\n"
					+ "1 - dirigente;\n"
					+ "2 - funzionario;\n"
					+ "3 - tecnico.\n");
			type = Tastiera.leggiInt("Scelta: ");
			if(type < 0 || type > 3) {
				System.out.println("Scelta non valida, riprova.");
			}
		} while(type < 0 || type > 3);
		
		//ora si crea e inserisce l'oggetto nel progetto in base alla competenza scelta
		if(type == 3) { //se è un tecnico, si chiede l'organizzazione e la sua competenza specifica
			//si chiede se è esterno o interno (int)
			int org;
			do {
				System.out.println("Inserisci:\n"
						+ "1 - se è interno;\n"
						+ "2 - se è esterno.\n");
				org = Tastiera.leggiInt("Scelta: ");
				if(org < 0 || org > 1) {
					System.out.println("Scelta non valida, riprova.");
				}
			} while(org < 0 || org > 1);
			//si chiede se ha la competenza in informatica o elettronica (int)
			int skill;
			do {
				System.out.println("Inserisci la competenza:\n"
						+ "1 - informatica;\n"
						+ "2 - elettronica.\n");
				skill = Tastiera.leggiInt("Scelta: ");
				if(skill < 0 || skill > 1) {
					System.out.println("Scelta non valida, riprova.");
				}
			} while(skill < 0 || skill > 1);
			
			//ora si mette la competenza in base al numero intero
			Organizzazione o = (org == 1) ? Organizzazione.INTERNO : Organizzazione.ESTERNO;
			Competenza c = (skill == 1) ? Competenza.INFORMATICA : Competenza.ELETTRONICA;
			
			Tecnico t = new Tecnico(nome, cognome, annoInizio, o, c);
			progetto.addTecnico(t);
		} else if(type == 2) { //se è un funzionario
			Funzionario f = new Funzionario(nome, cognome, annoInizio);
			progetto.addFunzionario(f);
		} else if(type == 1) { //se è un dirigente
			Dirigente d = new Dirigente(nome, cognome, annoInizio);
			progetto.addDirigente(d);
		}
		
		System.out.println("Impiegato aggiunto.");
	}
	
	private void viewInfoImpiegato() { //visualizza le info di un impiegato, dato il suo codice
		int searchCodice;
		//si inserisce il codice da cercare, che deve essere maggiore o uguale di 1
		do {
			searchCodice = Tastiera.leggiInt("Inserisci il codice dell'impiegato da cercare: ");
			if(searchCodice < 1) {
				System.out.println("Non esiste un codice minore di 0. Riprova.");
			}
		} while(searchCodice < 1);
		
		//ricerca tra dirigenti, funzionari e tecnici il codice
		boolean found = false; //flag per indicare che l'impiegato/a è stato/a trovato/a, in modo da saltare delle operazioni inutili
		if(progetto.searchDirigenteCodice(searchCodice) != null) {
			System.out.println(progetto.searchDirigenteCodice(searchCodice).toString());
			found = true;
		}
		if(progetto.searchFunzionarioCodice(searchCodice) != null && found == false) {
			System.out.println(progetto.searchFunzionarioCodice(searchCodice).toString());
			found = true;
		}
		if(progetto.searchTecnicoCodice(searchCodice) != null && found == false) {
			System.out.println(progetto.searchTecnicoCodice(searchCodice).toString());
			found = true;
		}
		
		//se il flag resta sempre il false, allora non ha trovato niente
		if(!found) {
			System.out.println("Non è stato trovato nessun impiegato di codice " + searchCodice + ".");
		}
		
	}
	
	private void viewImpiegatiCompetenza() { //visualizza tutti gli impiegati di una data competenza
		int competenza;
		//leggi la competenza tramite un piccolo menu
		do {
			System.out.println("Inserisci la competenza:\n"
					+ "1 - dirigente;\n"
					+ "2 - funzionario;\n"
					+ "3 - tecnico.\n");
			competenza = Tastiera.leggiInt("Scelta: ");
			if(competenza < 1 || competenza > 3) {
				System.out.println("Scelta non valida, riprova.");
			}
		} while(competenza < 1 || competenza > 3);
		
		//visualizza tutti gli impiegati della competenza inserita dall'utente
		try {
			switch(competenza) { //se l'array è vuoto, stampa un messaggio di errore. Così si evita di far stampare "[]" e basta
			case 1 -> System.out.println((progetto.getDirigenti().isEmpty()) ? "Errore, nessun dirigente disponibile." : progetto.getDirigenti().toString());
			case 2 -> System.out.println((progetto.getFunzionari().isEmpty()) ? "Errore, nessun funzionario disponibile." : progetto.getFunzionari().toString());
			case 3 -> System.out.println((progetto.getTecnici().isEmpty()) ? "Errore, nessun tecnico disponibile." : progetto.getTecnici().toString());
			}
		} catch(NullPointerException e) { //se in casi estremi c'è un NullPointerException
			System.out.println("Errore, nessun impiegato della competenza scelta disponibile. (null)");
		}
		
	}
	
	private void viewAllFunzionari() { //visualizza tutti i funzionari		
		try { //se l'array è vuoto, stampa il messaggio di errore
			System.out.println((progetto.getFunzionari().isEmpty()) ? "Errore, nessun funzionario disponibile." : progetto.getFunzionari().toString());
		} catch(NullPointerException e) { //se in casi estremi c'è un NullPointerException
			System.out.println("Errore: nessun funzionario disponibile.");
		}
	}
	
	private void viewFunzionariSenior() { //visualizza tutti i funzionarti senior
		if(progetto.getFunzionari().isEmpty()) { //se l'array è vuoto, stampa il messaggio di errore
			System.out.println("Non hai nessun funzionario disponibile.");
			return;
		}
		
		try {
			for(Funzionario f : progetto.getFunzionari()) {
				if(f.isSenior()) {
					System.out.println(f.toString());
				}
			}
		} catch(NullPointerException e) {
			System.out.println("Errore: nessun funzionario senior disponibile.");
		}
	}
	
	private void viewAllDirigenti() { //visualizza tutti i dirigenti
		try { //se l'array è vuoto, stampa il messaggio di errore
			System.out.println((progetto.getDirigenti().isEmpty()) ? "Errore, nessun dirigente disponibile." : progetto.getDirigenti().toString());
		} catch(NullPointerException e) {
			System.out.println("Errore: nessun dirigente disponibile. (null)");
		}
		
	}
	
	private void viewCostoImpiegato() { //visualizza il costo di un certo impiegato, dato il codice dall'utente
		int searchCodice;
		//l'utente inserisce il codice
		do {
			searchCodice = Tastiera.leggiInt("Inserisci il codice dell'impiegato: ");
			if(searchCodice < 1) {
				System.out.println("Non esiste un codice minore di 0. Riprova.");
			}
		} while(searchCodice < 1);
		
		double costoOra = 0;
		
		boolean found = false; //flag per indicare che l'impiegato/a è stato/a trovato/a, in modo da saltare delle operazioni inutili
		if(progetto.searchDirigenteCodice(searchCodice) != null) {
			System.out.println(progetto.searchDirigenteCodice(searchCodice).toString());
			found = true;
			costoOra = Dirigente.getCostoOra();
		}
		if(progetto.searchFunzionarioCodice(searchCodice) != null && found == false) {
			System.out.println(progetto.searchFunzionarioCodice(searchCodice).toString());
			found = true;
			costoOra = progetto.searchFunzionarioCodice(searchCodice).getCostoOra();
		}
		if(progetto.searchTecnicoCodice(searchCodice) != null && found == false) {
			System.out.println(progetto.searchTecnicoCodice(searchCodice).toString());
			found = true;
			costoOra = progetto.searchTecnicoCodice(searchCodice).getCostoOra();
		}
		
		if(found) {
			System.out.println("Il costo orario dell'impiegato di codice " + searchCodice + " è di " + costoOra);
		} else {
			System.out.println("Non è stato trovato nessun impiegato di codice " + searchCodice + ".");
		}
	}
	
	private void viewCostoTot() { //visualizza il costo totale del progetto
		System.out.println("Il costo totale del progetto è di " + progetto.getCostoTotProgetto() + ".");
	}
	
	private void createNewProgetto() { //crea un nuovo progetto, resettando quello corrente
		String choice;
		//si chiede all'utente se vuole davvero cancellare tutti i dati del progetto
		do {
			choice = Tastiera.leggiString("Sicuro/a di ricominciare da capo con un nuovo progetto? (s/n)");
			choice = "" + choice.charAt(0);
			if(!choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("n")) {
				System.out.println("Scelta non valida, riprova.");
			}
		} while(choice.equalsIgnoreCase("s") && choice.equalsIgnoreCase("n"));
		
		//se ha scelto di sì allora resetta, altrimenti fa niente
		if(choice.equalsIgnoreCase("s")) {
			progetto.reset();
			System.out.println("Progetto Resettato. Inizio con un nuovo progetto.");
		}		
	}	
	
}
