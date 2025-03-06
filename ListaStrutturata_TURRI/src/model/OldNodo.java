package model;

public class OldNodo {

	//attributi
	private int data; //il dato che il nodo contiene
	private OldNodo next; //il (puntatore al) nodo successivo
	
	//metodi costruttori
	public OldNodo() {
		this.data = 0;
		this.next = null;
	}
	public OldNodo(int data, OldNodo next) {
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
	public OldNodo getNext() {
		return next;
	}
	public void setNext(OldNodo next) {
		this.next = next;
	}

}
