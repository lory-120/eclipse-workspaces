package model;

public class Nodo {

	//attributi
	private Paziente data; //il dato che il nodo contiene
	private Nodo next; //il (puntatore al) nodo successivo
	
	//metodi costruttori
	public Nodo() {
		this.data = null;
		this.next = null;
	}
	public Nodo(Paziente data, Nodo next) {
		this.data = data;
		this.next = next;
	}
	public Nodo(Paziente paziente) {
		this.data = paziente;
	}

	//metodi get/set
	public Paziente getData() {
		return data;
	}
	public void setData(Paziente data) {
		this.data = data;
	}
	public Nodo getNext() {
		return next;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}

}
