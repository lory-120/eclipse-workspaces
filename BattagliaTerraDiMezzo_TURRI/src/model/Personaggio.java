package model;

public class Personaggio {

	//attributi
	private String nome;
	private int exp;
	
	
	//metodo costruttore
	public Personaggio(String nome) {
		this.nome = nome;
		this.exp = 1;
	}

	
	//metodi get/set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		if(exp <= 10 && exp >= 1) {
			this.exp = exp;
		} else {
			throw new IllegalArgumentException("L'energia vitale dele essere comrpesa"
					+ "tra 1 e 10. Valore non accettato: " + exp);
		}
	}
	
	
	//metodi della funzione
	public void incrementaExp() {
		if(this.exp <= 10) this.exp++;
	}
	
	public void decrementaExp() {
		if(this.exp >= 1) this.exp--;
	}
	
	
}
