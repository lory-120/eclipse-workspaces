package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import utilities.OperazioneNonAmmessaException;
import utilities.PrelievoNonAmmessoException;

public class GestioneCarte {

	//attributi (le carte memorizzate)
	private ArrayList<Carta> carteMemorizzate;
	
	
	//metodi costruttore
	public GestioneCarte() {
		this.carteMemorizzate = new ArrayList<Carta>();
	}
	public GestioneCarte(ArrayList<Carta> carte) {
		this.carteMemorizzate = carte;
	}
	
	
	//metodi della funzione
	
	//metodi pubblici
	public void addCarta(Carta c) {
		this.carteMemorizzate.add(c);
	}
	
	public boolean validaAcquisto(String codice, String cvc, LocalDate purchaseDate, LocalTime purchaseTime, double importo) throws OperazioneNonAmmessaException {
		if(!checkIfTimeIsValid(purchaseDate, purchaseTime)) throw new OperazioneNonAmmessaException("Data e ora dell'operazione non sincronizzati.");
		for(Carta c:carteMemorizzate) { //scorre tra le carte
			//controlla se non è null e se c'è una carta con lo stesso codice e cvc
			if(c != null && c.getCODICE().equals(codice) && c.getCVC().equals(cvc)) {
				try {
					c.preleva(importo);
				} catch(PrelievoNonAmmessoException e) {
					System.out.println(e.getMessage());
					return false;
				}
				return true;
			}
		}
		return false; //(se non trova la carta)
	}
	
	
	//metodi privati
	//controlla se la transazione non è avvenuta in un momento assurdo, che la renderebbe invalida
	private static boolean checkIfTimeIsValid(LocalDate purchaseDate, LocalTime purchaseTime) {
		if(purchaseDate.equals(LocalTime.now())) {
			LocalTime timeToCheck = LocalTime.now();
			LocalTime oneHourBefore = timeToCheck.minusHours(1);
			LocalTime oneHourAfter = timeToCheck.plusHours(1);
			boolean isInInterval = timeToCheck.isAfter(oneHourBefore) && timeToCheck.isBefore(oneHourAfter);
			if(isInInterval) {
				return true;
			}
		}
		return false;
	}
	
}
