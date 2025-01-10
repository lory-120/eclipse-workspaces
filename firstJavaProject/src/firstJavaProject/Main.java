package firstJavaProject;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner Tastiera = new Scanner(System.in); //dichiara l'obj Tastiera di classe Scanner
		
		System.out.print("Inserisci un numero: ");
		double n = Tastiera.nextDouble(); //prendi il dato
		
		
		n = Math.sqrt(n); //elaborazione
		
		System.out.println("\n\nLa radice quadrata del numero è: " + n);
		
		Tastiera.close(); //termina il flusso di dati che viene da Tastiera
	}
}