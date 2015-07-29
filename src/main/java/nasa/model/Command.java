package nasa.model;

/**
 * Modelo de comando
 * 
 * @author Sildu
 *
 */
public class Command {

	public static final char	ROTATE_LEFT		= 'L';
	public static final char	ROTATE_RIGHT	= 'R';
	public static final char	MOVE			= 'M';

	private char				action;

	public Command(char action) {
		this.action = action;
	}

	public char getAction() {
		return action;
	}

	public void setAction(char action) {
		this.action = action;
	}
}
