package example.puzzle.model;

public class Tile {
	int nmbr;
	int row;
	int col;
	
	
	public Tile(int nmbr) {
		this.nmbr = nmbr;	
	}
	
	public Tile(int nmbr, int row, int col) {
		this.nmbr = nmbr;
		this.row = row;
		this.col = col;
	}

	public void setNumber(int n) {this.nmbr = n;}
	public int getNumber() {return this.nmbr;}
	
	public void setRow(int r) {this.row = r;}
	public void setColumn(int c) {this.col =c;}

	public int getColumn() {return col;}
	public int getRow() {return row;}

	public boolean contains(Coordinate c) {
		if ((c.row == this.row) && (c.col == this.col)) {
			return true;
		}
		return false;
	}

	public Tile copy() {
		Tile copy = new Tile(this.nmbr,this.row,this.col);
		return copy;
	}
	
	
}
