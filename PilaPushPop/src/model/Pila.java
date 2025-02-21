package model;

import java.util.Vector;

public class Pila {

	//attributo della pila
	private Vector<Object>pila;
	private int index;
	
	public Pila(int dimIniziale) {
		pila = new Vector<>(dimIniziale, 5);
		this.index = 0;
	}
	
	//push, pop, top, isempty, size
	//metodi della funzione
	public void push(Object o) {
		pila.add(o);
		index++;
	}
	
	public Object pop() throws ArrayIndexOutOfBoundsException {
		Object tmp = pila.lastElement();
		pila.remove(index-1);
		index--;
		return tmp;
	}
	
	public Object top() throws ArrayIndexOutOfBoundsException {
		return pila.lastElement();
	}
	
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	
	public int size() {
		return pila.size();
	}
	
}
