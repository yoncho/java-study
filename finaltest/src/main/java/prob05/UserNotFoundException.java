package prob05;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
	}
	public UserNotFoundException(String message) {
		super(message);
	}
}
