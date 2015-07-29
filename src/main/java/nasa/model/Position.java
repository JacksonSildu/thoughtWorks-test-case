package nasa.model;

/**
 * Modelo de formato de Posição do terreno
 * 
 * @author Sildu
 *
 */
public class Position {
	private static final String	SPACE	= " ";

	private int					x;
	private int					y;

	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(x);
		builder.append(SPACE);
		builder.append(y);
		builder.append(SPACE);

		return builder.toString();
	}
}
