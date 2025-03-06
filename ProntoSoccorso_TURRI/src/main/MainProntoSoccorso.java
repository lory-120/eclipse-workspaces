package main;

import model.ProntoSoccorso;
import model.Paziente.*;

public class MainProntoSoccorso {
	
	private static void printPazientiInAttesa(ProntoSoccorso p) {
		//System.out.println("eseguo metodo getPazientiInAttesa");
		int[] waitLine = p.getPazientiInAttesa();
		//System.out.println("eseguo metodo getPazientiInAttesa fatto");
		System.out.println("***IN ATTESA***");
		System.out.println("Rossi: " + waitLine[0] + "\tGialli: " + waitLine[1] + "\tBianchi: " + waitLine[2]);
	}

	public static void main(String[] args) {
		
		//creazione del pronto soccorso
		//System.out.println("init ProntoSoccorso");
		ProntoSoccorso p = new ProntoSoccorso();
		//System.out.println("init ProntoSoccorso fatto");
		
		//creazione di pazienti rossi
		//System.out.println("init pazienti");
		PazienteRosso pr1 = new PazienteRosso("Mario", "Rossi", 30);
		PazienteRosso pr2 = new PazienteRosso("Laura", "Bianchi", 45);
		PazienteRosso pr3 = new PazienteRosso("Giovanni", "Ferrari", 65);

		//creazione di pazienti gialli
		PazienteGiallo pg1 = new PazienteGiallo("Sofia", "Esposito", 28);
		PazienteGiallo pg2 = new PazienteGiallo("Paolo", "Ricci", 52);
		PazienteGiallo pg3 = new PazienteGiallo("Chiara", "Moretti", 37);

		//creazione di pazienti bianchi
		PazienteBianco pb1 = new PazienteBianco("Luca", "Conti", 19);
		PazienteBianco pb2 = new PazienteBianco("Francesca", "Martini", 41);
		PazienteBianco pb3 = new PazienteBianco("Marco", "Romano", 33);
		//System.out.println("init pazienti fatto");
		
		//System.out.println("aggiungo pazienti");
		//aggiungo i pazienti rossi
		p.inserisciPaziente(pr1);
		p.inserisciPaziente(pr2);
		p.inserisciPaziente(pr3);
		//aggiungo i pazienti gialli
		p.inserisciPaziente(pg1);
		p.inserisciPaziente(pg2);
		p.inserisciPaziente(pg3);
		//aggiungo i pazienti bianchi
		p.inserisciPaziente(pb1);
		p.inserisciPaziente(pb2);
		p.inserisciPaziente(pb3);
		//System.out.println("aggiungo pazienti: fatto");
		
		//System.out.println("eseguo metodo printPazientiInAttesa");
		//stampo i pazienti in attesa (rossi, gialli, bianchi)
		printPazientiInAttesa(p);
		//System.out.println("eseguo metodo printPazientiInAttesa fatto");
		
		//System.out.println("soccorro pazienti");
		//soccorro 2 pazienti
		System.out.println("Paziente soccorso: " + p.soccorriPaziente().toString());
		System.out.println("Paziente soccorso: " + p.soccorriPaziente().toString());
		//System.out.println("soccorro pazienti fatto");
		
		//stampo i pazienti in attesa (rossi, gialli, bianchi)
		printPazientiInAttesa(p);
		
		//System.out.println("rimuovo pazienti specifici");
		//rimuovo 2 pazienti specifici
		String nome = "Paolo";
		String cognome = "Ricci";
		System.out.println("Rimuovo " + nome + " " + cognome + ", esito: " + p.removePazienteSpecifico(nome, cognome));
		
		nome = "Lorenzo";
		cognome = "Turri";
		System.out.println("Rimuovo " + nome + " " + cognome + ", esito: " + p.removePazienteSpecifico(nome, cognome));
		//System.out.println("rimuovo pazienti specifici: fatto");
		
	}

}
