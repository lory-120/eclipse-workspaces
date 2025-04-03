package model.Forza.Bene;

public class Nano extends ForzaDelBene {

	public Nano(String nome) {
		super(nome);
	}

	@Override
	public int getForza() {
		return (20+(4*super.getExp()));
	}

}
