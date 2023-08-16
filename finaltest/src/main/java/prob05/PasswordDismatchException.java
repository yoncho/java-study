package prob05;

@SuppressWarnings("serial")
public class PasswordDismatchException extends RuntimeException{
	public PasswordDismatchException() {
		super("Password Dismatch");
	}
	
	public PasswordDismatchException(String message) {
		super(message);
	}
}
