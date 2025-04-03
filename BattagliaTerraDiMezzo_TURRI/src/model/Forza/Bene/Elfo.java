package model.Forza.Bene;

public class Elfo extends ForzaDelBene {

	public Elfo(String nome) {
		super(nome);
	}

	@Override
	public int getForza() {
		if(super.getExp() < 5) {
			return (20+(3*super.getExp()));
		} else {
			return (80+(2*super.getExp()));
		}
	}

}
