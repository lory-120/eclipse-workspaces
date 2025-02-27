package model;

import utilities.PrelievoNonAmmessoException;

public class CartaSilver extends Carta {

	public CartaSilver(double saldoIniziale) {
		super(saldoIniziale);
	}

	@Override
	public void preleva(double importo) throws PrelievoNonAmmessoException {
		if(this.saldo < importo) throw new PrelievoNonAmmessoException("Impossibile prelevare l'importo. Saldo disponibile: " + Double.toString(this.saldo) + "€.");
		
		this.saldo -= importo;
	}
	
}
