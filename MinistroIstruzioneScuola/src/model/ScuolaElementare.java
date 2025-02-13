package model;

public class ScuolaElementare extends Scuola {

	//attributi
	private double contributoStudente = 125.0;
	private double contributoSede = 9000.0;
	
	//metodo costruttore con super()
	public ScuolaElementare(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab, int contributoStudente, int contributoSede) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
		this.contributoStudente = contributoStudente;
		this.contributoSede = contributoSede;
	}
	
	public ScuolaElementare(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab);
	}
	
	public ScuolaElementare(String params[]) {
		super(params[1], params[2], Integer.parseInt(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]), Integer.parseInt(params[6]));
		this.contributoStudente = Double.parseDouble(params[7]);
		this.contributoSede = Double.parseDouble(params[8]);
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
	
	public double getContributoTotale() {
		return (nStudenti*contributoStudente) + (nSediAggiuntive*contributoSede);
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
		return csv;
	}

	//metodo toString
	@Override
	public String toString() {
		return "ScuolaElementare [contributoStudente=" + contributoStudente + ", contibutoSede=" + contributoSede
				+ ", codice=" + codice + ", nome=" + nome + ", citta=" + citta + ", nStudenti=" + nStudenti
				+ ", nClassi=" + nClassi + ", nSediAggiuntive=" + nSediAggiuntive + ", nLab=" + nLab + "]";
	}

}
