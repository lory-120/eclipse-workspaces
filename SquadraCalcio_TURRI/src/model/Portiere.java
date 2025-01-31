package model;

public class Portiere extends Calciatore {
	
	//attributi
	private int golSubiti;
	private int rigoriSubiti;
	private int rigoriParati;
	
	//metodi costruttore
	public Portiere() {
		super(null, 0, 0, 0);
		this.golSubiti = 0;
		this.rigoriSubiti = 0;
		this.rigoriParati = 0;
	}
	
	public Portiere(String nome, int partiteGiocate, int golSegnati, long valoreInEuro, int golSubiti, int rigoriSubiti, int rigoriParati) {
		super(nome, partiteGiocate, golSegnati, valoreInEuro);
		this.golSubiti = golSubiti;
		this.rigoriSubiti = rigoriSubiti;
		this.rigoriParati = rigoriParati;
	}

	
	//metodi get/set
	public int getGolSubiti() {
		return golSubiti;
	}
	public void setGolSubiti(int golSubiti) {
		this.golSubiti = golSubiti;
	}
	public int getRigoriSubiti() {
		return rigoriSubiti;
	}
	public void setRigoriSubiti(int rigoriSubiti) {
		this.rigoriSubiti = rigoriSubiti;
	}
	public int getRigoriParati() {
		return rigoriParati;
	}
	public void setRigoriParati(int rigoriParati) {
		this.rigoriParati = rigoriParati;
	}

	
	//metodi della funzione
	public String stampaInfo() {
		String info = "";
		info += "PORTIERE: " + super.getNome() + "\n";
		info += "Ha subito " + Integer.toString(this.golSubiti) + " gol e " + Integer.toString(this.rigoriSubiti) + " rigori, mentre ha parato " + Integer.toString(this.rigoriParati) + " rigori.\n";
		info += "Ha giocato " + Integer.toString(super.getPartiteGiocate()) + " partite, e segnato " + Integer.toString(super.getGolSegnati()) + " gol.\n";
		info += "Il suo valore è " + Long.toString(super.getValoreInEuro()) + "€.\n";
		
		return info;
	}
	
	
	//metodo toString
	@Override
	public String toString() {
		return "Portiere [golSubiti=" + golSubiti + ", rigoriSubiti=" + rigoriSubiti + ", rigoriParati=" + rigoriParati
				+ ", toString()=" + super.toString() + "]";
	}
		
}
