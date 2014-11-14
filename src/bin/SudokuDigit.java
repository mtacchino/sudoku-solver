package bin;
import java.util.ArrayList;

public class SudokuDigit {
	private int answer;
	private int xLocation;
	private int yLocation;
	private ArrayList<Integer> possibleValues = new ArrayList<Integer>();
	private boolean isSafe = false;

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
	
	//Constructor for when answer is known
	SudokuDigit(int answer){
		this.answer = answer;
	}
	
	//getters
	public ArrayList<Integer> getPossibleValues(){
		return possibleValues;
	}
	
	public int getPossibleValues(int index){
		return possibleValues.get(index);
	}
	
	public int getPossibleValuesSize(){
		return possibleValues.size();
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
	
	public int getXLocation(){
		return xLocation;
	}
	
	public int getYLocation(){
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
			for (int i = 1; i < 10; i ++){
				this.possibleValues.add(i);
			}
		}
	}

	public void removePossibleValue(int possibleValue){
		if (answer == 0) {
			if (possibleValues.contains(possibleValue)){
				possibleValues.remove((Integer)possibleValue);
				if (possibleValues.size() == 1){
					setAnswer(possibleValues.get(0));
				}
			}
		}
	}
	
	public String toString(){
		if (answer == 0){
			String str = "Possible values for location (" + xLocation + "," + yLocation + "): ";
			for (int value : possibleValues){
				str = str + value + " ";
			}
			return str;
		}
		else
			return "Answer for location (" + xLocation + "," + yLocation + "): " + answer;
	}
}


