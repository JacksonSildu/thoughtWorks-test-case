package nasa.model;

/**
 * Modelo de sinais a ser enviado para o Rover
 * 
 * @author Sildu
 *
 */
public class Signal {
	public String	signal;

	public Signal(String signal) {
		this.signal = signal;
	}

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}
}
