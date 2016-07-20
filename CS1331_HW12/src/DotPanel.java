import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Action;
/**
  *This method creates the Panel where the dots are contained and where the 
  *colored dots will be located along with the dot location and number of 
  *dots
  *
  *@author D'Miria Collins
  *@version 1.0
  *
  */

public class DotPanel extends JPanel {

	 private Color color;
	 private Point point;
	 private JLabel colors;
	 private JLabel sums;
	 DotLinkedList b;
	 Dot dot;
	
	 DotPanel() {
	  b = new DotLinkedList();
	  color = color.BLACK;
	  setSize(500, 500);
	  colors = new JLabel("");
	  sums = new JLabel("");
	  addMouseListener(new clickScreenListener());
	  addKeyListener(new numListener());
	  addKeyListener(new rbgListener());
	  addKeyListener(new sListener());
	  setFocusable(true);
	 }
/**
  * This method paint the dots onto the screen 
  *
  *@param Graphics g
  *
  */
	 public void paint(Graphics g) {
	 	super.paint(g);
	  	for (int i = 0; i < b.size(); i++) {
	   	if (b.get(i) != null) {
	
	    	b.get(i).draw(g);
	   }
	 }

 }

/**
  * This class listens for when the mouse is clicked. A new dot would be
  * created on the screen where the mouse was clicked. If a dot already
  * exists in the same location as the mouse, then it removes the dot.
  */
 private class clickScreenListener implements MouseListener {

	  @Override
	  public void mouseClicked(MouseEvent e) {
	  		point = e.getPoint();
	   	boolean a = false;
	   	Dot c = null;
	   	System.out.println(String.valueOf(point.x) + " "
	     		+ String.valueOf(point.y));
	   	dot = new Dot(point, color);
	   	for (int i = 0; i < b.size(); i++) {
	    		if (b.get(i) != null) {
	     		if (b.get(i).contains(point)) {
	      		a = true;
	      		c = b.get(i);
	     		}

    		}
   }

			   if (a) {
			   	b.remove(c);
			   } else {
			   	b.add(dot);
			   }
			   //System.out.print("hi");
			
			   repaint();
			  }
		
		  @Override
		  public void mousePressed(MouseEvent e) {
		  }
		
		  @Override
		  public void mouseReleased(MouseEvent e) {
		  }
		
		  @Override
		  public void mouseEntered(MouseEvent e) {
		  }
		
		  @Override
		  public void mouseExited(MouseEvent e) {
		  }
		
		 }

/**
  * This class listens for the keys "r", "g", or "b' to be pressed and
  * changes the current color to red, green, or blue respectively; all dots
  * created after changing the color will be that color until the color is
  * changed again.
  */

 private class rbgListener implements KeyListener {

	  @Override
	  public void keyPressed(KeyEvent e) {
	  int a = e.getKeyCode();
	    switch (a) {
			   case KeyEvent.VK_R:
			    color = Color.RED;
			    break;
			   case KeyEvent.VK_G:
			    color = Color.GREEN;
			    break;
			   case KeyEvent.VK_B:
			    color = Color.BLUE;
			    break;
			   }
			   repaint();
	  		}

	  @Override
	  public void keyReleased(KeyEvent e) {
	    if(e.getKeyCode() == KeyEvent.VK_A){
	      System.out.println("F5 pressed");}
	  	}
	
	  @Override
	  public void keyTyped(KeyEvent e) {
	   	if(e.getKeyCode() == KeyEvent.VK_A){
	  	   	 System.out.println("F5 pressed");
			}
	
	  }

 }

/**
  * This class listens for the keys "1", "2", or "3". 1 removes the red dots,
  * 2 removes the green dots, and 3 removes the blue dots.
  */

 private class numListener implements KeyListener {

	  @Override
	  public void keyPressed(KeyEvent e) {
	    if(e.getKeyCode() == KeyEvent.VK_A){
	      System.out.println("F5 pressed");}
	   switch (e.getKeyCode()) {
		   case KeyEvent.VK_1:
		
		    break;
		   case KeyEvent.VK_2:
		
		    break;
		
		   case KeyEvent.VK_3:
		
		    break;
		   }
  }

	  @Override
	  public void keyReleased(KeyEvent e) {
	  }
	
	  @Override
	  public void keyTyped(KeyEvent e) {
	  }
	
	 }

/**
  * This class listens for "s". Displys the String representation of the list
  * on the left hand side of the page-if the list is already displayed,
  * pressing "s" should remove that from view.
  */

 private class sListener implements KeyListener {

	  @Override
	  public void keyPressed(KeyEvent e) {
	   	switch (e.getKeyCode()) {
		   	case KeyEvent.VK_S:
		    
		    	break;
		   }
	  }
	
	  @Override
	  public void keyReleased(KeyEvent e) {
	  }
	
	  @Override
	  public void keyTyped(KeyEvent e) {
	  }

 }

}

