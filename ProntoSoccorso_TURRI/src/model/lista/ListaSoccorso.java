package model.lista;

//import model.lista.Nodo;
import model.Paziente.*;

public abstract class ListaSoccorso<T extends Comparable<T>> {

	//attributi
	private Nodo<T> head; //la testa della lista
	private Nodo<T> tail; //la coda della lista
	
	
	//metodi costruttore
	public ListaSoccorso() {
		this.head = new Nodo<T>();
		this.tail = null;
		this.head.setNext(tail);
	}
	
	
	//metodi get/set
	public Nodo<T> getHead() {
		return head;
	}
	public void setHead(Nodo<T> head) {
		this.head = head;
	}
	public Nodo<T> getTail() {
		return tail;
	}
	public void setTail(Nodo<T> tail) {
		this.tail = tail;
	}

	
	//metodi della funzione	

	//inserisce il dato in un nodo nella testa della lista
	public boolean addInTesta(T data) {
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
	
	//rimuove il dato nella testa della lista
	public boolean removeInTesta() {
		if(isEmpty()) return true;
		
		head.setNext(head.getNext().getNext());
		return true;
	}
	
	
	public boolean addOrdinato(T data) {
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
	public boolean addInCoda(T data) {
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
	
	//rimuove il dato dalla coda della lista
	public boolean removeInCoda() {
		if(isEmpty()) return true; //se la lista è vuota
		
		Nodo<T> tmp = head; //nodo temporaneo che parte dalla testa
		
		if(tmp.getNext().getNext() == null) { //se c'è solo un elemento (HEAD -> TAIL)
			tail.setData(null);
			return true;
		}
		
		while(tmp.getNext().getNext() != null) { //scorri tra i nodi e trova il nodo prima della coda
			tmp = tmp.getNext();
		}
		tmp.setNext(null);
		tail = tmp;
		
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
	
	
	
	
	
	//***METODI TEMPORANEI CHE NON FANNO PARTE DELLA CLASSE LISTA***
	abstract public void inserisciPaziente(Paziente p);
	abstract public Paziente soccorriPaziente();
	abstract public int[] getPazientiInAttesa();
	abstract public boolean removePazienteSpecifico(String nome, String cognome);
	
}
