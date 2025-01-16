package test;

public class MainTest {
	public static void main(String[] args) {
		Studente s = new Studente("lore", "turri", 17, "TRRLNZ");
		String sTokenized = s.toString();
		System.out.println(sTokenized);
	}
}
