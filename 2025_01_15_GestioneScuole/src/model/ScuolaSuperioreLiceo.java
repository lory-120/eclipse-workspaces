package model;

public class ScuolaSuperioreLiceo extends ScuolaSuperiore {
	
	//attributi
	private static double contributiStudente=150;
	private static double contributiLaboratorio=1100;
	
	//metodi
	//metodo costruttore
	
	public ScuolaSuperioreLiceo(String codice, String denominazione, String indirizzo, String citta, int nStudenti, int nClassi,int nSedi, int nLaboratori) {
		super(codice, denominazione, indirizzo, citta, nStudenti, nClassi, nSedi, nLaboratori);
	}
	
	//get e set
	
	public static double getContributiStudente() {
		return contributiStudente;
	}

	public static void setContributiStudente(double contributiStudente) {
		ScuolaSuperioreLiceo.contributiStudente = contributiStudente;
	}

	public static double getContributiLaboratorio() {
		return contributiLaboratorio;
	}

	public static void setContributiLaboratorio(double contributiLaboratorio) {
		ScuolaSuperioreLiceo.contributiLaboratorio = contributiLaboratorio;
	}

	//altri metodi
	
	public double getContributi() {
		return this.getnStudenti()*contributiStudente+this.getnLaboratori()*contributiLaboratorio;
	}
	
	//toString
	
	public String toString() {
		return super.toString();
	}
}
