package example.puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.controller.ExitController;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class Main {
	public static void main(String[] args) {
		Model m = new Model();
		PuzzleApp app = new PuzzleApp(m);
		
		
		app.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
			
		});
		
		app.setVisible(true);
	}
}
