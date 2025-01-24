package model;
import java.time.*;
import java.util.ArrayList;

public class Prestito {

	//attributi
	private Persona PrestatoAChi; //persona al quale si è prestato il libro/i
	private ArrayList<Libro> libriInPrestito = new ArrayList<>();
	private LocalDate dataInizioPrestito;
	private LocalDate dataFinePrestito;
	
	//metodi costruttori
	public Prestito(Persona PrestatoAChi, ArrayList<Libro> libriInPrestito, LocalDate dataInizioPrestito, LocalDate dataFinePrestito) {
		this.PrestatoAChi = PrestatoAChi;
		this.libriInPrestito = libriInPrestito;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataFinePrestito = dataFinePrestito;
	}
	public Prestito(Persona PrestatoAChi, Libro libroInPrestito, LocalDate dataInizioPrestito, LocalDate dataFinePrestito) {
		this.PrestatoAChi = PrestatoAChi;
		this.libriInPrestito.add(libroInPrestito);
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataFinePrestito = dataFinePrestito;
	}
	
	//metodi get/set
	public Persona getPrestatoAChi() {
		return PrestatoAChi;
	}
	public void setPrestatoAChi(Persona prestatoAChi) {
		PrestatoAChi = prestatoAChi;
	}
	public ArrayList<Libro> getLibriInPrestito() {
		return libriInPrestito;
	}
	public void setLibriInPrestito(ArrayList<Libro> libriInPrestito) {
		this.libriInPrestito = libriInPrestito;
	}
	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}
	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}
	public LocalDate getDataFinePrestito() {
		return dataFinePrestito;
	}
	public void setDataFinePrestito(LocalDate dataFinePrestito) {
		this.dataFinePrestito = dataFinePrestito;
	}
	
	
	//meotdi della funzione
	public void prendiInPrestitoLibro(Libro libroPrestato) { //richiama per prendere un libro in prestito
		libriInPrestito.add(libroPrestato);
	}
	
	public boolean restituisciLibro(String titolo) {
		for(int i=0; i<libriInPrestito.size(); i++) {
			if(libriInPrestito.get(i).getTitolo().equals(titolo)) {
				libriInPrestito.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Prestito [PrestatoAChi=" + PrestatoAChi + ", libriInPrestito=" + libriInPrestito.toString()
				+ ", dataInizioPrestito=" + dataInizioPrestito + ", dataFinePrestito=" + dataFinePrestito + "]";
	}	
	
}
