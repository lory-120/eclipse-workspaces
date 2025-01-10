package presentation;
import model.*;

public class MenuMensola {
	private Mensola mensola;
	
	public MenuMensola(int capacita) {
		this.mensola=new Mensola(capacita);
	}
	
	private void printMenu() {
		System.out.println("Menu Mensola: "
						   + "\n1. Aggiungi Libro"
						   + "\n2. Rimuovi libro"
						   + "\n3. Trova libro per titolo"
						   + "\n4. Trova libri di un autore"
						   + "\n5. Visualizza numero libri presenti sulla mensola"
						   + "\n6. Esci");
	}
	
	public void runMenu() {
		boolean esci=false;
		while(!esci) {
			printMenu();
			int scelta=Tastiera.leggiInt("Immetti scelta: ");
			switch(scelta) {
				case 1 -> aggiungiLibro();
				case 2 -> rimuoviLibro();
				case 3 -> cercaLibroPerTitolo();
				case 4 -> cercaLibriPerAutore();
				case 5 -> visualizzaNumLibri();
				case 6 -> esci=true;
			}
		}
	}
	
	
	private void aggiungiLibro() {
		Libro libro=creaLibro();
		boolean aggiunto=mensola.aggiungiLibro(libro);
		if(aggiunto) {
			System.out.println("Libro aggiunto con successo!");
		} else {
			System.out.println("Impossibile completare l'operazione!");
		}
	}
	private Libro creaLibro() {
		String titolo=Tastiera.leggiString("Immetti titolo libro: ");
		String autore=Tastiera.leggiString("Immetti autore libro: ");
		int numPagine=Tastiera.leggiInt("Immetti numero pagine: ");
		return new Libro(titolo, autore, numPagine);
	}
	
	
	private void rimuoviLibro() {
		String titolo=Tastiera.leggiString("Immetti titolo libro da eliminare: ");
		boolean rimosso=mensola.rimuoviLibro(titolo);
		if(rimosso) {
			System.out.println("Libro rimosso con successo!");
		} else {
			System.out.println("Rimozione non riuscita!");
		}
	}
	
	
	private void cercaLibroPerTitolo() {
		String search = Tastiera.leggiString("Inserisci il titolo del libro da cercare: ");
		Libro result = mensola.cercaLibro(search);
		if(result != null) {
			System.out.println("Ecco il libro trovato:\n" + result.toString());
		} else {
			System.out.println("Nessun libro trovato di titolo '" + search + "'.");
		}
	}
	
	
	private void cercaLibriPerAutore() {
		String search = Tastiera.leggiString("Inserisci l'autore del libro da cercare: ");
		Libro result[] = mensola.cercaLibroPerAutore(search);
		if(result != null) {
			System.out.println("Ecco il libro trovato(i):\n");
			for(Libro l:result) {
				System.out.println(l.toString());
			}
		} else {
			System.out.println("Nessun libro trovato dell'autore '" + search + "'.");
		}
	}
	
	
	private void visualizzaNumLibri() {
		System.out.println("\nCi sono " + mensola.getNumLibri() + " libri nella tua mensola.\n");
	}
}
