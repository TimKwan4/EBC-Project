package example.puzzle.controller;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import example.puzzle.boundary.PuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Model;

public class ExitController {
	PuzzleApp app;
	
	public ExitController(PuzzleApp app) {
		this.app = app;
		
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you wish to Exit?");
		if (c==JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
	
}
