package model;

public class Lista {

	//attributi
	private Nodo head; //la testa della lista
	//private Nodo tail; //la coda della lista
	private int nElementi
	
	
	//metodi costruttore
	public Lista() {
		this.head = null;
		this.nElementi = 0;
	}
	
	
	//metodi della funzione
	public boolean inserisciInTesta(Paziente p) {
		Nodo newNode = new Nodo(p);
		newNode.setNext(this.head);
		this.head = newNode;
		nElementi++;
		
		return true;
		
	}
	
	
	
	
	public void inserisciOrdinato(Paziente p) {
		//creo il nuovo nodo da aggiungere
		Nodo newNode = new Nodo(p, null);
		
		//se la lista è vuota o si deve mettere n prima del primo nodo
		if(head.getNext() == null || n < head.getNext().getData()) {
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			return;
		}
		
		Nodo current = head.getNext();	
		//per continuare il ciclo, il dato tra i due nodi (prevoius e next) deve essere compreso 
		while(current.getNext() != null && current.getNext().getData() < n) {
			current = current.getNext(); //scorri in avanti di 1 nodo
		}
		
		//quando è uscito dal ciclo, metti il nodo tra i due
	    if(current.getNext() == null) {
	    	current.setNext(newNode);
	    } else {
	    	newNode.setNext(current.getNext());
		    current.setNext(newNode);
	    }
		
	}
	
	
	public String getStringLista() {
		String s = "";
		
		if(head.getNext() == null) {
			return "Lista vuota. (HEAD -> TAIL)";
		}
		
		Nodo tmp = head.getNext();
		s += "HEAD -> ";
		
		while(tmp != null) {
			s += Integer.toString(tmp.getData()) + " ";
			tmp = tmp.getNext();
		}
		
		s += "-> TAIL";
		
		return s;
	}
	
}
