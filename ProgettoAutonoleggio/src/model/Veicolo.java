package model;

public class Veicolo {
	private final int CODICE;
	private final String TARGA;
	private final String MARCA;
	private final String MODELLO;
	private final int N_POSTI;
	
	public Veicolo(String targa, String marca, String modello, int nPosti) {
		this.CODICE = GeneratoreCodice.generaCodice();
		this.TARGA = targa;
		this.MARCA = marca;
		this.MODELLO = modello;
		this.N_POSTI = nPosti;
	}

	//metodi get
	public int getCODICE() {
		return CODICE;
	}

	public String getTARGA() {
		return TARGA;
	}

	public String getMARCA() {
		return MARCA;
	}

	public String getMODELLO() {
		return MODELLO;
	}

	public int getN_POSTI() {
		return N_POSTI;
	}

	@Override
	public String toString() {
		return " --- Veicolo --- "
			+ "\nCodice: " + CODICE
			+ "\nTarga: " + TARGA
			+ "\nMarca: " + MARCA
			+ "\nModello: " + MODELLO
			+ "\nN° posti: " + N_POSTI;
	}
	
	
	
	
	
}
