package example.puzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.model.Model;
import example.puzzle.model.MoveType;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

class TestMoveTile {

	@Test
	void testAddMove() {
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
		
		//find center tile
		Tile center = new Tile(0);
		for (Tile x : m.getPuzzle()) {
			if ((x.getRow() == 1) && (x.getColumn() == 1)) {
				center = x;
			}
		}
		
		//9+1 should equal 10
		assertEquals(center.getNumber(), 10);
	}
	
	@Test
	void testSubtractMove() {
		Model m = new Model();
		Puzzle p = new Puzzle(3);
		m.setPuzzle(p);
		PuzzleApp app = new PuzzleApp(m);
		Tile tile = new Tile(1);
		m.getPuzzle().add(tile, 1, 1);
		m.getPuzzle().add(new Tile(9), 1, 0);
		
		//select tile to move
		m.setSelectedTile(tile);
		
		//move it left
		new MoveTileController(m, app).move(MoveType.Left);
		
		//find center tile
		Tile center = new Tile(0);
		for (Tile x : m.getPuzzle()) {
			if ((x.getRow() == 1) && (x.getColumn() == 0)) {
				center = x;
			}
		}
		
		//9-1 should equal 8
		assertEquals(center.getNumber(), 8);
	}
	
	@Test
	void testMultiplyMove() {
		Model m = new Model();
		Puzzle p = new Puzzle(3);
		m.setPuzzle(p);
		PuzzleApp app = new PuzzleApp(m);
		Tile tile = new Tile(2);
		m.getPuzzle().add(tile, 1, 1);
		m.getPuzzle().add(new Tile(4), 0, 1);
		
		//select tile to move
		m.setSelectedTile(tile);
		
		//move it left
		new MoveTileController(m, app).move(MoveType.Up);
		
		//find center tile
		Tile center = new Tile(0);
		for (Tile x : m.getPuzzle()) {
			if ((x.getRow() == 0) && (x.getColumn() == 1)) {
				center = x;
			}
		}
		
		//2*4 should equal 8
		assertEquals(center.getNumber(), 8);
	}
	
	@Test
	void testDownMove() {
		Model m = new Model();
		Puzzle p = new Puzzle(3);
		m.setPuzzle(p);
		PuzzleApp app = new PuzzleApp(m);
		Tile tile = new Tile(2);
		m.getPuzzle().add(tile, 1, 1);
		m.getPuzzle().add(new Tile(4), 2, 1);
		
		//select tile to move
		m.setSelectedTile(tile);
		
		//move it left
		new MoveTileController(m, app).move(MoveType.Down);
		
		//find center tile
		Tile center = new Tile(0);
		for (Tile x : m.getPuzzle()) {
			if ((x.getRow() == 2) && (x.getColumn() == 1)) {
				center = x;
			}
		}
		
		//2/4 should equal 2
		assertEquals(center.getNumber(), 2);
	}

}
