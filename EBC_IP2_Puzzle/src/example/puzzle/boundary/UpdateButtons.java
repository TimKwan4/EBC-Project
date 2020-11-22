package example.puzzle.boundary;

import java.util.ArrayList;

import example.puzzle.model.MoveType;

public class UpdateButtons {
	public static void enableButtons(PuzzleApp app, ArrayList<MoveType> moves) {
		//clear buttons
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
		
		for (MoveType mt : moves) {
			if (mt == MoveType.Left) {
				app.getLeftButton().setEnabled(true);
			}else if (mt == MoveType.Right) {
				app.getRightButton().setEnabled(true);
			}else if (mt == MoveType.Down) {
				app.getDownButton().setEnabled(true);
			}else if (mt == MoveType.Up) {
				app.getUpButton().setEnabled(true);
			}
		}
		
	}

}
