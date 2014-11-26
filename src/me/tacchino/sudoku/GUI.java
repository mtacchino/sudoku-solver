package me.tacchino.sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Class representing the GUI
 * 
 * Author: Matt Tacchino
 * 
 * Creates the interactive GUI to support the sudoku solver using GridBagLayout.
 * Frame is minimum 300x300px resizable
 * 
 * There are 5 main parts:
 * 		Title
 * 		Grid: 9x9 grid of text fields, 81 total
 * 		Generate Example button: creates an example puzzle using the ExamplePuzzles class
 * 		Clear Table button: set sudokutable to a blank table and clear text fields
 * 		Solve button: Solves the sudoku puzzle. See SudokuTable.java for algorithm
 * 
 */
public class GUI {

	private SudokuTable sudokuTable = new SudokuTable();
	
	private JFrame frame = new JFrame("Sudoku Solver");
	private JTextField textField[][] = new JTextField[9][9];
	private GridPanel gridPanel = new GridPanel(new GridLayout(9,9,1,1));
	
	// constructor for blank SudokuTable. adds empty text fields to gridpanel
	GUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y] = new JTextField();
				textField[x][y].setForeground(Color.RED);
				gridPanel.add(textField[x][y]);
			}
		}
	}
	
	boolean checkText(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					try {
						int digit = Integer.parseInt(textField[x][y].getText());
						if (digit <= 0 || digit >= 10)
							return false;
					}
					catch (NumberFormatException e){
						return false;
					}
				}
			}
		}
		return true;
	}

	public void GUIToSudokuTable(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					sudokuTable.getDigit(x,y).setAnswer(Integer.parseInt(textField[x][y].getText())); //if a number is in the textfield, put it in the sudoku table
					sudokuTable.getDigit(x,y).setSafe(true); // set starting digits to true
					textField[x][y].setForeground(Color.RED); // colour starting digits red
				}
				else {
					sudokuTable.getDigit(x,y).setAnswer(0); //clear any blank table digits by setting them to 0
					textField[x][y].setForeground(Color.BLACK); //colour blanks to black
				}
			}
		}
	}
	
	public void sudokuTableToGUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){		
				if (sudokuTable.getDigit(x,y).isSolved())
					textField[x][y].setText(String.valueOf(sudokuTable.getDigit(x,y).getAnswer()));			
			}
		}
	}
	
	public void clearGrid(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y].setText("");
				textField[x][y].setForeground(Color.RED);
			}
		}
	}
	
	public void createGUI(){
		//create main panel and add a top title and bottom button. Also
		//add the grid panel to this panel in the centre
		JPanel mainPanel = new JPanel(new GridBagLayout()); //create main panel
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		gridBagConstraints.weighty = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		
		//add label to top of main panel
		JLabel topLabel = new JLabel("Sudoku Solver", JLabel.CENTER);
		topLabel.setOpaque(true);
		topLabel.setBackground(Color.BLACK);
		topLabel.setForeground(Color.WHITE);
		topLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		mainPanel.add(topLabel, gridBagConstraints);
		
		
		//add grid panel
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		mainPanel.add(gridPanel, gridBagConstraints); 
		
		//set these gridBagConstraints for all bottom buttons
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.weighty = 0.1;
		
		//add "generate examples" button to main panel
		JButton exampleButton = new JButton("Generate Example");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.ipadx = 40;
		mainPanel.add(exampleButton, gridBagConstraints);
		exampleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ExamplePuzzles example = new ExamplePuzzles();
				sudokuTable = example.createExamplePuzzle();
				clearGrid();
				sudokuTableToGUI();
			}
		});
		
		//add "clear" button to main panel
		JButton clearButton = new JButton("Clear Table");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.ipadx = 0;
		mainPanel.add(clearButton, gridBagConstraints);
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sudokuTable = new SudokuTable();
				clearGrid();
			}
		});
		
		//add "solve" button to bottom of main panel
		JButton solveButton = new JButton("Solve");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		mainPanel.add(solveButton, gridBagConstraints);
		solveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!checkText())
					JOptionPane.showMessageDialog(frame,"Invalid input. Values must be integers from 1 to 9","Error",JOptionPane.ERROR_MESSAGE);
				else {
					GUIToSudokuTable();
					if (!sudokuTable.solve(1))
						JOptionPane.showMessageDialog(frame,"This puzzle cannot be solved.","Error",JOptionPane.ERROR_MESSAGE);
					else
						sudokuTableToGUI();
				}
			}
		});
		
		
		//create frame and add main panel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.getContentPane().add(mainPanel); //add main panel to frame
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(300,300));
		frame.setVisible(true);
	}
	
	/* Nested class for the grid panel used in the GUI */
	public class GridPanel extends JPanel{
		private static final long serialVersionUID = -6157041650150998205L;

		GridPanel(GridLayout layout){
			super(layout);
		}
		
		//draw lines for 3x3 quardrants
		public void paintComponent(Graphics g){
			g.fillRect(getWidth()/3 - 1,0,3,getHeight());
			g.fillRect(2*getWidth()/3 - 1,0,3,getHeight());
			g.fillRect(0,getHeight()/3 - 1,getWidth(),3);
			g.fillRect(0,2*getHeight()/3 - 2,getWidth(),3);
		}
	}
	
}
