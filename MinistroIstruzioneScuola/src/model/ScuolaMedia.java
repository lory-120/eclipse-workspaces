package model;

public class ScuolaMedia extends Scuola {
	
	//attributi
	private double contributoStudente = 150.0;
	private double contributoSede = 9000.0;
	private double contributoLab = 1100.0;
	
	//metodo costruttore
	public ScuolaMedia(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab, double contributoStudente, double contributoSede, double contributoLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
		this.contributoStudente = contributoStudente;
		this.co
	}
	
	
}
