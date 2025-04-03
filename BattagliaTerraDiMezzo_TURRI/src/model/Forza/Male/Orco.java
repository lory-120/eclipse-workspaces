package model.Forza.Male;

public class Orco extends ForzaDelMale {

	public Orco(String nome) {
		super(nome);
	}

	@Override
	public int getForza() {
		if(super.getExp() < 5) {
			return (30+(2*super.getExp()));
		} else {
			return (70+(3*super.getExp()));
		}
	}

}
