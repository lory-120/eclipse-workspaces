package model;

public class Libro {
	private final String TITOLO;
	private final String AUTORE;
	private final int NUM_PAGINE;
	
	public final static double COSTO_FISSO=5.5;
	private static double costoPagina=0.05;
	
	public Libro(String TITOLO, String AUTORE, int NUM_PAGINE) {
		this.TITOLO=TITOLO;
		this.AUTORE=AUTORE;
		this.NUM_PAGINE=NUM_PAGINE;
	}

	public static double getCostoPagina() {
		return costoPagina;
	}

	public static void setCostoPagina(double costoPagina) {
		Libro.costoPagina = costoPagina;
	}

	public String getTITOLO() {
		return TITOLO;
	}

	public String getAUTORE() {
		return AUTORE;
	}

	public int getNUM_PAGINE() {
		return NUM_PAGINE;
	}
	
	public double getPrezzo() {
		return COSTO_FISSO+(costoPagina*NUM_PAGINE);
	}
	@Override
	public String toString() {
		return "Libro - \nTITOLO:" + TITOLO 
				+ "\nAUTORE: " + AUTORE 
				+ "\nNUM_PAGINE: " + NUM_PAGINE
				+ "\nCOSTO FISSO: "+COSTO_FISSO
				+ "\nCosto per pagina: "+costoPagina
				+ "\nCosto totale del libro: " + COSTO_FISSO+(costoPagina*NUM_PAGINE);
	}
	
	
}
