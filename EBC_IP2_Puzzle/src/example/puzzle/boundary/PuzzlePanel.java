package example.puzzle.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import example.puzzle.model.Coordinate;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class PuzzlePanel extends JPanel {
	
	Model model;
	public static final int boxSize = 125;
	public static final int spacing = 2;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	
	public Rectangle computeRectangle(Tile t) {
		int col = t.getColumn();
		int row = t.getRow();
		
		Rectangle r = new Rectangle(t.getColumn()*boxSize,t.getRow()*boxSize,boxSize-spacing, boxSize-spacing);
		return r; 
		
	}
	
	private Rectangle computeText(Tile t) {
		int col = t.getColumn();
		int row = t.getRow();
		
		Rectangle r = new Rectangle((t.getColumn()*boxSize)+boxSize/2,
				(t.getRow()*boxSize)+boxSize/2,boxSize-spacing, boxSize-spacing);
		return r; 
	}
	
	public Coordinate pointToCoordiate(Point p) {
		return new Coordinate(p.y/boxSize,p.x/boxSize);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) {return;} //nothing is drawn, only here for windowbuilder
		
		Puzzle puzzle = model.getPuzzle();
		for (Tile t : puzzle) {
			
			if (t.equals(model.getSelectedTile())) {
				g.setColor(Color.RED);
			}else {
				g.setColor(Color.GRAY);
			}
			
			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);
			g.setColor(Color.BLACK);
			Rectangle text = computeText(t);
			g.drawString(Integer.toString(t.getNumber()), text.x, text.y);
			
		}
		
	}

}
