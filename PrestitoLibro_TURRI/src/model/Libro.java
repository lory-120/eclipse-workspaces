package model;

public class Libro {
	
	//attributi
	private final String titolo;
	private final String autore;
	private final int nPag;
	
	
	//metodo costruttore
	public Libro(String titolo, String autore, int nPag) {
		this.titolo = titolo;
		this.autore = autore;
		this.nPag = nPag;
	}

	
	//metodo get
	public String getTitolo() {
		return titolo;
	}
	public String getAutore() {
		return autore;
	}
	public int getnPag() {
		return nPag;
	}
	
	
	//metodo toString
	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", nPag=" + nPag + "]";
	}
	
}
