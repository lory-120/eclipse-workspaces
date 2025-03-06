package model.Paziente;

public class Paziente implements Comparable<Paziente> {

	//attributi
	private final String nome;
	private final String cognome;
	private int eta;
	
	
	//metodo costruttore
	public Paziente(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}
	public Paziente() {
		this.nome = "";
		this.cognome = "";
		this.eta = 0;
	}
	
	
	//metodi get/set
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	
	
	//metodo compareTo per l'implementazione di Comparable
	@Override
	public int compareTo(Paziente p) {
		if(this.cognome.compareTo(p.getCognome()) < 0) { //questo paziente è sotto
			return -1;
		} else if(this.nome.compareTo(p.getNome()) == 0) {
			if(this.cognome.compareTo(p.getCognome()) <= 0) { //questo paziente è sotto
				return -1;
			} else { //questo paziente è sopra
				return 1;
			}
		} else { //questo paziente è sopra
			return 1;
		}
	}


	//metodo toString
	@Override
	public String toString() {
		return "Paziente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}
	
}
