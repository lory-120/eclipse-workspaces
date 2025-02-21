package model;

public class Persona implements Comparable<Persona> {

	private String nome;
	private String cognome;
	private int eta;
	
	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}


	/**
	 * Metodo che compara le eta dei due oggetti Persona.
	 * 
	 * @return
	 * 0 se età sono =
	 * 1 se thids.eta > p.eta
	 * -1 se this.eta < p.eta
	 */
	@Override
	public int compareTo(Persona p) {
		if(this.getEta() > p.getEta()) {
			return 1;
		} else if(this.getEta() < p.getEta()) {
			return -1;
		} else {
			return this.cognome.compareToIgnoreCase(p.getCognome());
		}
	}
	
	//public int compareTo(Persona )


	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}
	
}
