package exceptions;

public class BancaException extends Exception {

	public BancaException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return this.getMessage();
	}

}
