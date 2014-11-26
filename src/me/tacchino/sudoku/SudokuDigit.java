package me.tacchino.sudoku;
import java.util.ArrayList;

/* Class representing a sudoku digit
 *
 * Author: Matt Tacchino
 *
 * A sudoku digit is a digit from 1 to 9,
 * or an array of possible values. A digit can
 * can also be "safe" if it was an original input.
 * Original inputs should never be changed after they
 * are set
 * 
 */
public class SudokuDigit {
	private int answer;
	private int xLocation;
	private int yLocation;
	private ArrayList<Integer> possibleValues = new ArrayList<Integer>();
	private boolean isSafe = false;

	//Constructor for when answer is known
	SudokuDigit(int answer){
		this.answer = answer;
	}
	
	//Constructor for unknown digit. Set possible values to be all digits from 1 to 9
	SudokuDigit(int xLocation, int yLocation){
		for (int i = 0; i < 9; i++){
			possibleValues.add(i+1);
		}
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	//copy constructor
	SudokuDigit(SudokuDigit sudokuDigit){;
		this.answer = sudokuDigit.answer;
		this.xLocation = sudokuDigit.xLocation;
		this.yLocation = sudokuDigit.yLocation;
		this.possibleValues = sudokuDigit.possibleValues;
		this.isSafe = sudokuDigit.isSafe;
	}

	
	//getters
	public ArrayList<Integer> getPossibleValues(){
		return possibleValues;
	}
	
	public boolean isSolved(){
		return (answer != 0);
	}
	
	public boolean isSafe(){
		return isSafe;
	}
	
	public int getAnswer(){
		return answer;
	}
	
	public int getX(){
		return xLocation;
	}
	
	public int getY(){
		return yLocation;
	}

	//setters
	public void setSafe(boolean isSafe){
		this.isSafe = isSafe;
	}
	
	public void setAnswer(int answer){
		this.answer = answer;
		possibleValues.clear();
		if (answer == 0) { // add all possible values from 1 to 9
			for (int i = 1; i < 10; i ++)
				this.possibleValues.add(i);
		}
	}

	public void removePossibleValue(int possibleValue){
		if (answer == 0) {
			if (possibleValues.contains(possibleValue))
				possibleValues.remove(possibleValue);
			if (possibleValues.size() == 1)
				setAnswer(possibleValues.get(0));
		}
	}
	
	public String toString(){
		if (answer == 0){
			String str = "Possible values for location (" + xLocation + "," + yLocation + "): ";
			for (int value : possibleValues)
				str = str + value + " ";
			return str;
		}
		else
			return "Answer for location (" + xLocation + "," + yLocation + "): " + answer;
	}
}


