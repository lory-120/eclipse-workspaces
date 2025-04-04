package model;

public class Brano {

	//attributi
	private final String TITOLO;
	private final int DURATA;
	private final String ARTISTA;
	private final Genere GENERE;
	private boolean preferito;
	
	//metodi costruttori
	public Brano() {
		this.TITOLO = "";
		this.DURATA = -1;
		this.ARTISTA = "";
		this.GENERE = null;
		this.preferito = false;
	}
	public Brano(String titolo, int durata, String artista, Genere genere) {
		this.TITOLO = titolo;
		this.DURATA = durata;
		this.ARTISTA = artista;
		this.GENERE = genere;
		this.preferito = false;
	}
	
	//metodi get/set
	public boolean isPreferito() {
		return preferito;
	}
	public void setPreferito(boolean preferito) {
		this.preferito = preferito;
	}
	public String getTITOLO() {
		return TITOLO;
	}
	public int getDURATA() {
		return DURATA;
	}
	public String getARTISTA() {
		return ARTISTA;
	}
	public Genere getGENERE() {
		return GENERE;
	}
	
	//metodo toString
	@Override
	public String toString() {
		return "Brano [TITOLO=" + TITOLO + ", DURATA=" + DURATA + ", ARTISTA=" + ARTISTA + ", GENERE=" + GENERE
				+ ", preferito=" + preferito + "]";
	}
	
}
