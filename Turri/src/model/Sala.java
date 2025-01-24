package model;

public class Sala {

	//attributi
	private int nPosti;
	private boolean isOccupata;
	private Spettacolo spettacoloAssegnato;
	
	//metodo costruttore
	public Sala(int nPosti) {
		this.nPosti = nPosti;
		this.isOccupata = false;
		this.spettacoloAssegnato = null;
	}

	//metodi get/set
	public int getNPosti() {
		return nPosti;
	}
	public void setNPosti(int nPosti) {
		this.nPosti = nPosti;
	}
	public void setOccupata(boolean isOccupata) {
		this.isOccupata = isOccupata;
	}
	public Spettacolo getSpettacoloAssegnato() {
		return spettacoloAssegnato;
	}
	public void setSpettacoloAssegnato(Spettacolo spettacoloAssegnato) {
		this.spettacoloAssegnato = spettacoloAssegnato;
	}

	//metodi is
	public boolean isOccupata() {
		return this.isOccupata;
	}
	
}
