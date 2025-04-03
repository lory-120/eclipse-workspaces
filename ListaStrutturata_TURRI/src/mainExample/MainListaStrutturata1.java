package mainExample;

import model.*;

public class MainListaStrutturata1 {

	public static void main(String args[]) {
		
		Lista<Integer> list = new Lista<Integer>();
		
		System.out.println(list.toString());
		list.inserisciOrdinatoDecrescente(5);
		System.out.println(list.toString());
		list.inserisciOrdinatoDecrescente(8);
		System.out.println(list.toString());
		list.inserisciOrdinatoDecrescente(1);
		System.out.println(list.toString());
		list.inserisciOrdinatoDecrescente(3);
		
		System.out.println(list.toString());
		
		
		System.out.println("dimensione lista: " + Long.toString(list.size()));
		System.out.println("prelevo dalla coda -> " + list.getFromTail());

		while(!list.isEmpty()) {
			System.out.println("dimensione lista: " + Long.toString(list.size()));
			System.out.println("prelevo dalla testa -> " + list.getFromHead());
		}
		
		System.out.println("dimensione lista: " + Long.toString(list.size()));
		
	}
	
}
