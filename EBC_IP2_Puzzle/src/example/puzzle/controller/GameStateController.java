package example.puzzle.controller;

import javax.swing.JOptionPane;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.model.GameOverType;
import example.puzzle.model.Model;

public class GameStateController {
	Model model;
	PuzzleApp app;
	
	public GameStateController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	
	public void updateGame() {
		
		//Check for win or lose
		GameOverType state = model.updateGameState();
		model.setGameOver(state);
		
		if (state == GameOverType.Win) {
			int c = JOptionPane.showConfirmDialog(app, "YOU WIN! Do you wish to reset?");
			if (c == JOptionPane.OK_OPTION) {
				new ResetController(model, app).reset();
			}
		}if (state == GameOverType.Lose) {
			int c = JOptionPane.showConfirmDialog(app, "YOU LOSE! Do you wish to reset?");
			if (c == JOptionPane.OK_OPTION) {
				new ResetController(model, app).reset();
			}
		}
		
		app.repaint();
		
	}

}
