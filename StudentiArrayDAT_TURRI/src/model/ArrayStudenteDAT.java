package model;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArrayStudenteDAT {
	private ArrayList<Studente> studenti;
	
	public ArrayStudenteDAT() {
		this.studenti = new ArrayList<>();
	}
	
	public boolean add(Studente s) {
		return studenti.add(s);
	}
	public Studente remove(Studente s) {
		Studente temp = null;
		for(int i=0; i<studenti.size(); i++) {
			if(studenti.get(i).getCf().equals(s.getCf())) {
				temp = studenti.get(i);
				studenti.remove(i);
			}
		}
		return temp;
	}

	@Override
	public String toString() {
		return "ArrayStudenteDAT [studenti=" + studenti.toString() + "]";
	}
	
	public void scriviDAT(String fileName) {
		try {
			FileOutputStream f = new FileOutputStream(fileName);
			ObjectOutputStream fout = new ObjectOutputStream(f);
			
			for(Studente s:studenti) {
				if(s != null) {
					fout.writeObject(s);
					fout.flush();
				}
			}
		} catch(Exception e) {
			System.out.println("Errore nella scrittura del file DAT:\n" + e.toString());
		}
	}
	
	public void leggiDAT(String fileName) {
		try {
			FileInputStream f = new FileInputStream(fileName);
			ObjectInputStream fin = new ObjectInputStream(f);
			
			studenti.clear();
			
			Studente temp = null;
			while(true) {
				try {
					temp = (Studente)fin.readObject();
					studenti.add(temp);
				} catch(EOFException e) { //ha finito di leggere il file
					f.close();
					break;
				}
			}
			
		} catch(Exception e) {
			System.out.println("Errore nell'apertura del file:\n" + e.toString());
		}
	}
	
}