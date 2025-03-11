package main;

import model.*;

public class MainListaStrutturata {

	public static void main(String args[]) {
		
		Lista<Integer> list = new Lista<>();
		
		list.inserisciOrdinato(2);
		list.inserisciOrdinato(5);
		list.inserisciOrdinato(8);
		list.inserisciOrdinato(1);
		list.inserisciOrdinato(3);
		
		System.out.println(list.toStringLista());
		
		
		System.out.println("dimensione lista: " + Long.toString(list.size()));
		System.out.println("prelevo dalla coda -> " + list.getFromTail());

		while(!list.isEmpty()) {
			System.out.println("dimensione lista: " + Long.toString(list.size()));
			System.out.println("prelevo dalla testa -> " + list.getFromHead());
		}
		
		System.out.println("dimensione lista: " + Long.toString(list.size()));
		
	}
	
}
