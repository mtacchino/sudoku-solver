package me.tacchino.sudoku;

/* Class with all example puzzles
 * 
 * Author: Matt Tacchino
 * 
 * Contains a list of sudoku tables to cycle through 
 * Starts at a random puzzle, then cycles through all remaining puzzles in order
 * 
*/

public class ExamplePuzzles {
	
	private static SudokuTable[] exampleTables = new SudokuTable[3];
	private static int tableNum = (int) (Math.random() * exampleTables.length);
	
	public void setTableNum(int num){
		ExamplePuzzles.tableNum = num;
	}
	
	public SudokuTable createExamplePuzzle(){
		SudokuTable table = exampleTables[tableNum];
		tableNum = (tableNum + 1) % exampleTables.length;
		return table;
	}
	
	public ExamplePuzzles(){
		for (int i = 0; i < exampleTables.length; i++) {
			exampleTables[i] = new SudokuTable();
		}
		
		exampleTables[0].getDigit(0,0).setAnswer(9);
		exampleTables[0].getDigit(2,0).setAnswer(5);
		exampleTables[0].getDigit(1,1).setAnswer(6);
		exampleTables[0].getDigit(2,1).setAnswer(3);
		exampleTables[0].getDigit(6,1).setAnswer(5);
		exampleTables[0].getDigit(8,1).setAnswer(8);
		exampleTables[0].getDigit(0,2).setAnswer(2);
		exampleTables[0].getDigit(2,2).setAnswer(4);
		exampleTables[0].getDigit(3,2).setAnswer(8);
		exampleTables[0].getDigit(5,2).setAnswer(9);
		exampleTables[0].getDigit(3,3).setAnswer(1);
		exampleTables[0].getDigit(4,3).setAnswer(8);
		exampleTables[0].getDigit(6,3).setAnswer(2);
		exampleTables[0].getDigit(8,3).setAnswer(3);
		exampleTables[0].getDigit(1,4).setAnswer(7);
		exampleTables[0].getDigit(2,4).setAnswer(1);
		exampleTables[0].getDigit(3,4).setAnswer(5);
		exampleTables[0].getDigit(5,4).setAnswer(2);
		exampleTables[0].getDigit(6,4).setAnswer(6);
		exampleTables[0].getDigit(7,4).setAnswer(8);
		exampleTables[0].getDigit(0,5).setAnswer(5);
		exampleTables[0].getDigit(2,5).setAnswer(8);
		exampleTables[0].getDigit(4,5).setAnswer(4);
		exampleTables[0].getDigit(5,5).setAnswer(3);
		exampleTables[0].getDigit(3,6).setAnswer(2);
		exampleTables[0].getDigit(5,6).setAnswer(5);
		exampleTables[0].getDigit(6,6).setAnswer(7);
		exampleTables[0].getDigit(8,6).setAnswer(6);
		exampleTables[0].getDigit(0,7).setAnswer(1);
		exampleTables[0].getDigit(2,7).setAnswer(2);
		exampleTables[0].getDigit(6,7).setAnswer(8);
		exampleTables[0].getDigit(7,7).setAnswer(3);
		exampleTables[0].getDigit(6,8).setAnswer(4);
		exampleTables[0].getDigit(8,8).setAnswer(5);
		
		exampleTables[1].getDigit(6,0).setAnswer(4);
		exampleTables[1].getDigit(8,0).setAnswer(3);
		exampleTables[1].getDigit(4,1).setAnswer(1);
		exampleTables[1].getDigit(3,2).setAnswer(9);
		exampleTables[1].getDigit(5,2).setAnswer(3);
		exampleTables[1].getDigit(7,2).setAnswer(8);
		exampleTables[1].getDigit(8,2).setAnswer(1);
		exampleTables[1].getDigit(2,3).setAnswer(3);
		exampleTables[1].getDigit(4,3).setAnswer(2);
		exampleTables[1].getDigit(5,3).setAnswer(9);
		exampleTables[1].getDigit(7,3).setAnswer(7);
		exampleTables[1].getDigit(8,3).setAnswer(5);
		exampleTables[1].getDigit(2,4).setAnswer(8);
		exampleTables[1].getDigit(3,4).setAnswer(7);
		exampleTables[1].getDigit(5,4).setAnswer(5);
		exampleTables[1].getDigit(6,4).setAnswer(1);
		exampleTables[1].getDigit(0,5).setAnswer(5);
		exampleTables[1].getDigit(1,5).setAnswer(9);
		exampleTables[1].getDigit(3,5).setAnswer(1);
		exampleTables[1].getDigit(4,5).setAnswer(4);
		exampleTables[1].getDigit(6,5).setAnswer(2);
		exampleTables[1].getDigit(0,6).setAnswer(7);
		exampleTables[1].getDigit(1,6).setAnswer(8);
		exampleTables[1].getDigit(3,6).setAnswer(2);
		exampleTables[1].getDigit(5,6).setAnswer(6);
		exampleTables[1].getDigit(4,7).setAnswer(9);
		exampleTables[1].getDigit(0,8).setAnswer(6);
		exampleTables[1].getDigit(2,8).setAnswer(1);
		
		exampleTables[2].getDigit(0,0).setAnswer(1);
		exampleTables[2].getDigit(0,1).setAnswer(2);
		exampleTables[2].getDigit(0,2).setAnswer(3);
		exampleTables[2].getDigit(0,3).setAnswer(4);
		exampleTables[2].getDigit(0,4).setAnswer(5);
		exampleTables[2].getDigit(0,5).setAnswer(6);
		exampleTables[2].getDigit(0,6).setAnswer(7);
		exampleTables[2].getDigit(0,7).setAnswer(8);
		exampleTables[2].getDigit(0,8).setAnswer(9);
		exampleTables[2].getDigit(1,0).setAnswer(4);
		exampleTables[2].getDigit(1,1).setAnswer(5);
		exampleTables[2].getDigit(1,2).setAnswer(6);
		exampleTables[2].getDigit(1,3).setAnswer(7);
		exampleTables[2].getDigit(1,4).setAnswer(8);
		exampleTables[2].getDigit(1,5).setAnswer(9);
	}
}
