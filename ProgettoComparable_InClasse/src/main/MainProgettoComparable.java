package main;

import java.util.ArrayList;
import java.util.Collections;

import model.*;


public class MainProgettoComparable {
	
	public static void main(String args[]) {
		
		ArrayList<Persona> persone = new ArrayList<>();
		
		persone.add(new Persona("gigio", "giogio", 30));
		persone.add(new Persona("antonino", "stagnitta", 50));
		persone.add(new Persona("benito", "sussolini", 69));
		persone.add(new Persona("ermin", "kione", 104));
		persone.add(new Persona("ciola", "dura", 60));
		
		System.out.println("Prima dell'ordinamento: ");
		for(Persona p:persone) {
			System.out.println(p.toString());
		}
		
		Collections.sort(persone); //metodo statico nativo della classe Collections
		
		System.out.println("Dopo l'ordinamento: ");
		for(Persona p:persone) {
			System.out.println(p.toString());
		}
		
	}

}
