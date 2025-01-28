package model;

public class Liceo extends ScuolaSuperiore {
	
	//metodo costruttore
	public Liceo(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		super(nome, citta, nStudenti, nClassi, nSediAggiuntive, nLab, 150.0, 1100.0, 0);
	}
	
	//metodo abstract della funzione
	public double getContributoTotale() {
		return (nStudenti*contributoStudente) + (nLab*contributoLab);
	}

	//metodo toString
	@Override
	public String toString() {
		return "Liceo [contributoStudente=" + contributoStudente + ", contributoSede=" + contributoSede
				+ ", contributoLab=" + contributoLab + ", codice=" + codice + ", nome=" + nome + ", citta=" + citta
				+ ", nStudenti=" + nStudenti + ", nClassi=" + nClassi + ", nSediAggiuntive=" + nSediAggiuntive
				+ ", nLab=" + nLab + "]";
	}
	
}
