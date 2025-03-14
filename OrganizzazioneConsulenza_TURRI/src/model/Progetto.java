package model;
import java.util.ArrayList;

/**
 * Contiene i dati di un progetto.
 * Contiene tutti i membri del progetto, con un ArrayList.
 */

public class Progetto {

	//attributi
	private ArrayList<Dirigente> dirigenti;
	private ArrayList<Funzionario> funzionari;
	private ArrayList<Tecnico> tecnici;	
	
	//metodo costruttore
	public Progetto() {
		this.dirigenti = new ArrayList<>();
		this.funzionari = new ArrayList<>();
		this.tecnici = new ArrayList<>();
	}


	//metodi get/set
	public ArrayList<Dirigente> getDirigenti() {
		return dirigenti;
	}
	
	/**
	 * Ricerca tra i dirigenti con il suo codice.
	 * @param searchCodice
	 * @return l'oggetto del dirigente trovato, "null" altrimenti.
	 */
	public Dirigente searchDirigenteCodice(int searchCodice) {
		for(Dirigente d : dirigenti) {
			if(d != null && d.getCodice() == searchCodice) {
				return d;
			}
		}
		return null;
	}
	
	public ArrayList<Funzionario> getFunzionari() {
		return funzionari;
	}
	
	/**
	 * Ricerca tra i funzionari con il suo codice.
	 * @param searchCodice
	 * @return l'oggetto del funzionario trovato, "null" altrimenti.
	 */
	public Funzionario searchFunzionarioCodice(int searchCodice) {
		for(Funzionario f : funzionari) {
			if(f != null && f.getCodice() == searchCodice) {
				return f;
			}
		}
		return null;
	}
	
	public ArrayList<Tecnico> getTecnici() {
		return tecnici;
	}
	
	/**
	 * Ricerca tra i tecnici con il suo codice.
	 * @param searchCodice
	 * @return l'oggetto del tecnico trovato, "null" altrimenti.
	 */
	public Tecnico searchTecnicoCodice(int searchCodice) {
		for(Tecnico t : tecnici) {
			if(t != null && t.getCodice() == searchCodice) {
				return t;
			}
		}
		return null;
	}
	
	//metodi della funzione
	public void addDirigente(Dirigente d) {
		dirigenti.add(d);
	}
	public void addFunzionario(Funzionario f) {
		funzionari.add(f);
	}
	public void addTecnico(Tecnico t) {
		tecnici.add(t);
	}
	/**
	 * Metodo per resettare tutto il progetto e per svuotare tutti
	 * i dipendenti.
	 */
	public void reset() { //resetta tutto, cancella il cotenuto di tutti gli array con la funzione clear()
		this.dirigenti.clear();
		this.funzionari.clear();
		this.tecnici.clear();
	}
	
	/**
	 * Questo metodo itera tra tutti i membri dell'organizzazione e
	 * somma i loro costi insieme.
	 * @return costo totale del progetto
	 */
	public double getCostoTotProgetto() {
		double costoTot = 0.0;
		
		//il costo di tutti i dirigenti è sempre lo stesso, si moltiplica il costo di un dirigente per il numero di dirigenti
		costoTot += Dirigente.getCostoOra() * dirigenti.size();
		
		
		for(Funzionario f:funzionari) {
			if(f != null) {
				costoTot += f.getCostoOra();
			}
		}
		for(Tecnico t:tecnici) {
			if(t != null) {
				costoTot += t.getCostoOra();
			}
		}
		
		return costoTot;
	}

	
	//metodo toString()
	@Override
	public String toString() {
		return "Progetto [dirigenti=" + dirigenti.toString() + ", funzionari=" + funzionari.toString() + ", tecnici=" + tecnici.toString() + "]";
	}	
	
}
