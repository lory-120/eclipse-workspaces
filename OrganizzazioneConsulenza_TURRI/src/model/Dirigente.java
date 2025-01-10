package model;

/**
 * Classe Dirigente figlia di MembroPersonale.
 * Il costo orario di un dirigente è statico.
 */

public class Dirigente extends MembroPersonale {
	//attributi
	private static double costoOra = 100.0;
	
	//metodo costruttore
	public Dirigente(String nome, String cognome, int annoInizio) {
		super(nome, cognome, annoInizio);
	}

	//metodi get/set
	public static double getCostoOra() {
		return costoOra;
	}

	public static void setCostoOra(double costoOra) {
		Dirigente.costoOra = costoOra;
	}

	
	//metodo toString()
	@Override
	public String toString() {
		return "Dirigente [nome=" + getNome() + ", cognome=" + getCognome()
		+ ", codice=" + getCodice()
		+ ", annoInizio=" + getAnnoInizio()
		+ "]";
	}
	
}