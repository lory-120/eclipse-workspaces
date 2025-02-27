package model;

import utilities.PrelievoNonAmmessoException;

public class CartaBronze extends Carta {

	private boolean haPrelevato;
	
	public CartaBronze(double saldoIniziale) {
		super(saldoIniziale);
	}

	//metodo della classe padre che era abstract
	@Override
	public void preleva(double importo) throws PrelievoNonAmmessoException {
		
		if(this.haPrelevato) throw new PrelievoNonAmmessoException("Impossibile prelevare. Con il piano Bronze puoi prelevare una singola volta.");
		if(this.saldo < importo) throw new PrelievoNonAmmessoException("Impossibile prelevare l'importo. Saldo disponibile: " + Double.toString(this.saldo) + "€.");
		
		this.saldo = 0;
		this.haPrelevato = true;
		
	}

	
	public boolean haPrelevato() {
		return haPrelevato;
	}

	public void setHaPrelevato(boolean haPrelevato) {
		this.haPrelevato = haPrelevato;
	}
	
}
