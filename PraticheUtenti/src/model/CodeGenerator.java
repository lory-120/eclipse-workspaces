package model;

public class CodeGenerator {

	private static int code = 1;
	
	public static int getNewCode() {
		code++;
		return code;
	}
	
}
