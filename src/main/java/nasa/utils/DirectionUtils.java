package nasa.utils;

import nasa.exception.InvalidDirectionException;
import nasa.exception.InvalidPositionException;
import nasa.model.Direction;
import nasa.model.Position;

public class DirectionUtils {

	private static final String		INVALID_POSITION	= "A posicao %s informada e invalida.";
	private static final String		INVALID_DIRECTION	= "A direcao %s informada e invalida.";
	private static DirectionUtils	instance;

	private DirectionUtils() {
	}

	public synchronized static DirectionUtils getInstance() {
		if (instance == null) {
			instance = new DirectionUtils();
		}

		return instance;
	}

	/**
	 * Rotaciona o rover em 90 graus a direita
	 * 
	 * @param direction
	 * @return
	 */
	public Direction rotateRight(Direction direction) {

		if (ObjectUtils.getInstance().isNull(direction)) {
			throw new InvalidDirectionException(String.format(INVALID_DIRECTION, "NULL"));
		}

		switch (direction.getDirection()) {
		case Direction.NORTH:
			return new Direction(Direction.EAST);
		case Direction.EAST:
			return new Direction(Direction.SOUTH);
		case Direction.SOUTH:
			return new Direction(Direction.WEST);
		case Direction.WEST:
			return new Direction(Direction.NORTH);

		default:
			throw new InvalidDirectionException(String.format(INVALID_DIRECTION, direction.getDirection()));
		}

	}

	/**
	 * Rotaciona o rover em 90 graus a esquerda.
	 * 
	 * @param direction
	 * @return
	 */
	public Direction rotateLeft(Direction direction) {

		if (ObjectUtils.getInstance().isNull(direction)) {
			throw new InvalidDirectionException(String.format(INVALID_DIRECTION, "NULL"));
		}

		switch (direction.getDirection()) {
		case Direction.NORTH:
			return new Direction(Direction.WEST);
		case Direction.WEST:
			return new Direction(Direction.SOUTH);
		case Direction.SOUTH:
			return new Direction(Direction.EAST);
		case Direction.EAST:
			return new Direction(Direction.NORTH);

		default:
			throw new InvalidDirectionException(String.format(INVALID_DIRECTION, direction.getDirection()));
		}

	}

	/**
	 * Calcula a nova Posi��o do Rover de acordo com suas coordenadas.
	 * 
	 * @param direction
	 * @param position
	 * @return
	 */
	public Position getNewPosition(Direction direction, Position position) {
		if (ObjectUtils.getInstance().isNull(direction)) {
			throw new InvalidDirectionException(String.format(INVALID_DIRECTION, "NULL"));
		} else if (ObjectUtils.getInstance().isNull(position)) {
			throw new InvalidPositionException(String.format(INVALID_POSITION, "NULL"));
		}

		switch (direction.getDirection()) {
		case Direction.NORTH:
			return new Position(position.getX(), position.getY() + 1);
		case Direction.EAST:
			return new Position(position.getX() + 1, position.getY());
		case Direction.SOUTH:
			return new Position(position.getX(), position.getY() - 1);
		case Direction.WEST:
			return new Position(position.getX() - 1, position.getY());
		default:
			throw new InvalidDirectionException(String.format(INVALID_DIRECTION, direction.getDirection()));
		}

	}
}
