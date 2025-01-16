package model;
import java.util.*;
import java.io.*;

public class ArrayStudenteTXT {
	//attributo arraylist che contiene tutti gli studenti
	private ArrayList<Studente> studenti;
	
	//metodo costruttore
	public ArrayStudenteTXT() {
		studenti = new ArrayList<>();
	}
	
	//metodi della funzione
	public void add(Studente s) {
		studenti.add(s);
	}
	
	public void clear() {
		studenti.clear();
	}
	
	//per scrivere tutti gli studenti nel file .txt
	public void writeFileTXT(String fileName) {
		try {
			FileWriter f = new FileWriter(fileName);
			PrintWriter fileOutput = new PrintWriter(f);
						
			if(studenti.isEmpty()) { //controlla se l'array è vuoto prima di iniziare a scrivere
				System.out.println("Non ci sono studenti registrati.");
				f.close(); //importante chiudere il file
				return;
			}
			
			//inizializza stringhe di appoggio, separatore per il tokenizer e il newline
			String temp = ""; String sep = ";"; String newLine = "\n";
			for(Studente s:studenti) {
				temp = s.getNome() + sep + s.getCognome() + sep + Integer.toString(s.getEta()) + sep + s.getCf() + newLine;
				fileOutput.append(temp); //scrive alla fine del file .txt
			}
			
			f.close(); //importante chiudere il file
		} catch(IOException e) { //errore di i/o
			System.out.println("Errore di I/O o scrittura file.\n" + e.toString());
		} catch(Exception e) { //eccezione generale
			System.out.println("Errore generale.\n" + e.toString());
		}
	}
	
	//per leggere tutti gli studenti nel file .txt, tokenizzati. Si parsano con lo StringTokenizer
	public void readFileTXT(String fileName) {
		String strTemp = ""; //per leggere stringa per stringa del file
		try {
			FileReader f = new FileReader(fileName);
			BufferedReader fileInput = new BufferedReader(f);
			StringTokenizer tokenizer = new StringTokenizer(strTemp, ";"); //tokenizzatore per stirnghe, con riferimento la var. strTemp e delimitatore ";"
			Studente temp = new Studente(); //oggetto Studente di appoggio
			
			try {
				while(strTemp != null) { //si scorre per tutte le stringhe e si estrae l'oggetto
					temp.setNome(tokenizer.nextToken());
					temp.setCognome(tokenizer.nextToken());
					temp.setEta(Integer.parseInt(tokenizer.nextToken())); //qui c'è da fare il parseInt perché si leggono tutte stringhe
					temp.setCf(tokenizer.nextToken());
					this.studenti.add(temp); //alla fine si aggiunge all'arraylist
				}
			} catch(NoSuchElementException e) { //se la stringa estratta tokenizzata non ha nulla (se la stringa è vuota)
				f.close(); //importante chiudere il file
			}
			
			f.close(); //importante chiudere il file
		} catch(IOException e) { //errore di i/o
			System.out.println("Errore di I/O o apertura file.\n" + e.toString());
		} catch(Exception e) { //eccezione generale
			System.out.println("Errore generale.\n" + e.toString());
		}
	}

	
	//metodo toString
	@Override
	public String toString() {
		return "ArrayStudenteTXT [studenti=" + studenti + "]";
	}
	
}
