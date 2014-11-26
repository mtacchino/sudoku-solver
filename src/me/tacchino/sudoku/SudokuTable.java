package me.tacchino.sudoku;
import java.util.ArrayList;

/* Class representing a sudoku table
 * 
 * Author: Matt Tacchino
 *
 * A sudoku table is a 9x9 matrix, containing 81
 * sudoku digits.
 * 
 * Also contains method for solving the table
 * 
 */
public class SudokuTable {
	
	private SudokuDigit[][] table = new SudokuDigit[9][9];
		
	//constructor: create sudokuDigits in all 81 blocks
	public SudokuTable(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				table[x][y] = new SudokuDigit(x,y);
			}
		}
	}
	
	//get a digit in the table
	public SudokuDigit getDigit(int x, int y){
		if (x >= 0 && x <= 8 && y >= 0 && y <= 8)
			return table[x][y];
		else
			throw new IndexOutOfBoundsException("Table x and y values are integers from 0 to 8");
	}
	
	
	boolean checkDigit(SudokuDigit digit) {
		if (!digit.isSolved())
			return true; // return true if the digit is not solved
		
		 //check row
        for (int x = 0; x < 9; x++)
            if (digit.getAnswer() == table[x][digit.getY()].getAnswer() && digit.getX() != x)
                return false;

        //check column
        for (int y = 0; y < 9; y++) 
            if (digit.getAnswer() == table[digit.getX()][y].getAnswer() && digit.getY() != y)
                return false;

        //check quadrant
        int startPosX = (digit.getX()/3)*3;
		int startPosY = (digit.getY()/3)*3;
		for (int y = startPosY; y < startPosY + 3; y++){
			for (int x = startPosX; x < startPosX + 3; x++){
				if (digit.getAnswer() == table[x][y].getAnswer() && digit.getX() != x && digit.getY() != y)
					return false;
			}
		}
        return true;
    }
	
	
	boolean solve(int position) {
		if (position > 81)
	    	return true;
		
		int x = (position-1)%9;
		int y = (position-1)/9;
		
	    if (table[x][y].isSolved())
	    	return solve(position+1);
	    
	    ArrayList<Integer> posssibleValues = new ArrayList<Integer>(table[x][y].getPossibleValues()); //make a shallow copy of the possible values at x,y
	    for (int possibleValue : posssibleValues) {
	    	SudokuDigit digit = new SudokuDigit(table[x][y]); //make a shallow copy of the digit at x,y
	    	digit.setAnswer(possibleValue); //set the answer of the copy to the next possible value
		    if (checkDigit(digit)) { //check the digit to see if it is ok in the table
		        table[x][y] = digit; //if it's ok, set the table to point at that digit
		       	if (solve(position+1)) //recurse at the next position
		       		return true;
		    }
	    }
	    table[x][y].setAnswer(0); // reset on backtrack
	    return false;
	}
	
	
	//returns an int (from 0 to 81) representing the number of digits that are solved in the table 
	public int getNumOfDigitsSolved(){
		int numOfDigitsSolved = 0;
		for (SudokuDigit[] column : table){
			for (SudokuDigit sudokuDigit : column){
				if (sudokuDigit.isSolved())
					numOfDigitsSolved += 1;
			}
		}
		return numOfDigitsSolved;
	}
	
	// checks that the table input is valid. All digits must be from 0 to 9
	// and rows, columns and quadrants cannot have the same digits
	public boolean checkOK(){
		for (SudokuDigit[] column : table){
			for (SudokuDigit sudokuDigit : column){
				if (checkDigit(sudokuDigit) && sudokuDigit.getAnswer() >= 0 && sudokuDigit.getAnswer() <= 9)
					continue;
				return false;
			}
		}
		return true;
	}
	
	//sets all solved digits to safe. this will also show them as red
	public void setSolvedToSafe(){
		for (SudokuDigit[] column : table){
			for (SudokuDigit sudokuDigit : column){
				if (sudokuDigit.isSolved())
					sudokuDigit.setSafe(true);
			}
		}
	}
	
	//toString
	public String toString(){
		String str = "";
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				str = str + table[x][y].getAnswer() + " ";
			}
			str = str + "\n";
		}
		return str;
	}
}
