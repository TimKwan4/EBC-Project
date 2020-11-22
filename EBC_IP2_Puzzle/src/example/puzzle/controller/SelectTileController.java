package example.puzzle.controller;

import java.awt.Point;
import java.util.ArrayList;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Coordinate;
import example.puzzle.model.Model;
import example.puzzle.model.MoveType;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class SelectTileController {
	Model model;
	PuzzleApp app;
	
	public SelectTileController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
		
	}

	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoordiate(point);
		Puzzle puzzle = model.getPuzzle();
		
		for (Tile t : puzzle) {
			if (t.contains(c)) {
				model.setSelectedTile(t);
				
				ArrayList<MoveType> moves = model.availableMoves(t);
				UpdateButtons.enableButtons(app, moves);
				
				app.repaint();
			}
		}
	}
	
}
