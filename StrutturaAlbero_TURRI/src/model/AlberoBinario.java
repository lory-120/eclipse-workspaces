package model;

import java.util.NoSuchElementException;

import utilities.ElementoDuplicatoException;

public class AlberoBinario<T extends Comparable<T>> {

	//la radice del nodo
	private Nodo<T> root;
	
	//metodo costruttore
	public AlberoBinario() {
		this.root = null;
	}
	
	
	//metodi della funzione
	
	//METODI PER AGGIUNGERE IN MODO CRESCENTE
	//aggiunge un dato in modo crescente (funzione pubblica)
	public boolean addOrdinatoCrescente(T data) {
		Nodo<T> tmp = new Nodo<T>(data);
		root = addOrdinatoCrescenteHelper(root, tmp);
		return true;
	}
	
	//aggiunge un dato in modo crescente, dato un nodo considerato come radice (funzione privata ricorsiva)
	private Nodo<T> addOrdinatoCrescenteHelper(Nodo<T> root, Nodo<T> nodo) {
		if(root == null) {
			root = nodo;
			return root;
		}
		
		int confronto = nodo.getData().compareTo(root.getData());
		
		if(confronto == 0) {
			throw new ElementoDuplicatoException("Elemento già presente nell'albero:\n"
					+ nodo.getData().toString());
		}
		
		if(confronto < 0) {
			root.setSx(addOrdinatoCrescenteHelper(root.getSx(), nodo));
		} else {
			root.setDx(addOrdinatoCrescenteHelper(root.getDx(), nodo));
		}
		
		return root;
	}


	//METODI PER AGGIUNGERE IN MODO DECRESCENTE
	//aggiunge un dato in modo decrescente (funzione pubblica)
	public boolean addOrdinatoDecrescente(T data) {
		Nodo<T> tmp = new Nodo<T>(data);
		root = addOrdinatoDecrescenteHelper(root, tmp);
		return true;
	}
	
	//aggiuunge un dato in modo decrescente, dato un nodo considerato come radice (funzione privata ricorsiva)
	private Nodo<T> addOrdinatoDecrescenteHelper(Nodo<T> root, Nodo<T> nodo) {
		if(root == null) {
			root = nodo;
			return root;
		}
		
		int confronto = nodo.getData().compareTo(root.getData());
		
		if(confronto == 0) {
			throw new ElementoDuplicatoException("Elemento già presente nell'albero:\n"
					+ nodo.getData().toString());
		}
		
		if(confronto > 0) {
			root.setSx(addOrdinatoDecrescenteHelper(root.getSx(), nodo));
		} else {
			root.setDx(addOrdinatoDecrescenteHelper(root.getDx(), nodo));
		}
		
		return root;
	}
	
	
	
	//METODI PER CERCARE UN DATO
	//cerca un dato, in un albero con i dati crescenti
	public T searchCrescente(T data) {
		return searchHelperCrescente(root, data);
	}
	//cerca un dato, in un albero con i dati crescenti (funzione privata ricorsiva)
	public T searchHelperCrescente(Nodo<T> root, T data) {
		if(root == null) {
			throw new NoSuchElementException("Elemento non trovato: " + data.toString());
		}
		
		if(root.getData().equals(data)) {
			return root.getData();
		}

		int confronto = root.getData().compareTo(data);
		if(confronto > 0) {
			return searchHelperCrescente(root.getSx(), data);
		} else {
			return searchHelperCrescente(root.getDx(), data);
		}	
	}
	
	//cerca un dato, in un albero con i dati decrescenti
	public T searchDerescente(T data) {
		return searchHelperDerescente(root, data);
	}
	//cerca un dato, in un albero con i dati decrescenti (funzione privata ricorsiva)
	public T searchHelperDerescente(Nodo<T> root, T data) {
		if(root == null) {
			throw new NoSuchElementException("Elemento non trovato: " + data.toString());
		}
		
		if(root.getData().equals(data)) {
			return root.getData();
		}

		int confronto = root.getData().compareTo(data);
		if(confronto < 0) {
			return searchHelperDerescente(root.getSx(), data);
		} else {
			return searchHelperDerescente(root.getDx(), data);
		}	
	}
	
	
	
	//vede se un dato è presente
	public boolean isPresent(T data) {
		try {
			this.searchCrescente(data);
		} catch(NoSuchElementException e1) {
			try {
				this.searchDerescente(data);
			} catch(NoSuchElementException e2) {
				return false;
			}
		}
		
		return true;
	}
	
	//mtodo toString
	@Override
	public String toString() {
		return "Dati ordinati dell'albero: \n" + toStringHelper(root, "");
	}
	
	private String toStringHelper(Nodo<T> root, String tmp) {
		if(root == null) {
	        return tmp;
	    }
		
		tmp = toStringHelper(root.getSx(), tmp);
		tmp += root.getData() + " ";
		tmp = toStringHelper(root.getDx(), tmp);
		
		return tmp;
	}
	
}
