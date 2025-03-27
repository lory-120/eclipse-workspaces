package main;
import model.*;

public class MainTestFileTXTStudente {
	
	public static void main(String args[]) {
		
		ArrayStudenteTXT array = new ArrayStudenteTXT();
		//Studente s1 = new Studente("lorenzo", "turri", 17, "TRRLNZ");
		//Studente s2 = new Studente("antonino", "stagnitta", 69, "STGANT");
		
		//array.add(s1);
		//array.add(s2);
		
		//array.writeFileTXT("elenco_studenti.txt");
		
		array.readFileTXT("elenco_studenti.txt");
		System.out.println(array.toString());
		
		System.out.println("Programma finito.");
		
	}
	
}
