package model.Forza.Male;

public class Sudrone extends ForzaDelMale {

	public Sudrone(String nome) {
		super(nome);
	}

	@Override
	public int getForza() {
		return (40+(5*super.getExp()));
	}

}
