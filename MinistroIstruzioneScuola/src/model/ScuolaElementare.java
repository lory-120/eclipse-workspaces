package model;

public class ScuolaElementare extends Scuola {

	//attributi
	private double contributoStudente;
	private double contributoSede;
	
	//metodo costruttore con super()
	public ScuolaElementare(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab, int contributoStudente, int contributoSede) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
		this.contributoStudente = contributoStudente;
		this.contributoSede = contributoSede;
	}

	//metodi get/set
	public double getContributoStudente() {
		return contributoStudente;
	}
	public void setContributoStudente(double contributoStudente) {
		this.contributoStudente = contributoStudente;
	}
	public double getContributoSede() {
		return contributoSede;
	}
	
	public void setContributoSede(double contibutoSede) {
		this.contributoSede = contibutoSede;
	}
	
	
	//metodi della funzione
	public double getContributoTotale() {
		return (nStudenti*contributoStudente)+(nSediAggiuntive*contributoSede);
	}
	

	//metodo toString
	@Override
	public String toString() {
		return "ScuolaElementare [contributoStudente=" + contributoStudente + ", contibutoSede=" + contributoSede
				+ ", codice=" + codice + ", nome=" + nome + ", citta=" + citta + ", nStudenti=" + nStudenti
				+ ", nClassi=" + nClassi + ", nSediAggiuntive=" + nSediAggiuntive + ", nLab=" + nLab + "]";
	}

}
