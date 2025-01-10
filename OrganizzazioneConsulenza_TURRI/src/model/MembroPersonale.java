package model;

/**
 * Classe per i membri del personale, padre delle classi Dirigente, Funzionario, Tecnico.
 * Contiene i dati generali di un membro del personale.
 */

public class MembroPersonale {
	//attributi visibili solo all'interno del package
	protected String nome;
	protected String cognome;
	protected int codice;
	protected int annoInizio;
	
	//metodo costruttore
	public MembroPersonale(String nome, String cognome, int annoInizio) {
		this.nome = nome;
		this.cognome = cognome;
		this.codice = GeneratoreCodice.generaCodice();
		this.annoInizio = annoInizio;
	}

	//metodi get/set
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getCodice() {
		return codice;
	}

	public int getAnnoInizio() {
		return annoInizio;
	}

	
	//metodo toString()
	@Override
	public String toString() {
		return "MembroPersonale [nome=" + nome + ", cognome=" + cognome + ", codice=" + codice + ", annoInizio="
				+ annoInizio + "]";
	}
	
}
