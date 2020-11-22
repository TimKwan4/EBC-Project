package example.puzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.model.GameOverType;
import example.puzzle.model.Model;
import example.puzzle.model.MoveType;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

class TestGameStateController {

	@Test
	void testWin() {
		Model m = new Model();
		Puzzle p = new Puzzle(3);
		m.setPuzzle(p);
		PuzzleApp app = new PuzzleApp(m);
		Tile tile = new Tile(9);
		m.getPuzzle().add(tile, 1, 0);
		m.getPuzzle().add(new Tile(1), 1, 1);
		
		//select tile to move
		m.setSelectedTile(tile);
		
		//move it up
		new MoveTileController(m, app).move(MoveType.Right);
		
		new GameStateController(m, app).updateGame();
		
		//9+1 should equal 10
		assertEquals(GameOverType.Win, m.getGameOver());
	}
	
	@Test
	void testLose() {
		Model m = new Model();
		Puzzle p = new Puzzle(3);
		m.setPuzzle(p);
		PuzzleApp app = new PuzzleApp(m);
		Tile tile = new Tile(9);
		m.getPuzzle().add(tile, 1, 1);
		m.getPuzzle().add(new Tile(1), 1, 2);
		
		//select tile to move
		m.setSelectedTile(tile);
		
		//move it up
		new MoveTileController(m, app).move(MoveType.Right);
		
		new GameStateController(m, app).updateGame();
		
		//9+1 should equal 10
		assertEquals(GameOverType.Lose, m.getGameOver());
	}
	

}
