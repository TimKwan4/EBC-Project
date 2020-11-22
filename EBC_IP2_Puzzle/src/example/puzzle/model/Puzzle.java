package example.puzzle.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile> {
	ArrayList<Tile> tiles = new ArrayList<>();
	
	ArrayList<Tile> originals = new ArrayList<>();
	
	public final int dimension; //must be an odd number
	
	public Puzzle(int dimension) {
		this.dimension = dimension;
	}
	
	public void move(Tile t, MoveType dir) {
		if (dir == MoveType.None) {return;}
		Tile updatedTile = getDirTile(dir, t);
		
		//Up
		if (dir == MoveType.Up) {
			updatedTile.setNumber(t.getNumber()*updatedTile.getNumber());
			tiles.remove(t);
		}
		
		//Down
		if (dir == MoveType.Down) {
			updatedTile.setNumber(updatedTile.getNumber()/t.getNumber());
			tiles.remove(t);
		}
		
		//Left
		if (dir == MoveType.Left) {
			updatedTile.setNumber(updatedTile.getNumber()-t.getNumber());
			tiles.remove(t);
		}
		
		//Right
		if (dir == MoveType.Right) {
			updatedTile.setNumber(t.getNumber()+updatedTile.getNumber());
			tiles.remove(t);
		}
		
	}

	public void add(Tile t, int row, int col) {
		t.setRow(row);
		t.setColumn(col);
		tiles.add(t);
		
		originals.add(t.copy());
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}
	
	public boolean isEmpty(Coordinate c) {
		for (Tile t : tiles) {
			if (t.contains(c)) {
				return false;
			}
		}
		return true;
	}
	
	public Tile getDirTile(MoveType move, Tile tile) {
		//Up
		if (move == MoveType.Up) {
			for (Tile t : tiles) {
				if (t.getRow()+1 == tile.getRow() && t.getColumn() == tile.getColumn()) {
					return t;
				}
			}
		}
		
		//Down
		if (move == MoveType.Down) {
			for (Tile t : tiles) {
				if (t.getRow()-1 == tile.getRow() && t.getColumn() == tile.getColumn()) {
					return t;
				}
			}
		}
		
		//Left
		if (move == MoveType.Left) {
			for (Tile t : tiles) {
				if (t.getRow() == tile.getRow() && t.getColumn()+1 == tile.getColumn()) {
					return t;
				}
			}
		}
		
		//Right
		if (move == MoveType.Right) {
			for (Tile t : tiles) {
				if (t.getRow() == tile.getRow() && t.getColumn()-1 == tile.getColumn()) {
					return t;
				}
			}
		}
		
		return null;
		
	}

	public void reset() {
		tiles.clear();
		for (Tile tile : originals) {
			tiles.add(tile.copy());
		}
		
	}
	
}
