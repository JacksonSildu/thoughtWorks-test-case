package nasa.exception;

public class InvalidPositionException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public InvalidPositionException(String message) {
		super(message);
	}

}
