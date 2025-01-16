package main;
import model.*;
//import presentation.*;

public class MainFileDATStudente {
	
	public static void main(String args[]) {
		
		ArrayStudenteDAT array = new ArrayStudenteDAT();
		
		Studente s1 = new Studente("lorenzo", "turri", 17, "TRRLNZ");
		Studente s2 = new Studente("antonino", "stagnitta", 69, "STGANT");
		
		/*
		array.add(s1);
		array.add(s2);
		array.writeFileDAT("studenti.dat");
		*/
		
		
		array.clear();		
		array.readFileDAT("studenti.dat");
		System.out.println(array.toString());
		
		
		System.out.println("Programma finito.");
		
	}
	
}
