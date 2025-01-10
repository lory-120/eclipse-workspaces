package model;

import presentation.Tastiera;

public class Cliente {
	//attributi
	private String cognome, nome, codFisc;
	private BankAccount conti[];
	private SavingsAccount titoliDepositi[];
	
	//metodi get-set
	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodFisc() {
		return this.codFisc;
	}
	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}
	
	
	//metodi della classe
	public void addConto(String iban, String nomeBanca) {
		for(BankAccount c:conti) {
			if(c == null) {
				c = new BankAccount(iban, nomeBanca);
				return;
			}
		}
		System.out.println("Errore nell'aggiunta di un conto.");
	}
	
	public boolean removeConto(String iban) {
		int i;
		boolean found = false;
		for(i=0; i<conti.length; i++) {
			if(conti[i] != null && conti[i].getIban().equals(iban)) {
				conti[i] = null;
				found = true;
			}
		}
		
		if(!found) {
			return false;
		}
		
		for(int j=i; j<conti.length; j++) {
			if(conti[j+1] != null) {
				conti[j] = conti[j+1];
			}
		}
		
		return true;
	}
	
	public int searchConto(String iban) {
		for(int i=0; i<conti.length; i++) {
			if(conti[i] != null && conti[i].getIban().equals(iban)) {
				return i;
			}
		}
		return -1;
	}
	
	public void addDeposito(String iban) {
		for(SavingsAccount s:titoliDepositi) {
			if(s == null) {
				s = new SavingsAccount(iban);
				return;
			}
		}
		System.out.println("Errore nell'aggiunta di un conto.");
	}
	
	public boolean removeDeposito(String iban) {
		
	}
	
	public int searchDeposito(String iban) {
		
	}
	
	
	//metodi toString
	public String contiToString() {
		
	}
	public String depositiToString() {
		
	}	
	
}
