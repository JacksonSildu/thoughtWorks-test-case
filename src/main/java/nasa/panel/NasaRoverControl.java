package nasa.panel;

import nasa.exception.InvalidCommandException;
import nasa.exception.NoRoverException;
import nasa.exception.OutOfBoundsException;
import nasa.interfaces.Control;
import nasa.model.Command;
import nasa.model.Direction;
import nasa.model.Position;
import nasa.model.Rover;
import nasa.model.Signal;
import nasa.utils.DirectionUtils;

/**
 * Implementa��o de controles dos Rovers realizado pela Nasa
 * 
 * @author Sildu
 *
 */
public class NasaRoverControl implements Control {

	private static final String	OUT_OF_BOUNDS			= "Houston we have a problem! Rover fora do terreno no ponto %s cordenada %s";
	private static final String	INVALID_COMMAND			= "O comando %S enviado e invalido.";
	private static final String	ERRO_ROVER_NOT_FOUND	= "O Rover nao foi encontrado. Favor cria-lo.";

	private Position			bounds;

	private Rover				rover;

	public NasaRoverControl() {
		bounds = new Position(0, 0);
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public void setBounds(Position bounds) {
		this.bounds = bounds;
	}

	public Position getBounds() {
		return bounds;
	}

	/**
	 * Recebe o sinal da nasa.
	 */
	public void receiveSignal(Signal signal) {

		if (rover == null) {
			throw new NoRoverException(ERRO_ROVER_NOT_FOUND);
		}

		char[] actions = signal.getSignal().toCharArray();

		for (char action : actions) {
			executeCommand(new Command(action));
		}

	}

	/**
	 * Executa os comandos conforme sinai informados pela Nasa.
	 */
	public void executeCommand(Command command) {
		Direction newDirection;
		Position newPosition;

		// Analisa o comando enviado e a a��o a ser tomada
		switch (command.getAction()) {
		case Command.ROTATE_LEFT:
			newDirection = DirectionUtils.getInstance().rotateLeft(rover.getCurrentDirection());
			rover.setCurrentDirection(newDirection);
			break;
		case Command.ROTATE_RIGHT:
			newDirection = DirectionUtils.getInstance().rotateRight(rover.getCurrentDirection());
			rover.setCurrentDirection(newDirection);
			break;
		case Command.MOVE:
			newPosition = DirectionUtils.getInstance().getNewPosition(rover.getCurrentDirection(), rover.getCurrentPosition());
			// Checa se esta ainda dentro do terreno.
			this.verifyTerrainBound(newPosition);
			rover.setCurrentPosition(newPosition);

			break;
		default:
			throw new InvalidCommandException(String.format(INVALID_COMMAND, command.getAction()));
		}
	}

	public Rover getRover() {
		return rover;
	}

	/**
	 * Cria um novo Rover
	 */
	public void createRover(Position initialPosition, Direction intialDirection) {
		rover = new Rover(initialPosition, intialDirection);
	}

	/**
	 * Verifica se a posi��o do Rover esta dentro no Terreno de marte
	 * 
	 * @param position
	 */
	private void verifyTerrainBound(Position position) {
		if (position.getX() < 0 || position.getX() > bounds.getX()) {
			throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS, "X", position.getX()));
		} else if (position.getY() < 0 || position.getY() > bounds.getY()) {
			throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS, "Y", position.getY()));
		}
	}
}