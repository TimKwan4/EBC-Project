package example.puzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCoordinate {

	@Test
	void testConstructionGetters() {
		Coordinate c = new Coordinate(2,3);
		
		boolean stillTrue = true;
		
		stillTrue = stillTrue && (2 == c.getRow());
		
		stillTrue = stillTrue && (3 == c.getCol());
		
		assertTrue(stillTrue);
		
	}

}
