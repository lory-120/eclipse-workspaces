package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Proiezione extends Spettacolo {
	
	//attributi
	private int durataMinuti;
	
	public Proiezione(String nome, double prezzo, LocalDate data, LocalTime ora, Sala sala, int durataMinuti) {
		super(nome, prezzo, data, ora, sala);
		this.durataMinuti = durataMinuti;
	}

	//metodi get/set
	public int getDurataMinuti() {
		return durataMinuti;
	}
	public void setDurataMinuti(int durataMinuti) {
		this.durataMinuti = durataMinuti;
	}
	
}
