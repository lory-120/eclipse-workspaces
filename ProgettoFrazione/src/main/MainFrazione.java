package main;
import model.*;
import presentation.*;

public class MainFrazione {
	public static void main(String args[]) {
		Frazione f1 = new Frazione(1, 0);
		Frazione f2 = new Frazione(3, 6);
		Frazione f3 = new Frazione(5, 6);
		
		System.out.println("test");
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		System.out.println(f3.toString());
	}
}
