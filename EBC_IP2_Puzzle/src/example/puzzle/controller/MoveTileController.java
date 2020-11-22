package example.puzzle.controller;

import java.util.ArrayList;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Model;
import example.puzzle.model.MoveType;

public class MoveTileController {
	Model model;
	PuzzleApp app;
	
	public MoveTileController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	
	//TODO:Workon this
	public boolean move(MoveType dir) {
		
		if(model.getSelectedTile() == null) {return false;}
		
		if (model.tryMove(dir)) {
			model.setSelectedTile(null);
			ArrayList<MoveType> moves = model.availableMoves();
			UpdateButtons.enableButtons(app, moves);
			
			//Check for win or lose
			model.updateGameState();
			
			app.repaint();
		}
		
		return true;
	}

}
