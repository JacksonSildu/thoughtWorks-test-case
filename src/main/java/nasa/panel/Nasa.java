package nasa.panel;

import nasa.exception.InvalidPositionException;
import nasa.interfaces.Control;
import nasa.model.Direction;
import nasa.model.Position;
import nasa.model.Signal;
import nasa.utils.ObjectUtils;

/**
 * Classe representando controle da Nasa sobre os Rovers.
 * 
 * @author Sildu
 *
 */
public class Nasa {

	private static final String	INVALID_BOUNDS_LENGHT	= "Favor informar uma tamnho valido para o terreno.";
	private Control	control;

	public Nasa(Position bounds) {
		control = new NasaRoverControl();
		control.setBounds(bounds);

		if (ObjectUtils.getInstance().isNull(bounds) || (bounds.getX() <= 0 || bounds.getY() <= 0)) {
			throw new InvalidPositionException(INVALID_BOUNDS_LENGHT);
		}
	}

	public void sendCommandToRover(Position initialPosition, Direction initialDirection, Signal signal) {
		// Cria um novo Rover
		control.createRover(initialPosition, initialDirection);
		// envia o comando para a central
		control.receiveSignal(signal);
	}

	public String getResults() {
		StringBuilder builder = new StringBuilder(control.getRover().getCurrentPosition().toString());
		builder.append(control.getRover().getCurrentDirection().toString());

		return builder.toString();
	}
}
