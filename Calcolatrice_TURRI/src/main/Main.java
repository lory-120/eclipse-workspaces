package main;
import java.text.DecimalFormat;

import model.Calcoli;

public class Main {
    public static void main(String[] args) {

        Calcoli c = new Calcoli(6, 9);
        
        DecimalFormat df2 = new DecimalFormat("0.00");
        DecimalFormat df0 = new DecimalFormat("0");        

        System.out.println("Somma: " + df0.format(c.somma()));
        System.out.println("Differenza: " + df0.format(c.differenza()));
        System.out.println("Prodotto: " + df0.format(c.prodotto()));
        System.out.println("Quoziente: " + df2.format(c.quoziente()));
        
    }
}