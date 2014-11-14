package bin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI {

	private SudokuTable sudokuTable = new SudokuTable();
	
	private JFrame frame = new JFrame("Sudoku Solver");
	private JTextField textField[][] = new JTextField[9][9];
	private JPanel gridPanel = new JPanel(new GridLayout(9,9,1,1));
	
	// constructor for blank SudokuTable. adds empty text fields to gridpanel
	GUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y] = new JTextField();
				gridPanel.add(textField[x][y]);
			}
		}
	}

	public void sudokuTableToGUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					sudokuTable.getTable()[x][y].setAnswer(Integer.parseInt(textField[x][y].getText())); //if a number is in the textfield, put it in the sudoku table
				}
				else {
					if (sudokuTable.getTable()[x][y].isSolved()){
						if (sudokuTable.getTable()[x][y].isSafe()) //set safe inputs to be coloured red
							textField[x][y].setForeground(Color.RED);
						else
							textField[x][y].setForeground(Color.BLACK);
						textField[x][y].setText(String.valueOf(sudokuTable.getTable()[x][y].getAnswer()));
					}
					else
						textField[x][y].setText(""); //clear any text if the digit is not solved
					
				}
			}
		}
	}
	
	public void clearGrid(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y].setText("");
			}
		}
	}
	
	public void createGUI(){
		//sudokuTableToGUI();
		
		///////////////////////////////////////////////////////////
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
				System.out.println(sudokuTable.toString());
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
				sudokuTableToGUI();
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
				sudokuTableToGUI();
				sudokuTable.checkAll(true); // do a safe checkAll before finding all remaining solutions
				sudokuTable.solve(1);
				sudokuTableToGUI();
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
	
}
