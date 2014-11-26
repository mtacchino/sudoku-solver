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
		
		assertEquals(sudokuTable.getDigit(2,0).getAnswer(),5);
		assertEquals(sudokuTable.getDigit(0,0).getAnswer(),9);
		assertEquals(sudokuTable.getDigit(8,8).getAnswer(),5);
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
}
