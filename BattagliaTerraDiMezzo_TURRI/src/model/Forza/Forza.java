package model.Forza;

import model.Personaggio;

abstract public class Forza extends Personaggio {

	public Forza(String nome) {
		super(nome);
	}

	abstract public int getForza();
	
}
