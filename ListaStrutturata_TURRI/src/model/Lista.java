package model;

public class Lista<T extends Comparable<T>> {

    // attributi
    private Nodo<T> head; // la testa della lista
    private Nodo<T> tail; // la coda della lista
    
    // metodi costruttore
    public Lista() {
        this.head = null;
        this.tail = null;
    }
    
    // inserisce il dato in un nodo nella testa della lista
    public boolean inserisciInTesta(T data) {
        Nodo<T> newNode = new Nodo<T>(data);
        
        if(head == null) { // se la lista è vuota
            head = newNode;
            tail = newNode;
        } else { // se invece non è vuota
            newNode.setNext(head);
            head = newNode;
        }
        return true;
    }
    
    public boolean inserisciOrdinatoCrescente(T data) {
        Nodo<T> newNode = new Nodo<T>(data);
        
        // se la lista è vuota o si deve mettere n prima del primo nodo
        if(head == null || data.compareTo(head.getData()) < 0) {
            newNode.setNext(head);
            head = newNode;
            
            if(tail == null) tail = newNode; // se la lista era vuota
            
            return true;
        }
        
        Nodo<T> current = head;    
        // per continuare il ciclo, il dato tra i due nodi (previous e next) deve essere compreso 
        while(current.getNext() != null && current.getNext().getData().compareTo(data) < 0) {
            current = current.getNext(); // scorri in avanti di 1 nodo
        }
        
        // quando è uscito dal ciclo, metti il nodo tra i due
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        // se l'inserimento è avvenuto nella coda, aggiorna tail
        if(newNode.getNext() == null) tail = newNode;
        
        return true;
    }
    
    public boolean inserisciOrdinatoDecrescente(T data) {
    	Nodo<T> newNode = new Nodo<T>(data);
        
        // se la lista è vuota o si deve mettere n prima del primo nodo
        if(head == null || data.compareTo(head.getData()) > 0) {
            newNode.setNext(head);
            head = newNode;
            
            if(tail == null) tail = newNode; // se la lista era vuota
            
            return true;
        }
        
        Nodo<T> current = head;    
        // per continuare il ciclo, il dato tra i due nodi (previous e next) deve essere compreso 
        while(current.getNext() != null && current.getNext().getData().compareTo(data) > 0) {
            current = current.getNext(); // scorri in avanti di 1 nodo
        }
        
        // quando è uscito dal ciclo, metti il nodo tra i due
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        // se l'inserimento è avvenuto nella coda, aggiorna tail
        if(newNode.getNext() == null) tail = newNode;
        
        return true;
    }
    
    // inserisci il dato in coda alla lista
    public boolean inserisciInCoda(T data) {
        Nodo<T> newNodo = new Nodo<T>(data);
        
        if(head == null) { // se la lista è vuota
            head = newNodo;
            tail = newNodo;
            return true;
        }
        
        // se si sono superate le casistiche, si procede normalmente
        tail.setNext(newNodo);
        tail = newNodo;
        return true;
    }
    
    // preleva un dato dalla testa della lista
    public T getFromHead() {
        if(this.isEmpty()) return null;
        
        Nodo<T> removed = head; // variabile dove mettere il nodo rimosso
        
        // rimuovo la testa e sposto head al successivo
        head = head.getNext();
        
        // se la lista diventa vuota, aggiorna anche tail
        if(head == null) tail = null;
        
        // Ritorno il dato del nodo removed
        return removed.getData();
    }
    
    // preleva un dato dalla coda della lista
    public T getFromTail() {
        if(this.isEmpty()) return null;
        
        if(head == tail) { // se c'è solo un elemento nella lista
            Nodo<T> removed = tail;
            head = null;
            tail = null;
            return removed.getData();
        }
        
        Nodo<T> current = head; // nodo d'appoggio
        // scorri la lista fino a quando non raggiungi il nodo prima di tail
        while(current.getNext() != tail) {
            current = current.getNext();
        }
        
        // rimuovi la coda vecchia e aggiornala
        Nodo<T> removed = tail;
        current.setNext(null);
        tail = current;
        
        // ritorno il dato del nodo removed
        return removed.getData();
    }
    
    // ritorna il numero di elementi nella lista
    public long size() {
        if(this.isEmpty()) return 0;
        
        int size = 0;
        
        Nodo<T> tmp = head;
        while(tmp != null) {
            tmp = tmp.getNext();
            size++;
        }
        
        return size;
    }
    
    // metodo isEmpty
    public boolean isEmpty() {
        return (head == null);
    }
    
    @Override
    public String toString() {
        String s = "";
        
        if(this.isEmpty()) return "Lista vuota. (HEAD -> TAIL)";
        
        Nodo<T> tmp = head;
        s += "HEAD -> ";
        
        while(tmp != null) {
            s += tmp.toString() + " -> ";
            tmp = tmp.getNext();
        }
        
        s += "TAIL";
        
        return s;
    }
}