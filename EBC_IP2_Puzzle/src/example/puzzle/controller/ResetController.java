package example.puzzle.controller;

import java.awt.Point;
import java.util.ArrayList;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Model;

public class ResetController {
	Model model;
	PuzzleApp app;
	
	public ResetController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
		
	}

	public void reset() {
		model.getPuzzle().reset();
		UpdateButtons.enableButtons(app, model.availableMoves());
		app.repaint();
	}
	
}
