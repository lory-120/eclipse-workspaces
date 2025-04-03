package model.Forza.Bene;

public class Hobbit extends ForzaDelBene {

	public Hobbit(String nome) {
		super(nome);
	}

	@Override
	public int getForza() {
		return (10+(3*super.getExp()));
	}

}
