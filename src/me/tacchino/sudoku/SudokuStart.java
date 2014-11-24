package me.tacchino.sudoku;

/*  Class containing the main method to create a GUI
 * 
 *  Author: Matt Tacchino
 *  
 *  This program creates a GUI to input values in a sudoku table,
 *  then solve the puzzle using recursive backtracking.
 *  Also includes sample puzzles for testing
 * 
 * 
*/
public class SudokuStart {
	public static void main (String args[]){
		GUI gui = new GUI();
		gui.createGUI();
	}
}


