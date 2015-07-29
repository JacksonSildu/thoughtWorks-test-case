package nasa.test;

import nasa.exception.InvalidDirectionException;
import nasa.exception.InvalidPositionException;
import nasa.exception.OutOfBoundsException;
import nasa.model.Direction;
import nasa.model.Position;
import nasa.model.Signal;
import nasa.panel.Nasa;

import org.junit.Assert;
import org.junit.Test;

public class NasaTests {

	@Test
	public void shouldShowAValidResult() {
		Nasa nasa = new Nasa(new Position(5, 5));

		nasa.sendCommandToRover(new Position(1, 2), new Direction('N'), new Signal("LMLMLMLMM"));
		Assert.assertEquals("1 3 N", nasa.getResults());

		nasa.sendCommandToRover(new Position(3, 3), new Direction('E'), new Signal("MMRMMRMRRM"));
		Assert.assertEquals("5 1 E", nasa.getResults());
	}

	@Test(expected = InvalidDirectionException.class)
	public void shouldThrowAnInvalidDirectionException() {
		Nasa nasa = new Nasa(new Position(5, 5));
		nasa.sendCommandToRover(new Position(1, 2), new Direction('e'), new Signal("LMLMLMLMM"));
	}

	@Test(expected = OutOfBoundsException.class)
	public void shouldThrowAnOutOfBoundsException() {
		Nasa nasa = new Nasa(new Position(5, 1));
		nasa.sendCommandToRover(new Position(1, 2), new Direction('N'), new Signal("LMLMLMLMM"));
	}

	@Test(expected = InvalidPositionException.class)
	public void shouldThrowAnInvalidPositionExceptionDueNullBounds() {
		Nasa nasa = new Nasa(null);
		nasa.sendCommandToRover(new Position(1, 2), new Direction('N'), new Signal("LMLMLMLMM"));
	}

	@Test(expected = InvalidPositionException.class)
	public void shouldThrowAnInvalidPositionExceptionDueZeroBounds() {
		Nasa nasa = new Nasa(new Position(0, 0));
		nasa.sendCommandToRover(new Position(1, 2), new Direction('N'), new Signal("LMLMLMLMM"));
	}

	@Test(expected = InvalidPositionException.class)
	public void shouldThrowAnInvalidPositionExceptionDueXNegativeBounds() {
		Nasa nasa = new Nasa(new Position(-1, 5));
		nasa.sendCommandToRover(new Position(1, 2), new Direction('N'), new Signal("LMLMLMLMM"));
	}

	@Test(expected = InvalidPositionException.class)
	public void shouldThrowAnInvalidPositionExceptionDueYNegativeBounds() {
		Nasa nasa = new Nasa(new Position(3, -1));
		nasa.sendCommandToRover(new Position(1, 2), new Direction('N'), new Signal("LMLMLMLMM"));
	}

}
