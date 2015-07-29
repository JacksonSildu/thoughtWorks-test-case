package nasa.exception;

public class InvalidDirectionException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public InvalidDirectionException(String message) {
		super(message);
	}

}
