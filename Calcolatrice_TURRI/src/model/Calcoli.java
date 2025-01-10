package model;

public class Calcoli {
    double n1=0, n2=0;

    public Calcoli(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public double somma() {
        return n1 + n2;
    }

    public double differenza() {
        return n1 - n2;
    }

    public double prodotto() {
        return n1 * n2;
    }

    public double quoziente() {
        return n1 / n2;
    }


}
