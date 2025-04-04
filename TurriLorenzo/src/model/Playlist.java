package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Playlist {

	//attributi
	private String nome;
	private LinkedList<Brano> brani;
	
	//metodo costruttore
	public Playlist() {
		this.nome = "Playlist Senza Titolo del " + LocalDate.now().toString() + " alle " + LocalTime.now().toString();
		this.brani = new LinkedList<Brano>();
	}
	public Playlist(String nome) {
		this.nome = nome;
		this.brani = new LinkedList<Brano>();
	}
	
	
	//metodi get/set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LinkedList<Brano> getBrani() {
		return brani;
	}
	
	
	
	
	//metodi della funzione
	/**
	 * Aggiunge un brano alla playlist, in modo ordinato,
	 * secondo le direttive scritte nel foglio.
	 * @param il brano da aggiungere
	 * @return true se l'ha aggiunto, false altrimenti
	 */
	public boolean addBrano(Brano b) {
		if(this.brani.isEmpty()) {
			brani.add(b);
			return true;
		}
		
		if(brani.size() == 1) {
			if(brani.get(0).getARTISTA().compareTo(b.getARTISTA()) > 0) {
				brani.add(0, b);
				return true;
			} else {
				brani.addLast(b);
				return true;
			}
		}
		
		int i = 0;
		//scorri tra i brani
		while(i < brani.size()) {
			
			while(!brani.get(i).getARTISTA().equals(b.getARTISTA()) && brani.get(i).getARTISTA().compareTo(b.getARTISTA()) < 0) {
				i++;
			}
			if(i == brani.size()) {
				brani.addLast(b);
				return true;
			}
			while(brani.get(i).getARTISTA().equals(b.getARTISTA())) {
				i++;
				if(i >= brani.size()) {
					brani.addLast(b);
					return true;
				}
			}
			
			i++;
		}
		brani.add(i, b);
		
		return true;
	}
	
	/**
	 * Rimuove tutti i brani di un genere, passato per parametro secondo
	 * l'enum Genere.
	 * @param il genere da rimuovere
	 * @return true se ha avuto successo, false altrimenti
	 */
	public boolean removeBranoGenere(Genere g) {
		if(brani.isEmpty()) {
			System.out.println("La playlist è vuota.");
			return false;
		}
		
		if(brani.size() == 1 && brani.get(0).getGENERE().equals(g)) {
			brani.clear();
			return true;
		}
		
		int i = 0;
		int braniRimossi = 0;
		while(i < brani.size()) {
			if(brani.get(i).getGENERE().equals(g)) {
				brani.remove(i);
				braniRimossi++;
				i--;
			}
			i++;
		}
		
		if(braniRimossi <= 0) {
			System.out.println("Non sono stati rimossi dei brani.");
			return false;
		} else {
			System.out.println("Brani rimossi: " + Integer.toString(braniRimossi));
			return true;
		}
		
	}
	
	
	/**
	 * Aggiunge un brano tra i preferiti, dato il titolo.
	 * @param il titolo del brano da aggiungere
	 * @return true se ha trovato il brano e l'ha agginto, false altrimenti.
	 */
	public boolean addBranoPreferito(String titolo) {
		int i = 0;
		while(i < brani.size()) {
			if(brani.get(i).getTITOLO().equals(titolo)) {
				brani.get(i).setPreferito(true);
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Visualizza tutti i brani impostati come preferiti nella playlist.
	 */
	public void viewBraniPreferiti() {
		if(brani.isEmpty()) {
			System.out.println("La playlist è vuota.");
			return;
		}
		
		boolean haVisualizzato = false;
		
		int i = 0;
		while(i < brani.size()) {
			if(brani.get(i).isPreferito()) {
				haVisualizzato = true;
				System.out.println(brani.get(i).toString());
			}
			i++;
		}
		
		System.out.println((haVisualizzato) ? "" : "Non ci sono brani impostati come preferiti nerlla tua playlist.");
	}
	
	
	/**
	 * Rimuove un brano dalla playlist dato il titolo, se lo trova.
	 * @param il titolo da rimuovere
	 * @return true se l'ha trovato e rimosso, false altrimenti.
	 */
	public boolean removeBranoTitolo(String titolo) {
		if(brani.isEmpty()) {
			return false;
		}
		
		if(brani.size() == 1 && brani.get(0).getTITOLO().equals(titolo)) {
			brani.clear();
			return true;
		}
		
		int i = 0;
		while(i < brani.size()) {
			if(brani.get(i).getTITOLO().equals(titolo)) {
				brani.remove(i);
				return true;
			}
			i++;
		}
		
		return false;
	}
	
	
	/**
	 * Visualizza i brani della playlist che hanno una durata maggiore
	 * della durata, passata come parametro.
	 * @param durata del brano
	 */
	public void viewBraniDurataMaggiore(int durata) {
		int i = 0;
		boolean haVisualizzato = false;
		while(i < brani.size()) {
			if(brani.get(i).getDURATA() > durata) {
				haVisualizzato = true;
				System.out.println(brani.get(i).toString());
			}
			i++;
		}
		
		System.out.println((haVisualizzato) ? "" : "Non ci sono brani di durata maggiore di "+durata+" nella tua playlist.");
	}
	
	
	/**
	 * Visualizza i brani della playlist che hanno una durata minore
	 * della durata, passata come parametro.
	 * @param durata del brano
	 */
	public void viewBraniDurataMinore(int durata) {
		int i = 0;
		boolean haVisualizzato = false;
		while(i < brani.size()) {
			if(brani.get(i).getDURATA() < durata) {
				haVisualizzato = true;
				System.out.println(brani.get(i).toString());
			}
			i++;
		}
		
		System.out.println((haVisualizzato) ? "" : "Non ci sono brani di durata minore di "+durata+" nella tua playlist.");
	}
	
	
	public int getDurataTot() {
		if(brani.isEmpty()) return 0;
		if(brani.size() == 1) return brani.get(0).getDURATA();
		
		int i = 0;
		int durataTot = 0;
		while(i < brani.size()) {
			durataTot += brani.get(i).getDURATA();
		}
		
		return durataTot;
	}
	
}
