package model;

import model.Lista.*;
import model.Pratica.Pratica;
public class GestionePratiche {

	private Lista<Pratica> pratiche;
	
	public GestionePratiche() {
		this.pratiche = new Lista<>();
	}
	
	public void addPratica(Pratica p) {
		pratiche.addInTesta(p);
	}
	
	public Pratica prendiInCarico() {
		return pratiche.getFromTail();
	}
	
	public Pratica searchCodice(int srcCodice) {
		pratiche.g
	}
	
}
