package model;

public abstract class Scuola {
	
	//attributi
	
	private String codice;
	private String denominazione;
	private String indirizzo;
	private String citta;
	private int nStudenti;
	private int nClassi;
	private int nSedi;
	private int nLaboratori;
	
	//metodi
	//metodo costruttore
	
	public Scuola(String codice, String denominazione, String indirizzo, String citta, int nStudenti, int nClassi, int nSedi, int nLaboratori) {
		this.codice = codice;
		this.denominazione = denominazione;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.nStudenti = nStudenti;
		this.nClassi = nClassi;
		this.nSedi = nSedi;
		this.nLaboratori = nLaboratori;
	}
	
	//get e set

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getnStudenti() {
		return nStudenti;
	}

	public void setnStudenti(int nStudenti) {
		this.nStudenti = nStudenti;
	}

	public int getnClassi() {
		return nClassi;
	}

	public void setnClassi(int nClassi) {
		this.nClassi = nClassi;
	}

	public int getnSedi() {
		return nSedi;
	}

	public void setnSedi(int nSedi) {
		this.nSedi = nSedi;
	}

	public int getnLaboratori() {
		return nLaboratori;
	}

	public void setnLaboratori(int nLaboratori) {
		this.nLaboratori = nLaboratori;
	}
	
	//altri metodi
	
	public abstract double getContributi();
	
	//toString
	
	public String toString() {
		return this.getClass().getSimpleName() + "\nCodice: " + codice + "\nDenominazione: " + denominazione + "\nIndirizzo: " + indirizzo + "\nCittà: "
				+ citta + "\nNumero di studenti: " + nStudenti + "\nNumero di classi: " + nClassi + "\nNumero di sedi: " + nSedi + "\nNumero di laboratori: "
				+ nLaboratori + "\nContributi: " + this.getContributi();
	}
	
}
