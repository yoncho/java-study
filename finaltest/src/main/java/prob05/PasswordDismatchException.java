package prob05;

@SuppressWarnings("serial")
public class PasswordDismatchException extends RuntimeException{
	public PasswordDismatchException() {
	}
	
	public PasswordDismatchException(String message) {
		super(message);
	}
}
