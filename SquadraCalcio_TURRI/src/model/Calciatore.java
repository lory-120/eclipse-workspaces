package model;

public class Calciatore {

	//attributi
	private String nome;
	private int partiteGiocate;
	private int golSegnati;
	private long valoreInEuro;
	
	
	//metodi costruttore
	public Calciatore() {
		this.nome = null;
		this.partiteGiocate = 0;
		this.golSegnati = 0;
		this.valoreInEuro = 0;
	}
	
	public Calciatore(String nome, int partiteGiocate, int golSegnati, long valoreInEuro) {
		this.nome = nome;
		this.partiteGiocate = partiteGiocate;
		this.golSegnati = golSegnati;
		this.valoreInEuro = valoreInEuro;
	}

	
	//metodi get/set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPartiteGiocate() {
		return partiteGiocate;
	}
	public void setPartiteGiocate(int partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}
	public int getGolSegnati() {
		return golSegnati;
	}
	public void setGolSegnati(int golSegnati) {
		this.golSegnati = golSegnati;
	}
	public long getValoreInEuro() {
		return valoreInEuro;
	}
	public void setValoreInEuro(long valoreInEuro) {
		this.valoreInEuro = valoreInEuro;
	}	
	
	
	//metodi della funzione
	public String stampaInfo() {
		String info = "";
		info += "CALCIATORE: " + this.nome + "\n";
		info += "Ha giocato " + Integer.toString(this.partiteGiocate) + " partite e segnato " + Integer.toString(this.golSegnati) + " gol.\n";
		info += "Il suo valore è " + Long.toString(this.valoreInEuro) + "€.\n";
		return info;
	}
	
	public double mediaGol() {
		return (golSegnati/partiteGiocate);
	}
	
	public void addGol(int golAggiunti) {
		this.golSegnati += golAggiunti;
	}
	public void addPartite(int partiteAggiunte) {
		this.partiteGiocate += partiteAggiunte;
	}

	
	//metodo toString
	@Override
	public String toString() {
		return "Calciatore [nome=" + nome + ", partiteGiocate=" + partiteGiocate + ", golSegnati=" + golSegnati
				+ ", valoreInEuro=" + valoreInEuro + "]";
	}	
	
}
