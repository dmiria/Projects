import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *This method displays what the player will see
 *
 * @author D'Miria Collins
 * @verison 1.0 
 *
 */

class MazeFactory{

	public Maze generateRookMaze(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class Maze {

	public char[] getWeight(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public Component getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkWin() {
		// TODO Auto-generated method stub
		return false;
	}}


public class MazePanel extends JPanel {

	private MazeFactory mazeFact;
	private Maze maze;
	private int numOfMoves = 0;
	private JButton[][] buttons;
	private JLabel[][] bLabels;
	private JFrame frame;

    /**
     * This method creates a 6x6 grid with a button for each spot.
     * A label is also generated for each button.
     * 
     *
     */

	public MazePanel() {
	
	super(new GridLayout(6,6));
	buttons = new JButton[6][6];
	for (int r = 0; r < 6; r++) {
		for (int c = 0; c < 6; c++) {
			buttons[r][c] = new JButton();
			buttons[r][c].addActionListener(new ValidListener());
			add(buttons[r][c]);
		}
	}

	bLabels = new JLabel[6][6];
	for (int a = 0; a < 6; a++) {
		for (int b = 0; b < 6; b++) {
			bLabels[a][b] = new JLabel();
			buttons[a][b].add(bLabels[a][b]);
		}
	}
	
	mazeFact = new MazeFactory();
	maze = mazeFact.generateRookMaze(6,6);

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			String buttonWeight = String.valueOf(maze.getWeight(i,j));
		}
	}

	updateColors();

	}

    /**
     * This action listener adds one to the total number of moves
     * the player has made in.
     *
     * @param ActionEvent e
     */

	private class ValidListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 6; y++) {
					if (buttons[x][y].equals((JButton)(e.getSource()))) {
						if (maze.getPlayer().move(x,y)) {
						numOfMoves++;
						}
					}
				}
			}
		updateColors();
		}
	}

    /**
     * This method changes the coloer of the buttons when they are pressed.
     * It also checks to see which moves are valid based
     * on the weight of the button. At the end, if the player has
     * won the game, it displays a dialog box saying that the player
     * has won, in how many moves and the shortest amount of
     * moves that could've been made.
     *
     */

	private void updateColors() {

		for (int y = 0; y < 6; y++) {
			for (int z = 0; z < 6; z++) {
				String weight = String.valueOf(maze.getWeight(y,z));
				if ((y == ((int)maze.getPlayer().getLocation().getX())) && (z == ((int)maze.getPlayer().getLocation().getY())) ) {
					bLabels[y][z].setText("Here: " + weight);
					buttons[y][z].setBackground(Color.GREEN);
				}else if (maze.getWeight(y,z) == 0) {
					buttons[y][z].setBackground(Color.WHITE);
					bLabels[y][z].setText(weight);
				}else {
					buttons[y][z].setBackground(Color.LIGHT_GRAY);
					bLabels[y][z].setText(weight);
				}
			}
		}

		ArrayList<Point> vMoves = new ArrayList<Point>();
		vMoves = maze.getPlayer().getValidMoves();
		for (Point p: vMoves) {
			int x = (int)p.getX();
			int y = (int)p.getY();
			buttons[x][y].setBackground(Color.YELLOW);
		}
	
		if (maze.checkWin()) {
			JOptionPane.showMessageDialog(frame,
					  "You won! It took you " + numOfMoves + " moves to win the game. \nYou could have won in " + maze.getSolutionLength() + " moves.");
		}

	}

}
