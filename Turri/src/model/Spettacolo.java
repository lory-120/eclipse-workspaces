package model;
import java.time.*;
import java.util.*;

public class Spettacolo {

	//attributi
	private String nome;
	private double prezzo;
	private LocalDate data;
	private LocalTime ora;
	private Sala sala;
	
	//metodo costruttore
	public Spettacolo(String nome, double prezzo, LocalDate data, LocalTime ora, Sala sala) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.data = data;
		this.ora = ora;
		this.sala = sala;
	}
	
	//metodi get/set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
	
}
