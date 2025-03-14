package model;
import java.time.LocalDate;

/**
 * Classe Funzionario figlia di MembroPersonale.
 * Può essere Junior o Senior in base al suo anno di inizio.
 */

public class Funzionario extends MembroPersonale {
	
	//attributi
	private static double costoOraJunior = 75.0;
	private static double costoOraSenior = 85.0;
	
	//metodo costruttore
	public Funzionario(String nome, String cognome, int annoInizio) {
		super(nome, cognome, annoInizio);
	}
	
	//metodi get/set
	public double getCostoOra() {
		return isSenior() ? costoOraSenior : costoOraJunior;
	}

	public static void setCostoOraJunior(double costoOraJunior) {
		Funzionario.costoOraJunior = costoOraJunior;
	}
	public static void setCostoOraSenior(double costoOraSenior) {
		Funzionario.costoOraSenior = costoOraSenior;
	}
	
	//metodi is
	//se lavora qua da 10 o più anni, è senior
	/**
	 * Se il funzionario lavora da 10 o più anni nell'azienda, è senior. E' junior altrimenti.
	 * @return true se è senior, false altrimenti
	 */
	public boolean isSenior() {
		int periodo = LocalDate.now().getYear() - annoInizio;
		return (periodo >= 10) ? true : false;
	}
	public boolean isJunior() {
		return isSenior() ? false : true;
	}

	
	//metodo toString()
	@Override
	public String toString() {
		return "Funzionario [nome=" + getNome() + ", cognome=" + getCognome()
		+ ", codice=" + getCodice()
		+ ", annoInizio=" + getAnnoInizio()
		+ ", costoOra=" + getCostoOra()
		+ ", isSenior=" + isSenior()
		+ ", isJunior=" + isJunior()
		+ "]";
	}
	
	
	
}
