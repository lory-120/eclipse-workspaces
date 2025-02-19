package main;

import model.Pila;

public class MainPila {
	
	public static void main(String args[]) {
		
		Pila pila = new Pila(7);
		int nElements = 5;
		
		for(Integer i=nElements; i>0; i--) {
			System.out.println("Faccio il push del numero -> " + i.toString());
			pila.push(i);
		}
		
		System.out.println("Elemento in cima alla pila: " + pila.top());
		
		for(Integer i=0; i<5; i++) {
			if(pila.top() instanceof Integer) {
				System.out.println("Faccio il pop dell'elemento dalla pila e ottengo -> " + pila.pop());
			}
		}
		
	}

}
