package model;
import java.time.LocalDate;

/**
 * Classe Tecnico figlia di MembroPersonale.
 * Ha una specifica competenza e organizzazione.
 */

public class Tecnico extends MembroPersonale {

	//attributi
	private Organizzazione org;
	private Competenza skill;
	private static double costoOra = 50.0;
	
	//metodo costruttore
	public Tecnico(String nome, String cognome, int annoInizio, Organizzazione org, Competenza skill) {
		super(nome, cognome, annoInizio);
		this.org = org;
		this.skill = skill;
	}

	//metodi get/set
	/**
	 * Il costo all'ora di un tecnico è detto anche dalla sua organizzazione e dal suo anno
	 * di inizio.
	 * @return il costo orario.
	 */
	public double getCostoOra() {
		double costoTot = costoOra;
		//il costo tot è definito dal costo all'ora + 1€ per ogni anno che è passato fino ad oggi
		if(this.org == Organizzazione.INTERNO) {
			costoTot += LocalDate.now().getYear() - annoInizio;
		}
		return costoTot;
	}
	public static void setCostoOra(double costoOra) {
		Tecnico.costoOra = costoOra;
	}
	public Organizzazione getOrganizzazione() {
		return this.org;
	}
	public Competenza getCompetenza() {
		return this.skill;
	}

	
	//metodo toString()
	@Override
	public String toString() {
		return "Tecnico [org=" + org 
				+ ", skill=" + skill 
				+ ", nome=" + getNome() + " " + getCognome() 
				+ ", annoInizio=" + getAnnoInizio() 
				+ ", costoOra" + getCostoOra() + "]";
	}

}
