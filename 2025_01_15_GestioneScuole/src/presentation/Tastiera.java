package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {
	private static InputStreamReader input=new InputStreamReader(System.in);
	private static BufferedReader tastiera=new BufferedReader(input);
	
	public static String leggiStringa() {
		String stringaInput=null;
		try {
			stringaInput=tastiera.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stringaInput;
	}
	
	public static String leggiStringa(String msg) {
		String stringaInput=null;
		System.out.println(msg);
		try {
			stringaInput=tastiera.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stringaInput;
	}
	
	public static int leggiInt() {
		String stringaInput=null;
		int numero = 0;
		do {
			try {
				stringaInput = tastiera.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				numero = Integer.parseInt(stringaInput);
			} catch (NumberFormatException e) {
				System.out.println("Inserimento non corretto! Riprova!");
				stringaInput = null;
			} 
		} while (stringaInput==null);
		
		return numero;
	}
	
	public static int leggiInt(String msg) {
		String stringaInput=null;
		int numero = 0;
		do {
			System.out.println(msg);
			try {
				stringaInput = tastiera.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				numero = Integer.parseInt(stringaInput);
			} catch (NumberFormatException e) {
				System.out.println("Inserimento non corretto! Riprova!");
				stringaInput = null;
			} 
		} while (stringaInput==null);
		
		return numero;
	}
	
	public static double leggiDouble() {
		String stringaInput=null;
		double numero = 0;
		do {
			try {
				stringaInput = tastiera.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				numero = Double.parseDouble(stringaInput);
			} catch (NumberFormatException e) {
				System.out.println("Inserimento non corretto! Riprova!");
				stringaInput = null;
			} 
		} while (stringaInput==null);
		
		return numero;
	}
	
	public static double leggiDouble(String msg) {
		String stringaInput=null;
		double numero = 0;
		do {
			System.out.println(msg);
			try {
				stringaInput = tastiera.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				numero = Double.parseDouble(stringaInput);
			} catch (NumberFormatException e) {
				System.out.println("Inserimento non corretto! Riprova!");
				stringaInput = null;
			} 
		} while (stringaInput==null);
		
		return numero;
	}
}
