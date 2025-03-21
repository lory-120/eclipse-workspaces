package model;

public class OldLista {

	//attributi
	private OldNodo head; //la testa della lista
	//private Nodo tail; //la coda della lista
	
	
	//metodi costruttore
	public OldLista() {
		this.head = new OldNodo();
	}
	
	
	//metodi della funzione
	public void inserisciOrdinato(int n) {
		//creo il nuovo nodo da aggiungere
		OldNodo newNode = new OldNodo(n, null);
		
		//se la lista è vuota o si deve mettere n prima del primo nodo
		if(head.getNext() == null || n < head.getNext().getData()) {
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			return;
		}
		
		OldNodo current = head.getNext();	
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
		
		OldNodo tmp = head.getNext();
		s += "HEAD -> ";
		
		while(tmp != null) {
			s += Integer.toString(tmp.getData()) + " ";
			tmp = tmp.getNext();
		}
		
		s += "-> TAIL";
		
		return s;
	}
	
}
