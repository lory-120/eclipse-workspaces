package model;

import java.util.Vector;

public class OldCoda {

	//attributo della coda
	private Vector<Object> coda;
	
	//metodo costruttore
	public OldCoda(int dimIniziale) {
		coda = new Vector<>(dimIniziale, 5);
	}
	
	
	//metodi della funzione
	
	//aggiungi un elemento alla fine della coda
	public void aggiungi(Object o) {
		coda.add(o);
	}
	
	//rimuovi un elemento dalla fine della coda (l'elemento 0 del Vector) e restituiscilo come Object
	public Object togli() throws ArrayIndexOutOfBoundsException {
		Object tmp = coda.firstElement();
		coda.remove(0);
		return tmp;
	}
	
	//quanti elementi ci sono nella coda
	public int size() {
		return coda.size();
	}
	
	//restituisce se è vuota o no
	public boolean isVuota() {
		return coda.isEmpty();
	}
	
	
}
