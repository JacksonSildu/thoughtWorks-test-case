package nasa.model;

/**
 * Modelo de Direção do Rover
 * 
 * @author Sildu
 *
 */
public class Direction {
	public static final char	WEST	= 'W';
	public static final char	SOUTH	= 'S';
	public static final char	EAST	= 'E';
	public static final char	NORTH	= 'N';
	private char				direction;

	public Direction(char direction) {
		this.direction = direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public char getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return String.valueOf(direction);
	}
}
