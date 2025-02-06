package model;

public abstract class ScuolaSuperiore extends Scuola {

	public ScuolaSuperiore(String codice, String denominazione, String indirizzo, String citta, int nStudenti,int nClassi, int nSedi, int nLaboratori) {
		super(codice, denominazione, indirizzo, citta, nStudenti, nClassi, nSedi, nLaboratori);
	}

	public String toString() {
		return super.toString();
	}
	
}
