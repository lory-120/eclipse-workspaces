package model;
import java.util.ArrayList;

public class Squadra {

	//attributi
	public String nome;
	public int annoDiFondazione;
	public ArrayList<Calciatore> rosa;
	
	
	//metodi costruttore
	public Squadra() {
		this.nome = "";
		this.annoDiFondazione = -1;
		this.rosa = null;		
	}
	
	public Squadra(String nome, int annoDiFondazione) {
		this.nome = nome;
		this.annoDiFondazione = annoDiFondazione;
		this.rosa = new ArrayList<>();
	}

	
	//metodi get/set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnnoDiFondazione() {
		return annoDiFondazione;
	}
	public void setAnnoDiFondazione(int annoDiFondazione) {
		this.annoDiFondazione = annoDiFondazione;
	}
	public ArrayList<Calciatore> getRosa() {
		return rosa;
	}
	public void setRosa(ArrayList<Calciatore> rosa) {
		this.rosa = rosa;
	}
	
	
	//metodi dela funzione
	public void inserisciCalciatore(Calciatore c) {
		rosa.add(c);
	}
	
	public int cerca(String nome) {
		for(int i=0; i<rosa.size(); i++) {
			if(rosa.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		return -1;
	}
	
	public Calciatore getCalciatoreIndex(int index) {
		return rosa.get(index);
	}
	
	public void rimuoviCalciatore(int index) {
		rosa.remove(index);
	}
	
	public void rimuoviCalciatore(String nome) {
		rosa.remove(cerca(nome));
	}
	
	public String stampaRosa() {
		if(rosa.isEmpty()) {
			return "Non hai nessun giocatore nella squadra '" + this.nome + ".";
		}
		String temp = "*** ROSA DELLA SQUADRA '" + this.nome + "' ***\n";
		for(Calciatore c:rosa) {
			temp += c.stampaInfo();
		}		
		return temp;
	}
	
	public long valoreInEuroSquadra() {
		long valoreTot = 0;
		for(Calciatore c:rosa) {
			valoreTot += c.getValoreInEuro();
		}
		return valoreTot;
	}
	
	public Calciatore calciatoreConPiuGol() {
		if(rosa.isEmpty()) {
			return null;
		}
		
		Calciatore temp = rosa.get(0);
		for(Calciatore c:rosa) {
			if(c.getGolSegnati() > temp.getGolSegnati()) {
				temp = c;
			}
		}
		return temp;
	}

	
	//metodo toString
	@Override
	public String toString() {
		return "Squadra [nome=" + nome + ", annoDiFondazione=" + annoDiFondazione + ", rosa=" + rosa + "]";
	}
	
}
