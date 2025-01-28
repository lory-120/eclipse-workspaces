package model;

public class Tecnico extends ScuolaSuperiore {

	//metodo costruttore
	public Tecnico(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab, 0.0, 6000.0, 0, 3500.0);
	}
	
	//metodo abstract della funzione
	public double getContributoTotale() {
		return (nClassi*contributoClasse) + (nLab*contributoLab);
	}

	//metodo toString
	@Override
	public String toString() {
		return "Tecnico [contributoStudente=" + contributoStudente + ", contributoSede=" + contributoSede
				+ ", contributoLab=" + contributoLab + ", contributoClasse=" + contributoClasse + ", codice=" + codice
				+ ", nome=" + nome + ", citta=" + citta + ", nStudenti=" + nStudenti + ", nClassi=" + nClassi
				+ ", nSediAggiuntive=" + nSediAggiuntive + ", nLab=" + nLab + "]";
	}
	
}
