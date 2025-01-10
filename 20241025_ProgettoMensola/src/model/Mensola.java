package model;

public class Mensola {
	private Libro[] libri;
	private int numLibri;
	
	public Mensola(int capacita) {
		this.libri=new Libro[capacita];
		numLibri=0; //quando creo la mensola non è presente nessun libro
	}
	
	//aggiungi libro a mensola
	public boolean aggiungiLibro(Libro libro) {
		//controllo che ci sia posto sulla mensola
		if(!isPiena()) {
			libri[numLibri]=libro;
			numLibri++;
			return true;
		} else {
			return false;
		}
		
	}
	//rimuovi libro dalla mensola
	public boolean rimuoviLibro(String titolo) {
		for(int i=0; i<numLibri; i++) {
			if(libri[i].getTITOLO().equals(titolo)) {
				for(int j=i; j<numLibri; j++) {
					libri[j]=libri[j+1];
				}
				libri[numLibri-1]=null;
				numLibri--;
				return true;
			}
		}
		return false;
	}
	
	
	//cerca libro per titolo
	public Libro cercaLibro(String titolo) {
		for(Libro l:libri) {
			if(l != null) {
				if(l.getTITOLO().equals(titolo)) {
					return l;
				}
			}
		}
		return null;
	}
	//cerca libri per autore
	public Libro[] cercaLibroPerAutore(String autore) {
		Libro[] libriAutore=new Libro[numLibri];
		int contaLibri=0;
		
		for(int i=0; i<numLibri; i++) {
			if(libri[i] != null) {
				if(libri[i].getAUTORE().equals(autore)) {
					libriAutore[contaLibri]=libri[i];
					contaLibri++;
				}
			}
		}
		Libro[] libriAutorePreciso=new Libro[contaLibri];
		for(int i=0; i<contaLibri; i++) {
			libriAutorePreciso[i]=libriAutore[i];
		}
		return libriAutorePreciso;
	}
	//visualizza totale libri presenti
	public int getNumLibri() {
		return numLibri;
	}
	
	public boolean isPiena() {
		if(numLibri==libri.length) {
			return true;
		} else {
			return false;
		}
	}
}
