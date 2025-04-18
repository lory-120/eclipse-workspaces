package main;

import model.AlberoBinario;

public class MainAlberoBinario {

	public static void main(String args[]) {
		
		AlberoBinario<Integer> treeCrescente = new AlberoBinario<Integer>();
		treeCrescente.addOrdinatoCrescente(5);
		treeCrescente.addOrdinatoCrescente(3);
		treeCrescente.addOrdinatoCrescente(8);
		treeCrescente.addOrdinatoCrescente(1);
		treeCrescente.addOrdinatoCrescente(7);
		treeCrescente.addOrdinatoCrescente(2);
		System.out.println(treeCrescente.toString());
		
		System.out.println("Il numero 5 è presente: " + treeCrescente.isPresent(5));
		System.out.println("Il numero 20 è presente: " + treeCrescente.isPresent(20));
		
		
		
		System.out.println("\n\n");
		
		
		
		AlberoBinario<Integer> treeDecrescente = new AlberoBinario<Integer>();
		treeDecrescente.addOrdinatoDecrescente(5);
		treeDecrescente.addOrdinatoDecrescente(3);
		treeDecrescente.addOrdinatoDecrescente(8);
		treeDecrescente.addOrdinatoDecrescente(1);
		treeDecrescente.addOrdinatoDecrescente(7);
		treeDecrescente.addOrdinatoDecrescente(2);
		System.out.println(treeDecrescente.toString());
		
		System.out.println("Il numero 7 è presente: " + treeDecrescente.isPresent(7));
		System.out.println("Il numero 20 è presente: " + treeDecrescente.isPresent(20));
		
	}
	
}
