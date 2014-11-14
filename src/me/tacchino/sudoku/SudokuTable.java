package me.tacchino.sudoku;
import java.util.ArrayList;

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
	
	//get table
	public SudokuDigit[][] getTable(){
		return this.table;
	}
	
	
	boolean checkDigit(SudokuDigit digit) {
		 //check row
        for (int x = 0; x < 9; x++)
            if (digit.getAnswer() == table[x][digit.getYLocation()].getAnswer())
                return false;

        //check column
        for (int y = 0; y < 9; y++) 
            if (digit.getAnswer() == table[digit.getXLocation()][y].getAnswer())
                return false;

        //check quadrant
        int startPosX = (digit.getXLocation()/3)*3;
		int startPosY = (digit.getYLocation()/3)*3;
		for (int y = startPosY; y < startPosY + 3; y++){
			for (int x = startPosX; x < startPosX + 3; x++){
				if (digit.getAnswer() == table[x][y].getAnswer())
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
	
	
	/*boolean solve(int position) {
		if (position == 81)
        	return true;
		
		int x = (position-1)%9;
		int y = (position-1)/9;
		
        if (table[x][y].isSolved())
        	return solve(position+1);
        
        for (int d = 1; d <= 9; d++) {
        	SudokuDigit digit = new SudokuDigit(table[x][y]);
        	digit.setAnswer(d);
		    if (checkDigit(digit)) {
		        table[x][y] = digit;
		       	if (solve(position+1))
		       		return true;
		    }
        }
        table[x][y].setAnswer(0); // reset on backtrack
        return false;
    }*/
	
	
	
	
	
	
	
	//the position of a sudokuDigit is an integer from 1 to 81, counting left to right, then top to bottom
	//1  2  3  .. 9
	//10 11 12 .. 18
	//19 20 21 .. 27
	//.  .  .  .. .
	//73 74 75 .. 81
	public SudokuDigit getSudokuDigit(int position){
		return table[(position-1) % 9][(position-1) / 9];
	}
	
	
	//returns an int (from 0 to 81) representing the number of digits that are solved in the table 
	public int getNumOfDigitsSolved(){
		int numOfDigitsSolved = 0;
		for (SudokuDigit[] row : table){
			for (SudokuDigit sudokuDigit : row){
				if (sudokuDigit.getAnswer() != 0)
					numOfDigitsSolved += 1;
			}
		}
		return numOfDigitsSolved;
	}
	
	// checks for solved digits in a 3x3 quadrant. Removes all the possible values of a sudokuDigit for solved digits
	// if parameter isSafe=TRUE, sets any solved digits to isSafe=TRUE
	// return false if the check removes all possible values without getting an answer
	public boolean checkQuadrant(SudokuDigit sudokuDigit, boolean isSafe){
					
		int startPosX = (sudokuDigit.getXLocation()/3)*3;
		int startPosY = (sudokuDigit.getYLocation()/3)*3;

		for (int y = startPosY; y < startPosY + 3; y++){
			for (int x = startPosX; x < startPosX + 3; x++){
				if (sudokuDigit.getXLocation() != x && sudokuDigit.getYLocation() != y){
					if (table[x][y].isSolved())
						sudokuDigit.removePossibleValue(table[x][y].getAnswer());
					if (sudokuDigit.isSolved() && sudokuDigit.getAnswer() == table[x][y].getAnswer())
						return true;
				}
				if (sudokuDigit.isSolved() && isSafe)
					sudokuDigit.setSafe(true);
			}
		}
		return false;
	}
	
	// checks for solved digits in a row. Removes all the possible values of a sudokuDigit for solved digits
	// if parameter isSafe=TRUE, sets any solved digits to isSafe=TRUE
	// return false if the check removes all possible values without getting an answer
	public boolean checkRow(SudokuDigit sudokuDigit, boolean isSafe){
		
		int y = sudokuDigit.getYLocation();			
		for (int x = 0; x < 9; x++){
			if (sudokuDigit.getXLocation() != x){
				if (table[x][y].isSolved()){
					sudokuDigit.removePossibleValue(table[x][y].getAnswer());
					if (sudokuDigit.isSolved() && sudokuDigit.getAnswer() == table[x][y].getAnswer())
						return true;
				}
				if (sudokuDigit.isSolved() && isSafe)
					sudokuDigit.setSafe(true);
				
			}
		}
		return false;
	}
	
	// checks for solved digits in a column. Removes all the possible values of a sudokuDigit for solved digits
	// if parameter isSafe=TRUE, sets any solved digits to isSafe=TRUE
	// return false if the check removes all possible values without getting an answer
	public boolean checkColumn(SudokuDigit sudokuDigit, boolean isSafe){
		
		int x = sudokuDigit.getXLocation();			
		for (int y = 0; y < 9; y++){
			if (sudokuDigit.getYLocation() != y){
				if (table[x][y].isSolved()){
					sudokuDigit.removePossibleValue(table[x][y].getAnswer());
					if (sudokuDigit.isSolved() && sudokuDigit.getAnswer() == table[x][y].getAnswer())
						return true;
				}
				if (sudokuDigit.isSolved() && isSafe)
					sudokuDigit.setSafe(true);
			}
		}
		return false;
	}

	// runs all checks in a loop until no more values can be solved
	// if parameter isSafe=TRUE, sets any solved digits to isSafe=TRUE
	// return false if all checks pass without getting an answer
	public boolean checkAll(boolean isSafe){
		int totalPossibleValues;
		int previousTotalPossibleValues;
		do {
			totalPossibleValues = 0;
			previousTotalPossibleValues = 0;
			for (SudokuDigit[] column : table){
				for (SudokuDigit sudokuDigit : column){
					previousTotalPossibleValues += sudokuDigit.getPossibleValuesSize();
					if (checkQuadrant(sudokuDigit, isSafe))
						return true;
					if (checkRow(sudokuDigit, isSafe))
						return true;
					if (checkColumn(sudokuDigit, isSafe))
						return true;
					totalPossibleValues += sudokuDigit.getPossibleValuesSize();
				}
			}
		} while (totalPossibleValues < previousTotalPossibleValues);
		return false;
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
