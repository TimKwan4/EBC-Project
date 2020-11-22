package example.puzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.boundary.PuzzlePanel;
import example.puzzle.model.Model;
import example.puzzle.model.MoveType;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

class TestResetController {

	@Test
	void testReset() {
		Model model = new Model();
		PuzzleApp app = new PuzzleApp(model);
		Puzzle p = new Puzzle(3);
		model.setPuzzle(p);
		
		Tile t = new Tile(1);
		model.getPuzzle().add(t, 1, 0);
		Tile t2 = new Tile(2);
		model.getPuzzle().add(t2, 1, 1);
		model.setSelectedTile(t);
		
		//move a piece to change the puzzle's state
		model.tryMove(MoveType.Right);
		
		new ResetController(model, app).reset();
		
		Tile searching = new Tile(-1);
		for (Tile tile : p) {
			if ((tile.getRow() == t.getRow()) && (tile.getColumn() == t.getColumn())) {
				searching = tile;
			}
		}
		
		assertEquals(1, searching.getNumber());
		
		
	}

}
