package model;

public class ScuolaSuperioreTecnico extends ScuolaSuperiore {
	
	//attributi
	
	private static double contributiClasse=3500;
		private static double contributiLaboratorio=6000;
	
	//metodi
	//metodo costruttore
	
	public ScuolaSuperioreTecnico(String codice, String denominazione, String indirizzo, String citta, int nStudenti, int nClassi,int nSedi, int nLaboratori) {
		super(codice, denominazione, indirizzo, citta, nStudenti, nClassi, nSedi, nLaboratori);
	}
	
	//get e set
	
	public static double getContributiStudente() {
		return contributiClasse;
	}

	public static void setContributiStudente(double contributiStudente) {
		ScuolaSuperioreTecnico.contributiClasse = contributiStudente;
	}
	public static double getContributiLaboratorio() {
		return contributiLaboratorio;
	}

	public static void setContributiLaboratorio(double contributiLaboratorio) {
		ScuolaSuperioreTecnico.contributiLaboratorio = contributiLaboratorio;
	}

	//altri metodi
		
	public double getContributi() {
		return this.getnClassi()*contributiClasse+this.getnLaboratori()*contributiLaboratorio;
	}
		
	//toString
	
	public String toString() {
		return super.toString();
	}
}
