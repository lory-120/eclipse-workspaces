package model.lista;

public class Nodo<T extends Comparable<T>> {

	//attributi
	private T data; //il dato che il nodo contiene
	private Nodo<T> next; //il (puntatore al) nodo successivo
	
	//metodi costruttori
	public Nodo() {
		this.data = null;
		this.next = null;
	}
	public Nodo(T data) {
		this.data = data;
	}
	public Nodo(T data, Nodo<T> next) {
		this.data = data;
		this.next = next;
	}
	

	//metodi get/set
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Nodo<T> getNext() {
		return next;
	}
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	
}
