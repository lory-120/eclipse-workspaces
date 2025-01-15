package model;
import java.util.ArrayList;
import java.io.*;

public class ArrayStudenteDAT {
	
	//attributo arraylist che contiene tutti gli studenti
	private ArrayList<Studente> studenti;
	
	//metodo ocstruttore
	public ArrayStudenteDAT() {
		studenti = new ArrayList<>();
	}
	
	//metodi della funzione
	public void add(Studente s) {
		studenti.add(s);
	}
	
	public void clear() {
		studenti.clear();
	}
	
	public void writeFileDAT(String fileName) {		
		try {			
			ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(fileName)); //compresso in una riga
			//FileOutputStream f = new FileOutputStream(fileName); //se si vuole essere più pignoli e precisi
	        //ObjectOutputStream fOUT = new ObjectOutputStream(f);
			for(Studente s:studenti) {
				if(s != null) {
					fileOutput.writeObject(s);
					fileOutput.flush();
				}
			}
			fileOutput.close(); //si chiude lo stream di dati per non corrompere il file DAT	
		} catch(IOException e) {
			System.out.println("Errore nella creazione del file DAT.\n" + e.toString());
		} catch(Exception e) {
			System.out.println("Errore generale.\n" + e.toString());
		}
	}
	
	
	public void readFileDAT(String fileName) {
	    try {
	    	ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(fileName)); //compresso in una riga
	    	//FileInputStream f = new FileInputStream(); //se si vuole essere pignoli
	    	//ObjectInputStream fileInput = new ObjectInputStream(f);
	        studenti.clear();
	        try {
		        while(true) {
		            studenti.add((Studente) fileInput.readObject());
		        }
	        } catch(EOFException e) {
	        	System.out.println("Lettura file completata.");
	        	fileInput.close();
	        	//f.close();
	        }
	    } catch (IOException e) {
	        System.out.println("Errore nell'apertura del file DAT.\n" + e.toString());
	    } catch (ClassNotFoundException e) {
	        System.out.println("Classe letta non è della classe Studente.\n" + e.toString());
	    }
	}

	
	//metodo toString
	@Override
	public String toString() {
		return "ArrayStudenteDAT [studenti=" + studenti + "]";
	}
	
}