package me.tacchino.sudoku;

//class with all example puzzles
//starts at a random puzzle, then cycles through all remaining puzzles
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
		
		exampleTables[0].getTable()[0][0].setAnswer(9);
		exampleTables[0].getTable()[2][0].setAnswer(5);
		exampleTables[0].getTable()[1][1].setAnswer(6);
		exampleTables[0].getTable()[2][1].setAnswer(3);
		exampleTables[0].getTable()[6][1].setAnswer(5);
		exampleTables[0].getTable()[8][1].setAnswer(8);
		exampleTables[0].getTable()[0][2].setAnswer(2);
		exampleTables[0].getTable()[2][2].setAnswer(4);
		exampleTables[0].getTable()[3][2].setAnswer(8);
		exampleTables[0].getTable()[5][2].setAnswer(9);
		exampleTables[0].getTable()[3][3].setAnswer(1);
		exampleTables[0].getTable()[4][3].setAnswer(8);
		exampleTables[0].getTable()[6][3].setAnswer(2);
		exampleTables[0].getTable()[8][3].setAnswer(3);
		exampleTables[0].getTable()[1][4].setAnswer(7);
		exampleTables[0].getTable()[2][4].setAnswer(1);
		exampleTables[0].getTable()[3][4].setAnswer(5);
		exampleTables[0].getTable()[5][4].setAnswer(2);
		exampleTables[0].getTable()[6][4].setAnswer(6);
		exampleTables[0].getTable()[7][4].setAnswer(8);
		exampleTables[0].getTable()[0][5].setAnswer(5);
		exampleTables[0].getTable()[2][5].setAnswer(8);
		exampleTables[0].getTable()[4][5].setAnswer(4);
		exampleTables[0].getTable()[5][5].setAnswer(3);
		exampleTables[0].getTable()[3][6].setAnswer(2);
		exampleTables[0].getTable()[5][6].setAnswer(5);
		exampleTables[0].getTable()[6][6].setAnswer(7);
		exampleTables[0].getTable()[8][6].setAnswer(6);
		exampleTables[0].getTable()[0][7].setAnswer(1);
		exampleTables[0].getTable()[2][7].setAnswer(2);
		exampleTables[0].getTable()[6][7].setAnswer(8);
		exampleTables[0].getTable()[7][7].setAnswer(3);
		exampleTables[0].getTable()[6][8].setAnswer(4);
		exampleTables[0].getTable()[8][8].setAnswer(5);

		exampleTables[0].getTable()[0][0].setSafe(true);
		exampleTables[0].getTable()[2][0].setSafe(true);
		exampleTables[0].getTable()[1][1].setSafe(true);
		exampleTables[0].getTable()[2][1].setSafe(true);
		exampleTables[0].getTable()[6][1].setSafe(true);
		exampleTables[0].getTable()[8][1].setSafe(true);
		exampleTables[0].getTable()[0][2].setSafe(true);
		exampleTables[0].getTable()[2][2].setSafe(true);
		exampleTables[0].getTable()[3][2].setSafe(true);
		exampleTables[0].getTable()[5][2].setSafe(true);
		exampleTables[0].getTable()[3][3].setSafe(true);
		exampleTables[0].getTable()[4][3].setSafe(true);
		exampleTables[0].getTable()[6][3].setSafe(true);
		exampleTables[0].getTable()[8][3].setSafe(true);
		exampleTables[0].getTable()[1][4].setSafe(true);
		exampleTables[0].getTable()[2][4].setSafe(true);
		exampleTables[0].getTable()[3][4].setSafe(true);
		exampleTables[0].getTable()[5][4].setSafe(true);
		exampleTables[0].getTable()[6][4].setSafe(true);
		exampleTables[0].getTable()[7][4].setSafe(true);
		exampleTables[0].getTable()[0][5].setSafe(true);
		exampleTables[0].getTable()[2][5].setSafe(true);
		exampleTables[0].getTable()[4][5].setSafe(true);
		exampleTables[0].getTable()[5][5].setSafe(true);
		exampleTables[0].getTable()[3][6].setSafe(true);
		exampleTables[0].getTable()[5][6].setSafe(true);
		exampleTables[0].getTable()[6][6].setSafe(true);
		exampleTables[0].getTable()[8][6].setSafe(true);
		exampleTables[0].getTable()[0][7].setSafe(true);
		exampleTables[0].getTable()[2][7].setSafe(true);
		exampleTables[0].getTable()[6][7].setSafe(true);
		exampleTables[0].getTable()[7][7].setSafe(true);
		exampleTables[0].getTable()[6][8].setSafe(true);
		exampleTables[0].getTable()[8][8].setSafe(true);
		
		
		
		exampleTables[1].getTable()[6][0].setAnswer(4);
		exampleTables[1].getTable()[8][0].setAnswer(3);
		exampleTables[1].getTable()[4][1].setAnswer(1);
		exampleTables[1].getTable()[3][2].setAnswer(9);
		exampleTables[1].getTable()[5][2].setAnswer(3);
		exampleTables[1].getTable()[7][2].setAnswer(8);
		exampleTables[1].getTable()[8][2].setAnswer(1);
		exampleTables[1].getTable()[2][3].setAnswer(3);
		exampleTables[1].getTable()[4][3].setAnswer(2);
		exampleTables[1].getTable()[5][3].setAnswer(9);
		exampleTables[1].getTable()[7][3].setAnswer(7);
		exampleTables[1].getTable()[8][3].setAnswer(5);
		exampleTables[1].getTable()[2][4].setAnswer(8);
		exampleTables[1].getTable()[3][4].setAnswer(7);
		exampleTables[1].getTable()[5][4].setAnswer(5);
		exampleTables[1].getTable()[6][4].setAnswer(1);
		exampleTables[1].getTable()[0][5].setAnswer(5);
		exampleTables[1].getTable()[1][5].setAnswer(9);
		exampleTables[1].getTable()[3][5].setAnswer(1);
		exampleTables[1].getTable()[4][5].setAnswer(4);
		exampleTables[1].getTable()[6][5].setAnswer(2);
		exampleTables[1].getTable()[0][6].setAnswer(7);
		exampleTables[1].getTable()[1][6].setAnswer(8);
		exampleTables[1].getTable()[3][6].setAnswer(2);
		exampleTables[1].getTable()[5][6].setAnswer(6);
		exampleTables[1].getTable()[4][7].setAnswer(9);
		exampleTables[1].getTable()[0][8].setAnswer(6);
		exampleTables[1].getTable()[2][8].setAnswer(1);

		exampleTables[1].getTable()[6][0].setSafe(true);
		exampleTables[1].getTable()[8][0].setSafe(true);
		exampleTables[1].getTable()[4][1].setSafe(true);
		exampleTables[1].getTable()[3][2].setSafe(true);
		exampleTables[1].getTable()[5][2].setSafe(true);
		exampleTables[1].getTable()[7][2].setSafe(true);
		exampleTables[1].getTable()[8][2].setSafe(true);
		exampleTables[1].getTable()[2][3].setSafe(true);
		exampleTables[1].getTable()[4][3].setSafe(true);
		exampleTables[1].getTable()[5][3].setSafe(true);
		exampleTables[1].getTable()[7][3].setSafe(true);
		exampleTables[1].getTable()[8][3].setSafe(true);
		exampleTables[1].getTable()[2][4].setSafe(true);
		exampleTables[1].getTable()[3][4].setSafe(true);
		exampleTables[1].getTable()[5][4].setSafe(true);
		exampleTables[1].getTable()[6][4].setSafe(true);
		exampleTables[1].getTable()[0][5].setSafe(true);
		exampleTables[1].getTable()[1][5].setSafe(true);
		exampleTables[1].getTable()[3][5].setSafe(true);
		exampleTables[1].getTable()[4][5].setSafe(true);
		exampleTables[1].getTable()[6][5].setSafe(true);
		exampleTables[1].getTable()[0][6].setSafe(true);
		exampleTables[1].getTable()[1][6].setSafe(true);
		exampleTables[1].getTable()[3][6].setSafe(true);
		exampleTables[1].getTable()[5][6].setSafe(true);
		exampleTables[1].getTable()[4][7].setSafe(true);
		exampleTables[1].getTable()[0][8].setSafe(true);
		exampleTables[1].getTable()[2][8].setSafe(true);
		
		
		
		exampleTables[2].getTable()[0][0].setAnswer(1);
		exampleTables[2].getTable()[0][1].setAnswer(2);
		exampleTables[2].getTable()[0][2].setAnswer(3);
		exampleTables[2].getTable()[0][3].setAnswer(4);
		exampleTables[2].getTable()[0][4].setAnswer(5);
		exampleTables[2].getTable()[0][5].setAnswer(6);
		exampleTables[2].getTable()[0][6].setAnswer(7);
		exampleTables[2].getTable()[0][7].setAnswer(8);
		exampleTables[2].getTable()[0][8].setAnswer(9);
		exampleTables[2].getTable()[1][0].setAnswer(4);
		exampleTables[2].getTable()[1][1].setAnswer(5);
		exampleTables[2].getTable()[1][2].setAnswer(6);
		exampleTables[2].getTable()[1][3].setAnswer(7);
		exampleTables[2].getTable()[1][4].setAnswer(8);
		exampleTables[2].getTable()[1][5].setAnswer(9);
		
		exampleTables[2].getTable()[0][0].setSafe(true);
		exampleTables[2].getTable()[0][1].setSafe(true);
		exampleTables[2].getTable()[0][2].setSafe(true);
		exampleTables[2].getTable()[0][3].setSafe(true);
		exampleTables[2].getTable()[0][4].setSafe(true);
		exampleTables[2].getTable()[0][5].setSafe(true);
		exampleTables[2].getTable()[0][6].setSafe(true);
		exampleTables[2].getTable()[0][7].setSafe(true);
		exampleTables[2].getTable()[0][8].setSafe(true);
		exampleTables[2].getTable()[1][0].setSafe(true);
		exampleTables[2].getTable()[1][1].setSafe(true);
		exampleTables[2].getTable()[1][2].setSafe(true);
		exampleTables[2].getTable()[1][3].setSafe(true);
		exampleTables[2].getTable()[1][4].setSafe(true);
		exampleTables[2].getTable()[1][5].setSafe(true);
	}
}