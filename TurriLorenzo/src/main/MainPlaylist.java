package main;
import model.*;

public class MainPlaylist {

	public static void main(String[] args) {
		
		Playlist playlist = new Playlist();
		System.out.println("Playlist creata: " + playlist.getNome());
		
		playlist.addBrano(new Brano("brano 1",  100, "Stagnitta", Genere.RAP));
		playlist.addBrano(new Brano("Don't Stop the Music", 250, "Rihanna", Genere.POP));
		playlist.addBrano(new Brano("Mangio cannoli", 200, "Stagnitta", Genere.CLASSICO));
		playlist.addBrano(new Brano("Pasta al ragù", 300, "Mario", Genere.RAP));
		
		playlist.addBranoPreferito("Don't Stop the Music");
		playlist.viewBraniPreferiti();
		
		if(playlist.removeBranoTitolo("Titolo Inesistente")) {
			System.out.println("Brano dal titolo inesistente rimosso.");
		} else {
			System.out.println("Brano dal titolo inesistente non rimosso.");
		}
		
		int durata = 150;
		System.out.println("Ecco tutti i brani di durata maggiore di "+durata+" secondi:");
		playlist.viewBraniDurataMaggiore(durata);
		
		System.out.println("\n\nEcco tutti i brani di durata minore di "+durata+" secondi:");
		playlist.viewBraniDurataMinore(durata);
		
		System.out.println("Durata tot della playlist: "+playlist.getDurataTot());
		
	}

}
