package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Rappresentazione extends Spettacolo {
	
	//attributi
	private GenereRappresentazione genere;
	
	public Rappresentazione(String nome, double prezzo, LocalDate data, LocalTime ora, Sala sala, GenereRappresentazione genere) {
		super(nome, prezzo, data, ora, sala);
		this.genere = genere;
	}

	//metodi get/set
	public GenereRappresentazione getGenere() {
		return genere;
	}
	public void setGenere(GenereRappresentazione genere) {
		this.genere = genere;
	}
	
}
