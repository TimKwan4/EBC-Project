package example.puzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPuzzle {

	@Test
	void testConstruction() {
		Puzzle p = new Puzzle(3);
		
		assertNotNull(p);
	}
	
	@Test
	void testTiles() {
		Puzzle p = new Puzzle(3);
		p.add(new Tile(1), 2, 3);
		
		assertTrue(p.iterator().hasNext());
	}

}
