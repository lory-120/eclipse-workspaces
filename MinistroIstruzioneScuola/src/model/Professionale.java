package model;

public class Professionale extends ScuolaSuperiore {
	
	//metodo costruttore
	public Professionale(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab, 0.0, 3000.0, 0.0, 2400.0);
	}

	//metodo abstract della funzione
	public double getContributoTotale() {
		return (nClassi*contributoClasse) + (nLab*contributoLab);
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
