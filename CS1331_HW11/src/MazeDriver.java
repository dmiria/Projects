import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This method creates a frame for the maze panel.
 *
 * @author D'Miria Collins
 * @version 1.0
 *
 */
 
public class MazeDriver {

    /**
     * This method contains code for overriding Mac's default color buttons.
     * It also creates a maze panel, sets the dimensions for the frame,
     * adds the panel to the frame and makes it visible.
     *
     */

    public static void main(String[] args) {

	// start ugly hack to get button colors on Macs. 
	try { 
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	}
	catch (Exception e) { 
	    e.printStackTrace(); 
	}
	// end ugly hack

	JFrame mazeFrame = new JFrame("Game Time!");
	MazePanel finalMaze = new MazePanel();
	mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mazeFrame.setSize(800,700);
	mazeFrame.add(finalMaze);
	mazeFrame.setVisible(true);
    }
	    
}