package main;
import model.*;
import presentation.*;

public class MainAutonoleggio {
	
	public static void main(String args[]) {
		Autonoleggio autonoleggio = new Autonoleggio(50);
		MenuAutonoleggio menu = new MenuAutonoleggio(autonoleggio);
		menu.runMenu();
	}
	
}
