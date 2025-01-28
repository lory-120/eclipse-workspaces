package model;

abstract public class ScuolaSuperiore extends Scuola {

	//attributi
	protected double contributoStudente = 0;
	protected double contributoSede = 0;
	protected double contributoLab = 0;
	protected double contributoClasse = 0;
	
	//metodi costruttori
	//costruttore generale
	public ScuolaSuperiore(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
	}
	
	//costruttore per i licei
	public ScuolaSuperiore(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab, double contributoStudente, double contributoLab, double contributoSede) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
		this.contributoStudente = contributoStudente;
		this.contributoLab = contributoLab;
		this.contributoSede = contributoSede;
	}
	
	//costruttore per i tecnici e i professionali
	public ScuolaSuperiore(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab, double contributoStudente, double contributoLab, double contributoSede, double contributoClasse) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
		this.contributoStudente = contributoStudente;
		this.contributoLab = contributoLab;
		this.contributoSede = contributoSede;
		this.contributoClasse = contributoClasse;
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
	public void setContributoSede(double contributoSede) {
		this.contributoSede = contributoSede;
	}
	public double getContributoLab() {
		return contributoLab;
	}
	public void setContributoLab(double contributoLab) {
		this.contributoLab = contributoLab;
	}
	public double getContributoClasse() {
		return contributoClasse;
	}
	public void setContributoClasse(double contributoClasse) {
		this.contributoClasse = contributoClasse;
	}
		
}
