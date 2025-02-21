package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import utilities.ScuolaNonPresenteException;

public class GestioneScuole {
	
	//attributi	
	ArrayList<Scuola> scuole;
	
	
	//metodo costruttore	
	public GestioneScuole() {
		scuole = new ArrayList<Scuola>();
	}
	
	public GestioneScuole(ArrayList<Scuola> scuole) {
		this.scuole = scuole;
	}
	
	
	//metodi della funzione
	public boolean aggiungiScuola(Scuola s) {
		return scuole.add(s);
	}
	
	public boolean rimuoviScuola(String src) {
		for(int i=0; i<scuole.size(); i++) {
			if(scuole.get(i).getNome().equals(src)) {
				scuole.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Scuola> getElementari() throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i) instanceof ScuolaElementare)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole di questo tipo");

	    return app;
	}

	public ArrayList<Scuola> getMedie() throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i) instanceof ScuolaMedia)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole di questo tipo");

	    return app;
	}

	public ArrayList<Scuola> getLicei() throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i) instanceof Liceo)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole di questo tipo");

	    return app;
	}

	public ArrayList<Scuola> getProfessionali() throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i) instanceof Professionale)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole di questo tipo");

	    return app;
	}

	public ArrayList<Scuola> getTecnici() throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i) instanceof Tecnico)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole di questo tipo");

	    return app;
	}
	
	public ArrayList<Scuola> getScuolePerCitta(String citta) throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i).getCitta().equals(citta))
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole in questa citta");

	    return app;
	}
	
	public ArrayList<Scuola> getScuoleSopraSoglia(double soglia) throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i).getContributoTotale()>soglia)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole con contributi sopra i " + soglia + "€");

	    return app;
	}
	
	public ArrayList<Scuola> getScuoleSopraStudenti(int studenti) throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i).getnStudenti()>studenti)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole con più di " + studenti + " studenti");

	    return app;
	}
	
	public ArrayList<Scuola> getScuoleSopraStudenti_Laboratori(int studenti, int laboratori) throws ScuolaNonPresenteException {
	    ArrayList<Scuola> app = new ArrayList<Scuola>();

	    for (int i = 0; i < scuole.size(); i++) {
	        if (scuole.get(i).getnStudenti()>studenti && scuole.get(i).getnLab()>laboratori)
	            app.add(scuole.get(i));
	    }

	    if (app.size() == 0) throw new ScuolaNonPresenteException("Non sono presenti scuole con più di " + studenti + " studenti e " + laboratori + " laboratori");

	    return app;
	}
	
	public Scuola getScuolaPerDenominazione(String denominazione) throws ScuolaNonPresenteException {
		for(int i=0;i<scuole.size();i++) {
			if(scuole.get(i).getNome().equals(denominazione))
				return scuole.get(i);
		}
		throw new ScuolaNonPresenteException("Non è presente nessuna scuola con denominazione " + denominazione);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void salvaScuole(String fileName) throws FileNotFoundException, IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
		for(Scuola s:scuole) {
			writer.write(s.getCSVString() + "\n");
		}
		
		writer.close();
	}
	
	public void caricaScuole(String fileName) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		String temp;
		while((temp = reader.readLine()) != null) {
			String params[] = temp.split(";");
			
			switch(params[0]) {
				case "ScuolaElementare" -> scuole.add(new ScuolaElementare(params));
				case "ScuolaMedia" -> scuole.add(new ScuolaMedia(params));
				case "Liceo" -> scuole.add(new Liceo(params));
				case "Professionale" -> scuole.add(new Professionale(params));
				case "Tecnico" -> scuole.add(new Tecnico(params));
				default -> {
					throw new ScuolaNonPresenteException();
				}
			}
		}
		
		reader.close();		
	}
	
	
	//toString	
	public String toString() {
		String app=this.getClass().getSimpleName();
		for(int i=0;i<scuole.size();i++) {
			app+="\n" + scuole.get(i) + "\n";
		}
		return app;
	}
}
