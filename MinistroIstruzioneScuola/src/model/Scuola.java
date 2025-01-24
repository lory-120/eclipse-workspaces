package model;

abstract public class Scuola {
	protected String codice;
	protected String nome;
	protected String citta;
	protected int nStudenti;
	protected int nClassi;
	protected int nSediAggiuntive;
	protected int nLab;
	protected static final int PASSWORD_SIZE = 8;
	
	//metodo costruttore
	public Scuola(String nome, String citta, int nStudenti, int nClassi, int nSediAggiuntive, int nLab) {
		this.codice = getNewCodice(PASSWORD_SIZE);
		this.nome = nome;
		this.citta = citta;
		this.nStudenti = nStudenti;
		this.nClassi = nClassi;
		this.nSediAggiuntive = nSediAggiuntive;
		this.nLab = nLab;
	}
	
	
	//metodi get/set	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public int getnStudenti() {
		return nStudenti;
	}
	public void setnStudenti(int nStudenti) {
		this.nStudenti = nStudenti;
	}
	public int getnClassi() {
		return nClassi;
	}
	public void setnClassi(int nClassi) {
		this.nClassi = nClassi;
	}
	public int getnSediAggiuntive() {
		return nSediAggiuntive;
	}
	public void setnSediAggiuntive(int nSediAggiuntive) {
		this.nSediAggiuntive = nSediAggiuntive;
	}
	public int getnLab() {
		return nLab;
	}
	public void setnLab(int nLab) {
		this.nLab = nLab;
	}
	public static int getPasswordSize() {
		return PASSWORD_SIZE;
	}
		
	
	//metodi della funzione
	public static String getNewCodice(int passwordSize) {
		//alphabet contiene tutti i possibili caratteri che comporranno la Password
		String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz?!<>-*[]{}/";
		int alphabetLength = alphabet.length();
		String password = "";
		for (int i = 0; i < passwordSize; i++) {
			// Scelgo una delle lettere dell'alfabeto.
			int randomIndexCharInAlphabet = (int)(Math.random()*alphabetLength);
			password += alphabet.charAt(randomIndexCharInAlphabet);
		}
		return password;
	}

	//metodi abstract
	abstract public double getContributoTotale();
	
	
	//metodo toString
	@Override
	public String toString() {
		return "Scuola [codice=" + codice + ", nome=" + nome + ", citta=" + citta + ", nStudenti=" + nStudenti
				+ ", nClassi=" + nClassi + ", nSediAggiuntive=" + nSediAggiuntive + ", nLab=" + nLab + "]";
	}
	

}
