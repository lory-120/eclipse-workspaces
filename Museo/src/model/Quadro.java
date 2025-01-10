package model;

public class Quadro {
	private int anno;
	private String nome;
	private String autore;
	private String descrizione;
	
	public Quadro(int anno, String nome, String autore, String descrizione) {
		this.anno = anno;
		this.nome = nome;
		this.autore = autore;
		this.descrizione = descrizione; 
	}
	
	//metodi get
	public int getAnno() {
		return this.anno;
	}
	public String getNome() {
		return this.nome;
	}
	public String getAutore() {
		return this.autore;
	}
	public String getDescrizione() {
		return this.descrizione;
	}
	
	//metodi set
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	//metodo override toString()
	@Override
	public String toString() {
		return
			"Nome: " + this.nome +
			"\nAutore: " + this.autore +
			"\nAnno: " + this.anno +
			"\nDescrizione: " + this.descrizione;
	}
}
