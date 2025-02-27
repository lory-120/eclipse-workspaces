package model;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import utilities.PrelievoNonAmmessoException;

abstract public class Carta {

	//attributi
	protected final String CODICE;
	protected LocalDate expirationDate;
	protected final String CVC;
	protected double saldo;
	
	
	//metodi costruttore
	public Carta(double saldoIniziale) {
		this.CODICE = getNewCodice(7);
		this.expirationDate = LocalDate.now().plusYears(7);
		this.CVC = getNewCVC();
		this.saldo = saldoIniziale;
	}
	
	
	//metodi della funzione
	abstract public void preleva(double importo) throws PrelievoNonAmmessoException;
	
	
	//metodi get/set
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getCODICE() {
		return CODICE;
	}
	public String getCVC() {
		return CVC;
	}


	//metodi statici della funzione
	public static String getNewCodice(int codeSize) {
		//alphabet contiene tutti i possibili caratteri che comporranno il codice alfanumerico
		String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; //?!<>-*[]{}/
		int alphabetLength = alphabet.length();
		String password = "";
		for (int i = 0; i < codeSize; i++) {
			//scelgo una delle lettere dell'alfabeto
			int randomIndexCharInAlphabet = (int)(Math.random()*alphabetLength);
			password += alphabet.charAt(randomIndexCharInAlphabet);
		}
		return password;
	}
	
	public static String getNewCVC() {
		return Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000));
	}


	@Override
	public String toString() {
		return "Carta [CODICE=" + CODICE + ", expirationDate=" + expirationDate + ", CVC=" + CVC + ", saldo=" + saldo
				+ "]";
	}
	
}
