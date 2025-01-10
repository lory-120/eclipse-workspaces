package model;

public class Autonoleggio {
	private Veicolo veicoli[];
	private int nVeicoli = 0;
	
	public Autonoleggio(int maxCapacity) {
		this.veicoli = new Veicolo[maxCapacity];
		this.nVeicoli = 0;
	}

	//metodi get
	public Veicolo[] getVeicoli() {
		return veicoli;
	}

	public int getnVeicoli() {
		return nVeicoli;
	}
	
	//METODI DI FUNZIONE
	//aggiungi veicolo
	public boolean addVeicolo(Veicolo v) {
		if(nVeicoli == veicoli.length) {
			return false;
		}
		veicoli[nVeicoli] = v;
		nVeicoli++;
		return true;
	}
	
	//elimina veicolo (si fa l'overload con codice e targa di un veicolo)
	public boolean deleteVeicolo(int codice) {
		for(int i=0; i<nVeicoli; i++) {
			if(veicoli[i].getCODICE() == codice) {
				for(int j=i; j<nVeicoli; j++) {
					veicoli[j] = veicoli[j+1]; //sposta i veicoli a sx
				}
				veicoli[nVeicoli-1] = null; //l'ultimo veicolo è doppio, ora è null
				nVeicoli--;
				return true;
			}
		}
		return false;
	}
	public boolean deleteVeicolo(String targa) {
		for(int i=0; i<nVeicoli; i++) {
			if(veicoli[i].getTARGA() == targa) {
				for(int j=i; j<nVeicoli; j++) {
					veicoli[j] = veicoli[j+1]; //sposta i veicoli a sx
				}
				veicoli[nVeicoli-1] = null; //l'ultimo veicolo è doppio, ora è null
				nVeicoli--;
				return true;
			}
		}
		return false;
	}
	
	//metodi per ricercare un veicolo (overloading con codice e targa)
	public Veicolo searchVeicolo(int codice) {
		for(Veicolo v:veicoli) {
			if(v != null) {
				if(v.getCODICE() == codice) {
					return v;
				}
			}
		}
		return null;
	}
	public Veicolo searchVeicolo(String targa) {
		for(Veicolo v:veicoli) {
			if(v != null) {
				if(v.getTARGA().equals(targa)) { //.equals() si usa per CONFRONTARE LE STRINGHE
					return v;
				}
			}
		}
		return null;
	}
	
	public Veicolo[] searchPerPosti(int posti) {
		Veicolo[] veicoliPosti = new Veicolo[nVeicoli];
		int contaVeicoli = 0;
		for(Veicolo v:veicoliPosti) {
			if(v.getN_POSTI() == posti) {
				veicoliPosti[contaVeicoli] = v;
				contaVeicoli++;
			}
		}
		return veicoliPosti;
	}
	
	public int searchPerMarca(String marca) { //ritorna quanti veicoli di una determinata marca ci sono
		int contaVeicoliMarca = 0;
		for(Veicolo v:veicoli) {
			if(v != null) {
				if(v.getMARCA().equals(marca)) {
					contaVeicoliMarca++;
				}
			}
		}
		return contaVeicoliMarca;
	}
	
	
}
