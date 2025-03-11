package model;

import ListaStrutturata.*;

public class Coda<T extends Comparable<T>> {

	//attributi
	private Lista<T> l;
	
	//metodo costruttore
	public Coda() {
		this.l = new Lista<>();
	}
	
	//metodi della funzione
	//metodi aggiungi, togli, size, isVuota
	public void aggiungi(T data) {
		l.inserisciInTesta(data);
	}
	
	public T togli() {
		return l.getFromTail();
	}
	
	public int size() {
		return (int)l.size();
	}
	
	public boolean isVuota() {
		return l.isEmpty();
	}
	
}
