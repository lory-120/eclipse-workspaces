package main;
import model.*;

public class MainSquadraCalcio {

	public static void main(String args[]) {
		Squadra s = new Squadra("Fiorentina", 1926);
		
		Calciatore c1 = new Calciatore("Chiesa", 20, 100, 1000000);
		Calciatore c2 = new Calciatore("Totti", 30, 150, 5000000);
		Calciatore c3 = new Calciatore("Pelé", 50, 300, 9000000);
		Calciatore c4 = new Calciatore("Ronaldinho", 40, 120, 7000000);
		Portiere p1 = new Portiere("Donnarumma", 50, 2, 8000000, 13, 20, 30);
		
		s.inserisciCalciatore(c1);
		s.inserisciCalciatore(c2);
		s.inserisciCalciatore(c3);
		s.inserisciCalciatore(c4);
		s.inserisciCalciatore(p1);
		
		System.out.println(p1.stampaInfo());
		
		System.out.println(s.stampaRosa());
		
		System.out.println("Il calciatore della squadra " + s.getNome() + " con più gol è: " + s.calciatoreConPiuGol().getNome() + ", con " + Integer.toString(s.calciatoreConPiuGol().getGolSegnati()) + " gol segnati.");
		
		System.out.println(s.getCalciatoreIndex(2).toString());
	}
	
}
