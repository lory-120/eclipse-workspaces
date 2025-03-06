package main;

import model.*;

public class MainListaStrutturata {

	public static void main(String args[]) {
		
		OldLista list = new OldLista();
		
		list.inserisciOrdinato(2);
		list.inserisciOrdinato(5);
		list.inserisciOrdinato(8);
		list.inserisciOrdinato(1);
		list.inserisciOrdinato(3);
		
		System.out.println(list.getStringLista());
		
	}
	
}
