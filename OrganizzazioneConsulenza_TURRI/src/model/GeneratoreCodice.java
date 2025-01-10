package model;

public class GeneratoreCodice {
	//atributi
	private static int codice = 0;
	
	//metodo costruttore
	public GeneratoreCodice() {	}
	
	//metodo della funzione che genera il codice
	public static int generaCodice() {
		codice++;
		return codice;
	}
}
