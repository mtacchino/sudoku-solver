package me.tacchino.sudoku.test;

import static org.junit.Assert.*;
import me.tacchino.sudoku.ExamplePuzzles;
import me.tacchino.sudoku.SudokuTable;

import org.junit.Test;

public class SudokuTableTest {

	ExamplePuzzles e = new ExamplePuzzles();
	SudokuTable sudokuTable = new SudokuTable();
	
	@Test
	public void testGetSudokuDigit() {
		e.setTableNum(0);
		SudokuTable sudokuTable = e.createExamplePuzzle();
		
		assertEquals(sudokuTable.getSudokuDigit(3).getAnswer(),5);
		assertEquals(sudokuTable.getSudokuDigit(1).getAnswer(),9);
		assertEquals(sudokuTable.getSudokuDigit(81).getAnswer(),5);
	}

	@Test
	public void testGetNumOfDigitsSolved() {
		e.setTableNum(0);
		sudokuTable = e.createExamplePuzzle();
		assertEquals(sudokuTable.getNumOfDigitsSolved(),34);
		
		e.setTableNum(1);
		sudokuTable = e.createExamplePuzzle();
		assertEquals(sudokuTable.getNumOfDigitsSolved(),28);
		
		e.setTableNum(2);
		sudokuTable = e.createExamplePuzzle();
		assertEquals(sudokuTable.getNumOfDigitsSolved(),15);
	}
/*
	@Test
	public void testCheckQuadrant() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckColumn() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRemainingSolutions() {
		fail("Not yet implemented");
	}
*/
}
