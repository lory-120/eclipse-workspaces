package model.Eroe;

import model.Personaggio;

public class Eroe extends Personaggio {

	//attributi
	private int energiaVitale;
	
	//metodo costruttore
	public Eroe(String nome, int energiaVitale) {
		super(nome);
		this.energiaVitale = energiaVitale;
	}

	//metodi della funzione
	public int getEnergiaVitale() {
		return energiaVitale;
	}
	
	public void setEnergiaVitale(int energiaVitale) {
		if(energiaVitale <=10 && energiaVitale >= 1) {
			this.energiaVitale = energiaVitale;
		} else {
			throw new IllegalArgumentException("L'energia vitale dele essere comrpesa"
					+ " tra 1 e 10. Valore non accettato: " + energiaVitale);
		}
	}
	
	public int getForza() {
		return ((50*this.energiaVitale)+(50*super.getExp()));
	}
	
}
