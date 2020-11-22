package example.puzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestModel {

	@Test
	void testConstruction() {
		Model m = new Model();
		
		assertNotNull(m);
	}
	
	@Test
	void testPuzzle() {
		Model m = new Model();
		Puzzle p = new Puzzle(3);
		
		m.setPuzzle(p);
		
		assertNotNull(m.getPuzzle());
	}
	
	@Test
	void testSelectedTile() {
		Model m = new Model();
		Tile t = new Tile(1,2,3);
		
		m.setSelectedTile(t);
		
		assertNotNull(m.getSelectedTile());
	}
	
	@Test
	void testGameOver() {
		Model m = new Model();
		GameOverType g = GameOverType.Running;
		
		m.setGameOver(g);
		
		assertEquals(GameOverType.Running, m.isGameOver());
	}

}
