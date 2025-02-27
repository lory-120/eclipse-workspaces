package model;

import utilities.ErroreRicaricaException;
import utilities.PrelievoNonAmmessoException;

public class CartaGold extends Carta {

	public CartaGold(double saldoIniziale) {
		super(saldoIniziale);
	}

	@Override
	public void preleva(double importo) throws PrelievoNonAmmessoException {
		if(this.saldo < importo) throw new PrelievoNonAmmessoException("Impossibile prelevare l'importo. Ricarica la carta. Saldo disponibile: " + Double.toString(this.saldo) + "€.");
		
		this.saldo -= importo;
	}
	
	public void ricarica(double importo) throws ErroreRicaricaException {
		if(importo <= 0) throw new ErroreRicaricaException("Non puoi ricaricare la tua carta con " + Double.toString(importo) + "€.");
		
		this.saldo += importo;
	}

}
