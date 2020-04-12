/*
Author: Blane Staskiewicz
E-mail: bas6248@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 5
Due date: 4/14/2020
Files: package math_tutor - driver.java, gui.java
Purpose: 
Compiler/IDE: Java SE Development Kit 13.0.2/Eclipse Foundation
  IDE 2019-12
Operating system: macOS Catalina Version 10.15.4
Reference(s): Java 10 API - Oracle Documentation
  (https://docs.oracle.com/javase/10/docs/api/)
  Lecture Slides and Demo Programs
*/ 

package math_tutor;
import java.util.*;

public class driver{ 
	/** This method is the main/driver method
	 * 
	 * @throws Exception 
	 * @call				calls other methods for values
	 */
	public static void main(String[] args) {
			new_question();
	}
	/** This method is used to get a new question
	 * 
	 * @throws Exception e	 ends program
	 * @call				 calls to prompt for gui
	 */
	public static void new_question() {
		int count = 0;
		
		//random 1-3 for operation
		Random rand = new Random();
		int operation = rand.nextInt(3) + 1;
		
		//set op
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
		
		//sets val1 and val2
		Random rand1 = new Random();
		int val1 = rand1.nextInt(11);
		Random rand2 = new Random();
		int val2 = rand2.nextInt(11);
		
		//sets answer based on op, val1 and val2
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
		//opening prompt for math tutor application
		gui window = new gui();
        window.prob.setText("How much is " + val1 + " " + op + " " + val2);
        window.ans.setText("Please enter your answer.");
        
        //wait until enter key is pressed
		while(window.f.isShowing() == true) {
			System.out.print("");
		}
		
		//new question after button press/enter with no input
		if(window.tf.getText().equals("")) {
			new_question();
		}
		
        //get user input
		if(!window.tf.getText().equals("")) {
			String user_input = window.tf.getText();
			input = Integer.parseInt(user_input);
		}
        
        //calls until correct value and checker method
        window.until_correct(op, val1, val2, answer, count, input);
	}
}


