package model;

public class GeneratoreCodice {
	//attributi
	private static int codice = 0;
	
	//metodo che genera un codice che si incrementa di un unità
	public static int generaCodice() {
		return codice++;
	}
	
	public static int getCodice() {
		return codice;
	}
}
