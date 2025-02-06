package model;

public class ScuolaMedia extends Scuola {
	
	//attibuti
	
	private static double contributiStudente=150;
	private static double contributiLaboratorio=1100;
	private static double contributiSede=9000;
	
	//metodi
	//metodo costruttore
	
	public ScuolaMedia(String codice, String denominazione, String indirizzo, String citta, int nStudenti, int nClassi,int nSedi, int nLaboratori) {
		super(codice, denominazione, indirizzo, citta, nStudenti, nClassi, nSedi, nLaboratori);
	}
	
	//get e set
	
	public static double getContributiStudente() {
		return contributiStudente;
	}

	public static void setContributiStudente(double contributiStudente) {
		ScuolaMedia.contributiStudente = contributiStudente;
	}

	public static double getContributiLaboratorio() {
		return contributiLaboratorio;
	}

	public static void setContributiLaboratorio(double contributiLaboratorio) {
		ScuolaMedia.contributiLaboratorio = contributiLaboratorio;
	}

	public static double getContributiSede() {
		return contributiSede;
	}

	public static void setContributiSede(double contributiSede) {
		ScuolaMedia.contributiSede = contributiSede;
	}

	//altri metodi
	
	public double getContributi() {
		return this.getnStudenti()*contributiStudente+this.getnLaboratori()*contributiLaboratorio+this.getnSedi()*contributiSede;
	}
	
	//toString
	
	public String toString() {
		return super.toString();
	}
}
