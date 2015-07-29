package nasa.interfaces;

import nasa.model.Command;
import nasa.model.Direction;
import nasa.model.Position;
import nasa.model.Rover;
import nasa.model.Signal;

/**
 * Interface de Controle da Nasa
 * 
 * @author Sildu
 *
 */
public interface Control {
	public void setRover(Rover rover);

	public void setBounds(Position bounds);

	public Position getBounds();

	public void receiveSignal(Signal signal);

	public void executeCommand(Command command);

	public Rover getRover();

	public void createRover(Position initialPosition, Direction intialDirection);
}
