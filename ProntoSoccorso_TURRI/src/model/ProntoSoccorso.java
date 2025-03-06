package model;

import model.Paziente.*;
import model.lista.*;

public class ProntoSoccorso extends ListaSoccorso<Paziente> {
	
	
	//metodo costruttore
	public ProntoSoccorso() {}


	//metodi della funzione abstract
	@Override
	public void inserisciPaziente(Paziente p) {
		if(p instanceof PazienteRosso) {
			this.addInTesta(p);
		} else if(p instanceof PazienteBianco) {
			this.addInCoda(p);
		} else {
			Nodo<Paziente> newNodo = new Nodo<>(p);
			Nodo<Paziente> tmp = this.getHead();
			while(tmp.getNext() != null && !(tmp.getNext().getData() instanceof PazienteBianco)) {
				tmp = tmp.getNext();
			}
			
			if(tmp.getNext() == null) { //se si è arrivati all'ultimo della lista, la coda
				tmp.setNext(newNodo);
				newNodo.setNext(null);
				setTail(newNodo);
			} else { //se siamo in un caso normale
				newNodo.setNext(tmp.getNext());
				tmp.setNext(newNodo);
			}
		}
	}


	@Override
	public Paziente soccorriPaziente() {
		Paziente pazienteSoccorso = this.getHead().getNext().getData();
		this.removeInTesta();
		return pazienteSoccorso;
	}


	@Override
	public int[] getPazientiInAttesa() {
		int[] nPazientiPerTipo = new int[3];
		
		//si inizia dal primo vero paziente, non dalla testa della lista
		Nodo<Paziente> tmp = this.getHead().getNext();
		while(tmp != null) {
			
			//guardo dove incrementare il numero di pazienti per tipo
			if(tmp.getData() instanceof PazienteRosso) {
				nPazientiPerTipo[0]++; //aumenta il n° di pazienti rossi
			} else if(tmp.getData() instanceof PazienteGiallo) {
				nPazientiPerTipo[1]++; //aumenta il n° di pazienti gialli
			} else {
				nPazientiPerTipo[2]++; //aumenta il n° di pazienti bianchi
			}
			
			tmp = tmp.getNext(); //scorro nella lista
		}
		
		return nPazientiPerTipo;
	}


	@Override
	public boolean removePazienteSpecifico(String nome, String cognome) {
		Nodo<Paziente> current = this.getHead().getNext();
		Nodo<Paziente> previous = this.getHead();
		
		//nel caso in cui il paziente è in testa
		if(current.getData().getNome().equals(nome) && current.getData().getCognome().equals(cognome)) {
			this.removeInTesta();
			return true;
		}
		
		//nel caso in cui il paziente è nella coda
		if(this.getTail().getData().getNome().equals(nome) && this.getTail().getData().getCognome().equals(cognome)) {
			this.removeInCoda();
			return true;
		}
		
		
		//scorri nella lista
		while(current != null) {
			//se nome e cognome combaciano
			if(current.getData().getNome().equals(nome) && current.getData().getCognome().equals(cognome)) {
				previous.setNext(current.getNext());
				return true;
			}
			
			//scorri ancora se la condizione non si è verificata
			previous = current;
			current = current.getNext();
		}
		
		//se infine non lo ha trovato, ritorna false
		return false;
		
	}
	
}
