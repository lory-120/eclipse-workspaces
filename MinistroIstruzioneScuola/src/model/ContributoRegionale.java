package model;

public enum ContributoRegionale {
    ABRUZZO(100),
    BASILICATA(120),
    CALABRIA(110),
    CAMPANIA(130),
    EMILIA_ROMAGNA(140),
    FRIULI_VENEZIA_GIULIA(150),
    LAZIO(135),
    LIGURIA(125),
    LOMBARDIA(160),
    MARCHE(115),
    MOLISE(105),
    PIEMONTE(145),
    PUGLIA(120),
    SARDEGNA(130),
    SICILIA(125),
    TOSCANA(140),
    TRENTINO_ALTO_ADIGE(150),
    UMBRIA(110),
    VALLE_D_AOSTA(140),
    VENETO(155);

    private final double contributo;

    ContributoRegionale(double contributo) {
    this.contributo = contributo;
    }

    public double getContributo() {
    return contributo;
    }
//     ESEMPIO:
//     double contributo=ContributoRegionale.TOSCANA.getContributo();
//        System.out.println(contributo);
   
   
}