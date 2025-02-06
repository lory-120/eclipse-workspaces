package utilities;

@SuppressWarnings("serial")
public class ScuolaNonPresenteException extends RuntimeException {
	
	public ScuolaNonPresenteException() {
		super("Non è presente nessuna scuola");
	}
	
	public ScuolaNonPresenteException(String msg) {
		super(msg);
	}
	
}
