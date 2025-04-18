package model;

public class Nodo<T extends Comparable<T>> {
	
	//attributi
	private T data; //il dato del nodo
	private Nodo<T> sx; //il nodo di sinistra
	private Nodo<T> dx; //il nodo di destra
	
	
	//metodi costruttori
	public Nodo() {
		this.sx = null;
		this.dx = null;
	}
	public Nodo(T data) {
		this();
		this.setData(data);
	}

	
	//metodi get/set
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Nodo<T> getSx() {
		return sx;
	}

	public void setSx(Nodo<T> sx) {
		this.sx = sx;
	}

	public Nodo<T> getDx() {
		return dx;
	}

	public void setDx(Nodo<T> dx) {
		this.dx = dx;
	}
	
	
	/*
	 * Implementazione di compareTo per confrontare i dati.
	 * Nota bene che il metodo usa il compareTo della classe di T, che è scritta da un'altra parte.
	 */
    public int compareTo(T o) {
        if (data == null) throw new NullPointerException("Non è possibile '" + o.getClass().getSimpleName() + "' con null.");
        return data.compareTo(o);
    }
    
    //metodo toString
	@Override
	public String toString() {
		return "Nodo [data=" + data + "]";
	}
    
}
