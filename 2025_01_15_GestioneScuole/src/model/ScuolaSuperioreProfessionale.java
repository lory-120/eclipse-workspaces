package model;

public class ScuolaSuperioreProfessionale extends ScuolaSuperiore {
	//attributi
	
	private static double contributiClasse=3500;
	private static double contributiLaboratorio=6000;
	private double contributiRegionali;
	
	//metodi
	//metodo costruttore
	
	public ScuolaSuperioreProfessionale(String codice, String denominazione, String indirizzo, String citta, int nStudenti, int nClassi,int nSedi, int nLaboratori, double contributiRegionali) {
		super(codice, denominazione, indirizzo, citta, nStudenti, nClassi, nSedi, nLaboratori);
		this.contributiRegionali=contributiRegionali;
	}
	
	//get e set
	
	public static double getContributiStudente() {
		return contributiClasse;
	}

	public static void setContributiStudente(double contributiStudente) {
		ScuolaSuperioreProfessionale.contributiClasse = contributiStudente;
	}
	public static double getContributiLaboratorio() {
		return contributiLaboratorio;
	}

	public static void setContributiLaboratorio(double contributiLaboratorio) {
		ScuolaSuperioreProfessionale.contributiLaboratorio = contributiLaboratorio;
	}
		
	public double getContributiRegionali() {
		return contributiRegionali;
	}

	public void setContributiRegionali(double contributiRegionali) {
		this.contributiRegionali = contributiRegionali;
	}
	
	//attributi

	public double getContributi() {
		return this.getnClassi()*contributiClasse+this.getnLaboratori()*contributiLaboratorio+contributiRegionali;
	}
		
	//toString
	
	public String toString() {
		return super.toString() + "\nContributi regionali: " + contributiRegionali;
	}
}
