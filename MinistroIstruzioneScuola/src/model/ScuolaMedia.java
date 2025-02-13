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
	
	public ScuolaMedia(String params[]) {
		super(params[1], params[2], Integer.parseInt(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]), Integer.parseInt(params[6]));
		this.contributoStudente = Double.parseDouble(params[7]);
		this.contributoSede = Double.parseDouble(params[8]);
		this.contributoLab = Double.parseDouble(params[9]);
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
	
	
	protected String getCSVString() {
		char regex = ';';
		String csv = this.getClass().getSimpleName() + regex;
		csv += nome + regex;
		csv += citta + regex;
		csv += Integer.toString(nStudenti) + regex;
		csv += Integer.toString(nClassi) + regex;
		csv += Integer.toString(nSediAggiuntive) + regex;
		csv += Integer.toString(nLab) + regex;
		csv += Double.toString(contributoStudente) + regex;
		csv += Double.toString(contributoSede) + regex;
		csv += Double.toString(contributoLab) + regex;
		return csv;
	}

	@Override
	public String toString() {
		return "ScuolaMedia [contributoStudente=" + contributoStudente + ", contributoSede=" + contributoSede
				+ ", contributoLab=" + contributoLab + ", codice=" + codice + ", nome=" + nome + ", citta=" + citta
				+ ", nStudenti=" + nStudenti + ", nClassi=" + nClassi + ", nSediAggiuntive=" + nSediAggiuntive
				+ ", nLab=" + nLab + "]";
	}
	
}