package nasa.test;

import nasa.exception.InvalidDirectionException;
import nasa.exception.InvalidPositionException;
import nasa.model.Direction;
import nasa.utils.DirectionUtils;

import org.junit.Assert;
import org.junit.Test;

public class DirectionUtilsTest {

	@Test(expected = InvalidDirectionException.class)
	public void shouldThrowAnInvalidDiectionException() {
		DirectionUtils.getInstance().rotateLeft(null);
	}

	@Test(expected = InvalidPositionException.class)
	public void shouldThrowAnInvalidPositionException() {
		DirectionUtils.getInstance().getNewPosition(new Direction('S'), null);
	}

	@Test(expected = InvalidDirectionException.class)
	public void shouldThrowAnInvalidDirectionExceptionForEmptyValue() {
		DirectionUtils.getInstance().rotateLeft(new Direction(' '));
	}

	@Test
	public void shouldGetSouthDirection() {
		Assert.assertEquals(DirectionUtils.getInstance().rotateLeft(new Direction('W')).toString(), Character.toString(Direction.SOUTH));
	}

}