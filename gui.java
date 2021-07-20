package math_tutor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* <h1>Add Two Numbers!</h1>
* The GUI for the Math Tutor appliction that
* uses awt and swing libraries.
*
* @author  Blane Staskiewicz
*/
public class gui implements ActionListener, KeyListener{
	public static final int WIDTH = 100;
	public static final int HEIGHT = 300;
	
	JFrame f = new JFrame("Math Tutor");
	JTextField tf = new JTextField(20); 
	JLabel prob = new JLabel();
	JLabel ans = new JLabel();
	JButton b = new JButton("New Problem");
	JPanel panel = new JPanel();
	
	/** 
	* No argument constructor
	*/
	public gui() {
		// JPanel
        	panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(prob, BorderLayout.NORTH);
		panel.add(ans, BorderLayout.WEST);
		panel.setBackground(Color.GRAY);
		// JTextField
		tf.setPreferredSize(new Dimension(10, 30));
		tf.addKeyListener(this);
		tf.setEditable(true);
		panel.add(tf, BorderLayout.EAST);
		// JButton
		b.setPreferredSize(new Dimension(10, 30));
		b.setHorizontalTextPosition(AbstractButton.CENTER);
		b.setActionCommand("enable");
		b.addActionListener(this);
		b.setFocusable(false);
		panel.add(b, BorderLayout.SOUTH);
		// JFrame
		f.add(panel, BorderLayout.CENTER);
		f.setSize(WIDTH, HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	/** 
	* Prompts the gui, until valid input occurs
	*  
	* @param op	  string operation
	* @param val1	  first value
	* @param val2	  second value
	* @param answer   answer to problem
	* @param count	  number of tries
	* @param input	  users input
	*/
	public void until_correct(String op, int val1, int val2, int answer, int count, int input) {  
		// validates input, loops until correct input
		if(validateInput(input, answer) == 0) {
        		while (validateInput(input, answer) == 0) {
				count++;
				gui window1 = new gui();
				window1.prob.setText("How much is " + val1 + " " + op + " " + val2);
	            		window1.ans.setText("I'm sorry, but no. Please Try again.");
	            
				// wait until enter key is pressed
				while(window1.f.isShowing() == true) {
					System.out.print("");
				}

				// new question after button press/enter with no input
				if(window1.tf.getText().equals("")) {
					driver.new_question();
				}

				// get user input
				if(!window1.tf.getText().equals("")) {
					String user_input = window1.tf.getText();
					input = Integer.parseInt(user_input);
				}
        		}
        	}
		// count for last try
		count++;

		// correct input
		if(validateInput(input, answer) == 1) {
			// tries more than 1 time
			if(count > 1) {
				gui window2 = new gui();
				window2.prob.setText("How much is " + val1 + " " + op + " " + val2);
			    	window2.ans.setText("Very Good! It only took you " + count + " tries.");

			    	// wait until enter key is pressed
				while(window2.f.isShowing() == true) {
					System.out.print("");
				}

				// new question after button press/enter with no input
				if(window2.tf.getText().equals("")) {
					driver.new_question();
				}
			}
			// only takes 1 try
			else if(count == 1) {
				gui window3 = new gui();
				window3.prob.setText("How much is " + val1 + " " + op + " " + val2);
			    	window3.ans.setText("Very Good! It only took you " + count + " try.");

			    	// wait until enter key is pressed
				while(window3.f.isShowing() == true) {
					System.out.print("");
				}

				// new question after button press/enter with no input
				if(window3.tf.getText().equals("")) {
					driver.new_question();
				}
			}
			// first try
			else if(count == 0) {
				gui window4 = new gui();
				window4.prob.setText("How much is " + val1 + " " + op + " " + val2);
			    	window4.ans.setText("Very Good! You got it on the first try!");

			    	// wait until enter key is pressed
				while(window4.f.isShowing() == true) {
					System.out.print("");
				}

				// new question after button press/enter with no input
				if(window4.tf.getText().equals("")) {
					driver.new_question();
				}
			}
		}
	}
	/** 
	* Used to validate the users input
	*  
	* @param input	  users input
	* @param answer   answer to problem
	* @return 0, 1	  correct (1) or not (0)
	*/
	private static int validateInput(int input, int answer){
		if(input == answer) {
			return 1;
		}
		return 0;
	}
	/** 
	* Used to check for action on the button
	* 
	* @param e  Action performed
	*/
	public void actionPerformed(ActionEvent e){
		try {
			f.setVisible(false);
		} 
		catch (Exception e1) {}
	} 
	/** 
	* Used for when a key is pressed: enter/return, esc
	* 
	* @param e  Key pressed event performed
	*/
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	        	f.setVisible(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	/** 
	* This method is for when a key is Typed
	*/
	public void keyTyped(KeyEvent e) {}
	/** 
	* This method is for when a key is Released
	*/
	public void keyReleased(KeyEvent e) {}
}

