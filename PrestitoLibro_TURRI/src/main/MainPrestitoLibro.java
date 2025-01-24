package main;

import java.util.*;
import java.time.*;
import model.*;

public class MainPrestitoLibro {

	//dichiaro le persone
	Persona p1 = new Persona("Lorenzo", "Turri", 17);
	Persona p2 = new Persona("Paolo", "Bianchi", 35);
	Persona p3 = new Persona("Sara", "Balotelli", 23);
	//dichiaro i libri
	Libro l1 = new Libro("In principio era ChatGPT", "Mafe De Baggis", 200);
	Libro l2 = new Libro("Pensieri", "Marco Aurelio", 190);
	Libro l3 = new Libro("Libro bello", "Autore fantastico", 57);
	Libro l4 = new Libro("Informatica", "Mario Rossi", 110);
	
	//ora prestiamo i libri alle varie persone
	Prestito prestito1 = new Prestito(p1, new ArrayList<Libro>(Arrays.asList(l1, l2)), LocalDate.of(2025, 1, 25), LocalDate.of(2025, 2, 25));
	Prestito prestito2 = new Prestito(p2, l3, LocalDate.of(2025, 1, 12), LocalDate.of(2025,  2, 12));
	Prestito prestito3 = new Prestito(p3, l4, LocalDate.of(2025, 2, 2), LocalDate.of(2025, 2, 30));
	
	//vediamo un po' come funziona ora :)
	System.out.println("ciao");
	
}