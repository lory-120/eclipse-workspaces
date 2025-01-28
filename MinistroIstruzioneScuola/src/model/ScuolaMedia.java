package model;

public class ScuolaMedia extends Scuola {
	
	//attributi
	private double contributoStudente = 150.0;
	private double contributoSede = 9000.0;
	private double contributoLab = 1100.0;
	
	//metodo costruttore
	public ScuolaMedia(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
	}
	
	
	//metodi get/set
	public double getContributoTotale() {
		return (nStudenti*contributoStudente) + (nLab*contributoLab) + (nSediAggiuntive*contributoSede);
	}

	public double getContributoStudente() {
		return contributoStudente;
	}
	public void setContributoStudente(double contributoStudente) {
		this.contributoStudente = contributoStudente;
	}
	public double getContributoSede() {
		return contributoSede;
	}
	public void setContributoSede(double contributoSede) {
		this.contributoSede = contributoSede;
	}
	public double getContributoLab() {
		return contributoLab;
	}
	public void setContributoLab(double contributoLab) {
		this.contributoLab = contributoLab;
	}	
	
}