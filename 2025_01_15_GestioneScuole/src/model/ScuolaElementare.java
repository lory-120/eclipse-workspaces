package model;

public class ScuolaElementare extends Scuola {
	
	//attributi
	
	private static double contributiStudente=125;
	private static double contributiSede=9000;

	//metodi
	//metodo costruttore
	
	public ScuolaElementare(String codice, String denominazione, String indirizzo, String citta, int nStudenti,	int nClassi, int nSedi, int nLaboratori) {
		super(codice, denominazione, indirizzo, citta, nStudenti, nClassi, nSedi, nLaboratori);
	}
	
	//get e set
	
	public static double getContributiStudente() {
		return contributiStudente;
	}

	public static void setContributiStudente(double contributiStudente) {
		ScuolaElementare.contributiStudente = contributiStudente;
	}

	public static double getContributiSede() {
		return contributiSede;
	}

	public static void setContributiSede(double contributiSede) {
		ScuolaElementare.contributiSede = contributiSede;
	}
	
	//altri metodi
	
	public double getContributi() {
		return this.getnStudenti()*contributiStudente + this.getnSedi()*contributiSede;
	}
	
	//toString
	
	public String toString() {
		return super.toString();
	}
}
