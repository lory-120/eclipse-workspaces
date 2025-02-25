package model;

public class Nodo {

	//attributi
	private int data; //il dato che il nodo contiene
	private Nodo next; //il (puntatore al) nodo successivo
	
	//metodi costruttori
	public Nodo() {
		this.data = 0;
		this.next = null;
	}
	public Nodo(int data, Nodo next) {
		this.data = data;
		this.next = next;
	}

	//metodi get/set
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Nodo getNext() {
		return next;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}

}
