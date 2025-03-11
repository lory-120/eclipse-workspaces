package main;

import model.Coda;

public class MainCoda {

	public static void main(String args[]) {
		
		final int nElementi = 1000; //definisco quanti elementi mettere nella coda
		
		Coda<Integer> c = new Coda<Integer>(); //creo una coda di nElementi
		
		for(int i=0; i<nElementi; i++) { //aggiungo gli elementi alla coda
			c.aggiungi(i);
			System.out.println("Ho aggiunto alla mia coda -> " + i);
		}
		
		System.out.println((c.isVuota()) ? "La coda è vuota." : "La coda non è vuota."); //vedi se la coda è vuota o no
		
		for(int i=0; i<nElementi; i++) { //tolgo gli elementi dalla coda
			System.out.println("Prelevo dalla mia coda -> " + (Integer)c.togli());
		}
		
		System.out.println((c.isVuota()) ? "La coda è vuota." : "La coda non è vuota."); //vedi se la coda è vuota o no (di nuovo)
		
	}
	
}
