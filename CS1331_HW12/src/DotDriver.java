import javax.swing.*;
//import java.awt.*;

/**
  *This runs the program and makes the window that creates and removes the dots.
  *This closes the window when the exit button is pressed and sets the window 
  *size.
  *
  *@author D'Miria Collins
  *@version 1.0
  *
  */

public class DotDriver{
	public static void main(String [] args){
		JFrame frame = new JFrame("Drawing Dots");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DotPanel panel = new DotPanel();
		frame.add(panel);
		frame.setVisible(true);	
	}
}