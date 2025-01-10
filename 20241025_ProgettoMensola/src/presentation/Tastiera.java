package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {
	private static InputStreamReader reader=new InputStreamReader(System.in);
	private static BufferedReader tastiera=new BufferedReader(reader);
	
	//metodo che legge stringhe
	public static String leggiString() {
		String stringaLetta=null;
		try {
			stringaLetta=tastiera.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringaLetta;
	}
	//overload del metodo per stampare richiesta all'utente
	public static String leggiString(String msg) {
		String stringaLetta=null;
		System.out.print(msg);
		try {
			stringaLetta=tastiera.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringaLetta;
	}
	//metodo che legge interi
	public static int leggiInt() {
		String stringaLetta=null;
		int numero=0;
		do {
			try {
				stringaLetta=tastiera.readLine();
				numero=Integer.parseInt(stringaLetta);
			} catch (NumberFormatException e ) {
				stringaLetta=null;
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (stringaLetta==null);
		return numero;
	}
	
	public static int leggiInt(String msg) {
		String stringaLetta=null;
		int numero=0;
		do {
			System.out.print(msg);
			try {
				stringaLetta=tastiera.readLine();
				numero=Integer.parseInt(stringaLetta);
			} catch (NumberFormatException e ) {
				stringaLetta=null;
				System.out.println("Input non valido. Riprova.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (stringaLetta==null);
		return numero;
	}
	//metodo che legge double
	public static double leggiDouble() {
		String stringaLetta=null;
		double numero=0;
		do {
			try {
				stringaLetta=tastiera.readLine();
				numero=Double.parseDouble(stringaLetta);
			} catch (NumberFormatException e ) {
				stringaLetta=null;
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (stringaLetta==null);
		return numero;
	}
	
	public static double leggiDouble(String msg) {
		String stringaLetta=null;
		double numero=0;
		do {
			System.out.print(msg);
			try {
				stringaLetta=tastiera.readLine();
				numero=Double.parseDouble(stringaLetta);
			} catch (NumberFormatException e ) {
				stringaLetta=null;
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (stringaLetta==null);
		return numero;
	}
}
