package main;
import model.*;
//import presentation.*;

public class MainMuseo {
	public static void main(String args[]) {
		Statua s1 = new Statua(1200, "Statua vaianese", "Lorenzo", "E' una statua vaianese bellina");
		Quadro q1 = new Quadro(1345, "Quadro pratese", "Caramels", "E' un quadro pratese e ho detto tutto");
		
		System.out.println(s1.toString());
		System.out.println("\n\n");
		System.out.println(q1.toString());
		System.out.println("\n\n");
		System.out.println(s1.getDescrizione());
		
		System.out.println("\n\nE niente questo è il mio primo programma Java con le classi\nyeee che bello");
		
	}
}
