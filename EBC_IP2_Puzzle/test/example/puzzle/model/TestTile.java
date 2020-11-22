package example.puzzle.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import example.puzzle.model.Tile;

class TestTile {

	@Test
	void testConstruction() {
		Tile t = new Tile(1);
		
		assertEquals(1,t.getNumber());
	}
	
	@Test
	void testOtherConstruction() {
		Tile t = new Tile(1,0,0);
		
		assertEquals(1,t.getNumber());
	}
	
	@Test
	void testSetNumber() {
		Tile t = new Tile(1,0,0);
		t.setNumber(3);
		
		assertEquals(3,t.getNumber());
	}
	
	@Test
	void testGetRow() {
		Tile t = new Tile(1,2,3);
		
		assertEquals(2,t.getRow());
	}
	
	@Test
	void testGetCol() {
		Tile t = new Tile(1,2,3);
		
		assertEquals(3,t.getColumn());
	}
	
	@Test
	void testSetCol() {
		Tile t = new Tile(1,2,3);
		t.setColumn(5);
		
		assertEquals(5,t.getColumn());
	}
	
	@Test
	void testSetRow() {
		Tile t = new Tile(1,2,3);
		t.setRow(6);
		
		assertEquals(6,t.getRow());
	}


}
