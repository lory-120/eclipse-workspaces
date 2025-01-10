package main;
import model.*;

public class MainStudenteDAT {
	
	public static void main(String args[]) {
		ArrayStudenteDAT array = new ArrayStudenteDAT();
		
		Studente s1 = new Studente("TRRLNZ", "Turri", "Lorenzo", "massimo.bossetti@gmail.com", 17);
		Studente s2 = new Studente("BNTMSL", "Mussolini", "Benito", "benito.mussolyny.xxx@gmsil.com", 104);
		Studente s3 = new Studente("ZCCYUR", "Zaccari", "Yuri", "froci.a.palate@pornmail.com", 69);
		
		array.add(s1); array.add(s2); array.add(s3);
		
		System.out.println(array.toString());
		
		System.out.println("\n\n");
		
		array.scriviDAT("studenti.dat");
		System.out.println("File DAT scritto.");
		
		System.out.println("\n\n");
		
		array.leggiDAT("studenti.dat");
		System.out.println("File DAT letto.");
		System.out.println(array.toString());
	}
	
}
