package example.puzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.boundary.PuzzlePanel;
import example.puzzle.model.Model;
import example.puzzle.model.Tile;

class TestSelectTile {
	
	

	@Test
	void testProcess() {
		Model m = new Model();
		PuzzleApp app = new PuzzleApp(m);
		Tile t = new Tile(1);
		m.getPuzzle().add(t, 1, 1);
		
		//(200,200) should be in the center tile
		new SelectTileController(m,app).process(new Point(200,200));
		
		assertEquals(t, m.getSelectedTile());
		
	}
	
	@Test
	void testComputeRect() {
		Model m = new Model();
		PuzzlePanel p = new PuzzlePanel(m);
		Tile t = new Tile(1);
		m.getPuzzle().add(t, 1, 1);
		
		assertEquals(t.getColumn()*125, p.computeRectangle(t).x);
		
	}

}
