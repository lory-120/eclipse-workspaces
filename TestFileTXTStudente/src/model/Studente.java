package model;
import java.io.*;

@SuppressWarnings("serial")
public class Studente implements Serializable {
	//attributi
	private String nome;
	private String cognome;
	private int eta;
	private String cf;
	
	//metodo costruttore
	public Studente(String nome, String cognome, int eta, String cf) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.cf = cf;
	}
	public Studente() {
		this.nome = null;
		this.cognome = null;
		this.eta = -1;
		this.cf = null;
	}

	//metodi get/set
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
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "Studente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", cf=" + cf + "]";
	}
	
	//per verificare se i codici fiscali sono uguali
	public int compareTo(Studente s) {
        return this.cf.compareTo(s.cf);
    }
	
}
