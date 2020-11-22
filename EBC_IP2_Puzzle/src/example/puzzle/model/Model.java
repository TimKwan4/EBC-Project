package example.puzzle.model;

import java.awt.List;
import java.util.ArrayList;

public class Model {
	Puzzle puzzle;
	Tile selectedTile;
	GameOverType gameOver;
	
	public Model() {
		puzzle = new Puzzle(3);
		gameOver = GameOverType.Running;
		
		puzzle = new Puzzle(3);
		puzzle.add(new Tile(3), 0, 0);
		puzzle.add(new Tile(6), 0, 1);
		puzzle.add(new Tile(8), 0, 2);
		puzzle.add(new Tile(9), 1, 0);
		puzzle.add(new Tile(1), 1, 1);
		puzzle.add(new Tile(2), 1, 2);
		puzzle.add(new Tile(4), 2, 0);
		puzzle.add(new Tile(5), 2, 1);
		puzzle.add(new Tile(7), 2, 2);
		setPuzzle(puzzle);
		
	}
	
	public boolean tryMove(MoveType dir) {
		if (selectedTile == null) {
			return false;
		}
		for (MoveType move : availableMoves()) {
			if (dir == move) {
				puzzle.move(selectedTile,dir);
				return true;
			}
		}
		return true;
	}
	
	public ArrayList<MoveType> availableMoves(){
		ArrayList<MoveType> moves = new ArrayList<>();
		
		if (selectedTile == null) {
			return moves;
		}
		return availableMoves(selectedTile);
	}
	
	public ArrayList<MoveType> availableMoves(Tile t){
		ArrayList<MoveType> moves = new ArrayList<>();
		
		//Right, add
		if (t.getColumn()<2) {
			if (!puzzle.isEmpty(new Coordinate(t.row, t.col+1))) {
				moves.add(MoveType.Right);
			}
		}
		
		//Up, multiply
		if(t.getRow()>0) {
			if (!puzzle.isEmpty(new Coordinate(t.row-1, t.col))) {
				moves.add(MoveType.Up);
			}
		}
		
		//Left, subtract
		if(t.getColumn()>0) {
			if (!(puzzle.isEmpty(new Coordinate(t.row, t.col-1))) && 
					( (puzzle.getDirTile(MoveType.Left, t).getNumber() - t.getNumber()) > 0 )) {
				moves.add(MoveType.Left);
			}
		}
		
		//Down, divide
		if(t.getRow()<2) {
			if (!(puzzle.isEmpty(new Coordinate(t.row+1, t.col))) && 
					((puzzle.getDirTile(MoveType.Down, t).getNumber() % t.getNumber()) == 0)) {
				moves.add(MoveType.Down);
			}
		}
		
		return moves;
	}
	
	
	public void resetPuzzle() {
		puzzle.reset();
		selectedTile = null;
		
	}
	
	public GameOverType updateGameState() {
		//lose if all available moves lists are 0
		//win if one tile is left and is in the center
		
		int totalMoves = 0;
		int size = 0;
		Tile middle = new Tile(-1,-1,-1);
		
		//count all moves
		for (Tile tile : puzzle) {
			setSelectedTile(tile);
			totalMoves += availableMoves().size();
			//set middle tile
			if ((tile.getRow() == 1) && (tile.getColumn() == 1)) {
				middle = tile;
			}
			size++;
		}
		//go back to no selected
		setSelectedTile(null);
		//if no more moves, it's a lose or win
		if (totalMoves == 0) {
			if (size == 1) {
				for (Tile tile : puzzle) {
					if (tile == middle) {
						return GameOverType.Win;
					}else {
						return GameOverType.Lose;
					}
				}
			}else {
				return GameOverType.Lose;
			}
		}
		
		return GameOverType.Running;
		
	}
	
	
	public Puzzle getPuzzle() {return this.puzzle;}
	public void setPuzzle(Puzzle p) {
		this.puzzle = p;
		gameOver = GameOverType.Running;
		selectedTile = null;
	}
	
	public Tile getSelectedTile() {return this.selectedTile;}
	public void setSelectedTile(Tile t) {this.selectedTile = t;}
	
	public GameOverType isGameOver() {return this.gameOver	;}
	public void setGameOver(GameOverType flag) {this.gameOver = flag;}
	public GameOverType getGameOver() {return gameOver;}
}
