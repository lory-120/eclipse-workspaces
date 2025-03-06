package model;

//import model.lista.Nodo;

public class Lista<T extends Comparable<T>> {

	//attributi
	private Nodo<T> head; //la testa della lista
	private Nodo<T> tail; //la coda della lista
	
	
	//metodi costruttore
	public Lista() {
		this.head = new Nodo<T>();
		this.tail = null;
		this.head.setNext(tail);
	}
	
	
	//metodi della funzione
	
	//inserisce il dato in un nodo nella testa della lista
	public boolean inserisciInTesta(T data) {
		//creo il nuovo nodo da aggiungere
		Nodo<T> newNode = new Nodo<>(data);
		
		if(head.getNext() == null) { //se la lista è vuota
			head.setNext(newNode);
			tail = newNode;
		} else { //se invece non è vuota
			newNode.setNext(head.getNext());
			head.setNext(newNode);
		}
		return true;
	}
	
	
	public boolean inserisciOrdinato(T data) {
		//creo il nuovo nodo da aggiungere
		Nodo<T> newNode = new Nodo<>(data);
		
		//se la lista è vuota o si deve mettere n prima del primo nodo
		if(head.getNext() == null || data.compareTo(head.getNext().getData()) < 0) {
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			
			if(tail == null) tail = newNode; //se la lista era vuota
			
			return true;
		}
		
		Nodo<T> current = head.getNext();	
		//per continuare il ciclo, il dato tra i due nodi (prevoius e next) deve essere compreso 
		while(current.getNext() != null && current.getNext().getData().compareTo(data) > 0) {
			current = current.getNext(); //scorri in avanti di 1 nodo
		}
		
		//quando è uscito dal ciclo, metti il nodo tra i due
    	newNode.setNext(current.getNext());
	    current.setNext(newNode);
	    
	    //se l'inserimento è avvenuto nella coda, aggiorna tail
	    if(newNode.getNext() == null) tail = newNode;
	    
	    return true;
		
	}
	
	
	//inserisci il dato in coda alla lista
	public boolean inserisciInCoda(T data) {
		Nodo<T> newNodo = new Nodo<>(data, null);
		
		if(head.getNext() == null) { //se la lista è vuota
			tail = newNodo;
			head.setNext(tail);
			return true;
		}
		if(tail.getData() == null) { //se il dato di tail è null
			tail.setData(data);
			return true;
		}
		
		//se si sono superate le casistiche, si procede normalmente
		tail.setNext(newNodo);
		tail = newNodo;
		return true;
	}
	
	
	//ritorna il numero di elementi nella lista
	public long size() {
		int size = 0;
		
		if(this.isEmpty()) return 0;
		
		Nodo<T> tmp = head.getNext();
		while(tmp.getNext() != null) {
			tmp = tmp.getNext();
			size++;
		}
		
		return size++;
	}
	
	
	//metodo isEmpty
	public boolean isEmpty() {
		//logicamente, se la testa punta a null, la lista non ha niente
		return (this.head.getNext() == null);
	}
	
	
	
	public String toStringLista() {
		String s = "";
		
		if(this.isEmpty()) return "Lista vuota. (HEAD -> TAIL)";
		
		Nodo<T> tmp = head.getNext();
		s += "HEAD -> ";
		
		while(tmp != null) {
			s += tmp.toString() + " ";
			tmp = tmp.getNext();
		}
		
		s += "-> TAIL";
		
		return s;
	}
	
}
