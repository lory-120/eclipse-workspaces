package model;

public class BankAccount {
	//attributi
	protected String iban, nomeBanca;
	protected double saldo;
	
	//metodo costruttore
	public BankAccount(String iban, String nomeBanca) {
		this.iban = iban;
		this.nomeBanca = nomeBanca;
		saldo = 0.0;
	}
	
	//metodi get-set
	public String getIban() {
		return this.iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getNomeBanca() {
		return this.nomeBanca;
	}
	public void setNomeBanca(String nomeBanca) {
		this.nomeBanca = nomeBanca;
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	//metodi della classe
	public boolean preleva(double importo) {
		if(saldo <= importo) {
			saldo -= importo;
			return true;
		} else {
			return false;
		}
	}
	public boolean deposita(double importo) {
		if(importo <= 0) {
			return false;
		} else {
			saldo += importo;
			return true;
		}
	}
	
}
