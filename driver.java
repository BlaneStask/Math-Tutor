package math_tutor;
import java.util.*;

/**
* <h1>Math Tutor</h1>
* A GUI‐based Java application that would help an 
* elementary school student learn the mathematical
* operations of addition, subtraction, and multiplication.
*
* @author  Blane Staskiewicz
*/
public class driver{ 
	 /** 
	 * The main/driver method
	 * 
	 * @param args	Not used
	 */
	public static void main(String[] args) {
		new_question();
	}
	 /** 
	 * Used to get a new question
	 */
	public static void new_question() {
		int count = 0;
		
		// random 1-3 for operation
		Random rand = new Random();
		int operation = rand.nextInt(3) + 1;
		
		// set op
		String op = "";
		if(operation == 1) {
			op = "plus";
		}
		else if(operation == 2) {
			op = "minus";
		}
		else if(operation == 3) {
			op = "times";
		}
		
		// sets val1 and val2
		Random rand1 = new Random();
		int val1 = rand1.nextInt(10) + 1;
		Random rand2 = new Random();
		int val2 = rand2.nextInt(10) + 1;
		
		// sets answer based on op, val1 and val2
		int answer = 0;
		if(op == "plus") {
			answer = val1 + val2;
		}
		else if(op == "minus") {
			answer = val1 - val2;
		}
		else if(op == "times") {
			answer = val1 * val2;
		}
		
		int input = 0;
		// opening prompt for math tutor application
		gui window = new gui();
		window.prob.setText("How much is " + val1 + " " + op + " " + val2);
		window.ans.setText("Please enter your answer.");

		// wait until enter key is pressed
		while(window.f.isShowing() == true) {
			System.out.print("");
		}
		
		// new question after button press/enter with no input
		if(window.tf.getText().equals("")) {
			new_question();
		}
		
        	// get user input
		if(!window.tf.getText().equals("")) {
			String user_input = window.tf.getText();
			input = Integer.parseInt(user_input);
		}
        
		// calls until correct value and checker method
		window.until_correct(op, val1, val2, answer, count, input);
	}
}


