package model;
import java.lang.Math;

public class Frazione {
	//attributi
	private int num;
	private int den;

	//costruttori
	//costr. di default
	public Frazione() {
		this.num = 0;
		this.den = 1;
	}
	//costruttore classico
	public Frazione(int num, int den) {
		this.num = num;
		
		if(den != 0) {
			this.den = den;
		} else {
			den = 1;
		}
		
		semplifica();
	}
	
	//metodi get/set
	public void setNum(int num) {
		this.num = num;
	}
	public void setDen(int den) {
		if(den != 0) {
			this.den = den;
		} else {
			den = 1;
		}
	}
	
	public int getNum() {
		return num;
	}
	public int getDen() {
		return den;
	}
	
	//altri metodi
	private void semplifica() {
		int MCD = MCD(this.num, this.den);
		
		this.num /= MCD;
		this.den /= MCD;
	}
	private int MCD(int a, int b) { //algoritmo di Euclide per torvare l'MCD
		a = Math.abs(a);
		b = Math.abs(b);
		
		while(a != b) {
			if(a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		
		return a;
	}
	
	
	public Frazione somma(Frazione f) {
		int risNum = f.getNum()*this.den + this.num*f.getDen();
		int risDen = f.getDen()*this.den;
		
		return new Frazione(risNum, risDen);		
	}
	
	public Frazione differenza(Frazione f) {
		int risNum = f.getNum()*this.den - this.num*f.getDen();
		int risDen = f.getDen()*this.den;
		
		return new Frazione(risNum, risDen);
	}
	
	public Frazione prodotto(Frazione f) {
		int risNum = f.getNum() * this.num;
		int risDen = f.getDen() * this.den;
		
		return new Frazione(risNum, risDen);
	}
	
	public Frazione divisione(Frazione f) {
		return this.prodotto(f.inverso()); //la frazione nell'istanza per l'inverso di f
		//non si semplifica qua, perché lo semplifica di già nel costrutto "Frazione"
	}
	
	public Frazione inverso() {
		return new Frazione(den, num);
	}
	
	public Frazione opposto() {
		return new Frazione(-num, den);
	}
	
	public Frazione potenza(int esp) {
		if(esp == 0) {
			return new Frazione(1, 1);
		} else if(esp == 1) {
			return new Frazione(this.num, this.den);
		} else if(esp < 0) {
			return this.inverso().potenza(-esp); //è ricorsivo, richiama la funzione stessa
		} else {
			return new Frazione(
						(int)(Math.pow((double)this.num, (double)esp)),
						(int)(Math.pow((double)this.den, (double)esp))
					);		
		}
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Frazione: \n"
				+ "numeratore = " + num + ", denominatore =" + den + "\n";
	}
	 
}