package mainExample;

import model.*;

class Persona implements Comparable<Persona> {
    // attributi
    private String nome;
    private String cognome;
    
    // costruttore
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    
    // metodi get/set
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    // metodo toString
    @Override
    public String toString() {
        return nome + " " + cognome;
    }
    
    
    // implementazione di compareTo (ordina per cognome e poi per nome)
    @Override
    public int compareTo(Persona altra) {
        int confrontoCognome = this.cognome.compareTo(altra.cognome);
        
        // Se i cognomi sono diversi, ritorna il risultato del confronto
        if (confrontoCognome != 0) {
            return confrontoCognome;
        }
        
        // Se i cognomi sono uguali, confronta i nomi
        return this.nome.compareTo(altra.nome);
    }
    
}

/**
 * caramelli se davvero leggi questo dio porco hai 2 opzioni:
 * 1. mi mandi una foto dove twerki
 * 2. mi mandi una foto di panci che twerka
 * 3. finisci outlast da bendato e con un plug anale
 * 4. mi mandi un messaggio dove mi dici che hai letto questo
 * @return maremma cignala
 */

public class MainListaStrutturata2 {

	public static void main(String[] args) {
		
		Lista<Persona> list = new Lista<Persona>();
		
		list.inserisciOrdinatoDecrescente(new Persona("Lorenzo", "Rossi"));
		list.inserisciOrdinatoDecrescente(new Persona("Mario", "Rossi"));
		list.inserisciOrdinatoDecrescente(new Persona("Andrea", "Rossi"));
		
		System.out.println(list.toString());
		
	}

}
