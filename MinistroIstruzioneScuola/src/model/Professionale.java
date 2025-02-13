package model;

public class Professionale extends ScuolaSuperiore {
	
	//metodo costruttore
	public Professionale(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab, 0.0, 3000.0, 0.0, 2400.0);
	}
	
	public Professionale(String params[]) {
		super(params[1], params[2], Integer.parseInt(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]), Integer.parseInt(params[6]), 0.0, 3000.0, 0.0, 2400.0);
	}

	//metodo abstract della funzione
	public double getContributoTotale() {
		return (nClassi*contributoClasse) + (nLab*contributoLab);
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
		csv += this.getContributoStudente() + regex;
		csv += this.getContributoLab() + regex;
		csv += this.getContributoSede() + regex;
		csv += this.getContributoClasse() + regex;
		return csv;
	}

	//metodo toString
	@Override
	public String toString() {
		return "Professionale [contributoStudente=" + contributoStudente + ", contributoSede=" + contributoSede
				+ ", contributoLab=" + contributoLab + ", contributoClasse=" + contributoClasse + ", codice=" + codice
				+ ", nome=" + nome + ", citta=" + citta + ", nStudenti=" + nStudenti + ", nClassi=" + nClassi
				+ ", nSediAggiuntive=" + nSediAggiuntive + ", nLab=" + nLab + "]";
	}
	
}
