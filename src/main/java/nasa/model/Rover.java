package nasa.model;

/**
 * Modelo de informacoes do rover
 * 
 * @author Sildu
 *
 */
public class Rover {
	private Position	currentPosition;
	private Direction	currentDirection;

	public Rover(Position initialPosition, Direction initialDirection) {
		currentPosition = initialPosition;
		currentDirection = initialDirection;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}
}
