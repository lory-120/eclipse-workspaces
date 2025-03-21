package model.Pratica;

import model.CodeGenerator;

public class Pratica implements Comparable<Pratica> {

	private int codice;
	private String nome;
	private String cognome;
	private String descrizione;
	
	//metodi costruttori
	public Pratica(String nome, String cognome, String descrizione) {
		this.codice = CodeGenerator.getNewCode();
		this.nome = nome;
		this.cognome = cognome;
		this.descrizione = descrizione;
	}
	public Pratica() {
		this.codice = CodeGenerator.getNewCode();
		this.nome = "";
		this.cognome = "";
		this.descrizione = "";
	}

	//metodi get/set
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int compareTo(Pratica p) {
		if(this.cognome.compareTo(p.getCognome()) < 0) {
			return -1;
		} else if(this.cognome.compareTo(p.getCognome()) > 0) {
			return 1;
		} else {
			if(this.nome.compareTo(p.getNome()) > 0) {
				return 1;
			} else if(this.nome.compareTo(p.getNome()) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	
}
