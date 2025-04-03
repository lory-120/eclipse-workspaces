package model.Forza.Male;

public class Urukhai extends ForzaDelMale {

	public Urukhai(String nome) {
		super(nome);
	}

	@Override
	public int getForza() {
		return (50+(5*super.getExp()));
	}

}
