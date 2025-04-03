package model.Forza.Bene;

public class Uomo extends ForzaDelBene {

	public Uomo(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getForza() {
		return (30+(6*super.getExp()));
	}

}
