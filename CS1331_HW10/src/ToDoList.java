import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Constructs labels, buttons, and textfields
 * to help us create the to do list.
 * @author D'Miria Collins
 * @version 1.0
 *
 */

public class ToDoList extends JFrame {

	private DefaultListModel currentToDoList;
	private JTextField listItem;

    /**
     * Constructs a frame, a list and a text field.
     * @param e checks for an event being performed
     *
     */

	public ToDoList( ) {

	super("To Do List");
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.currentToDoList = new DefaultListModel();
	this.listItem = new JTextField("Enter item:");
	
	listItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(listItem.getText().length() > 0) {
			currentToDoList.addElement(listItem.getText());
			listItem.setText("");}
			}
		});

	add(listItem, BorderLayout.NORTH);
	add(new JList(currentToDoList), BorderLayout.CENTER);
	add(createButtonPanel(), BorderLayout.SOUTH);
	setSize(350,400);
	setVisible(true);
	listItem.setBackground(Color.PINK);

	}

    /**
     * This method creates an add item button and a remove item button.
     * After it creates the two buttons, it adds the buttons to a listPanel.
     * @param e checks for an event being performed
     *
     */

	private JPanel createButtonPanel() {
		JButton addButton = new JButton("Add item");
		addButton.setBackground(Color.YELLOW);
    	addButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
    			if (listItem.getText().length() > 0) {
			currentToDoList.addElement(listItem.getText());
			listItem.setText("");}
			}
		});

	JButton removeButton = new JButton("Remove last item");
	removeButton.setBackground(Color.YELLOW);
   	removeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (currentToDoList.size() > 0) {
			currentToDoList.removeElement(currentToDoList.lastElement());}
			}
	   });

	JPanel listPanel = new JPanel();
	listPanel.setBackground(Color.BLACK);
	listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.X_AXIS));
	listPanel.add(Box.createHorizontalGlue());
	listPanel.add(addButton);
	listPanel.add(removeButton);
	listPanel.add(Box.createHorizontalGlue());
	return listPanel;

    }

}