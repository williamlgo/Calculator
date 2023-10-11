import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	//Initializing some stuff
	JFrame frame;
	JPanel panel;
	JTextField textfield;
	JButton add, sub, mult, div; //Operations
	JButton decimal, equal, delete, clear; //Other buttons
	JButton functions[] = {add, sub, mult, div, decimal, equal, delete, clear};
	JButton numbers[]= new JButton[10];
	Font myFont = new Font("", Font.BOLD, 30);
	
	//These will be used for calculations
	double num1=0, num2=0, result=0;
	char operator;
	
	public Calculator() {
		//Initializing the values
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		//Setting up the Text Field
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		//Setting up the Buttons for Operations and Other
		add = new JButton("+");
		add.addActionListener(this);
		sub = new JButton("-");
		sub.addActionListener(this);
		mult = new JButton("*");
		mult.addActionListener(this);
		div = new JButton("/");
		div.addActionListener(this);
		decimal = new JButton(".");
		decimal.addActionListener(this);
		equal = new JButton("=");
		equal.addActionListener(this);
		delete = new JButton("Delete");
		delete.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		//Setting up Buttons for Numbers
		for(int i=0; i<10; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
		}//end for
		
		delete.setBounds(50, 430, 145, 50);
		clear.setBounds(205, 430, 145, 50);
		
		//Adding a Panel for the buttons
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		//Adding the numbers to the panel
		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);
		panel.add(div); //End of row 1
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(mult); //End of row 2
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);
		panel.add(sub); //End of row 3
		panel.add(numbers[0]);
		panel.add(decimal);
		panel.add(equal);
		panel.add(add); //End of row 4
		
		//Adding to the frame
		frame.add(delete);
		frame.add(clear);
		frame.add(textfield);
		frame.add(panel);
		
		frame.setVisible(true);
	}//end constructor
	
	public static void main(String[] args) {
		//running the actual calculator by initializing the object.
		Calculator calc = new Calculator();
	}//end main

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Number Buttons ==================================CHANGE THIS TO A RLY LONG IF ELSE LOL
		for(int i=0; i<10; i++) {
			if(e.getSource() == numbers[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}//end for
		
		//Functions
		if(e.getSource() == decimal) {
			textfield.setText(textfield.getText().concat("."));
		} else if(e.getSource() == div) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText(""); //Clear the text so that you can write the next number
		} else if(e.getSource() == mult) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText(""); //Clear the text so that you can write the next number
		} else if(e.getSource() == sub) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText(""); //Clear the text so that you can write the next number
		} else if(e.getSource() == add) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText(""); //Clear the text so that you can write the next number
		} else if(e.getSource() == clear) {
			textfield.setText("");
			//Resetting all values
			num1 = 0;
			num2 = 0;
			result = 0;
		} else if(e.getSource() == delete) {
			//This should remove the last character and set the textfield blank
			String str = textfield.getText();
			textfield.setText("");
			
			//Go through every character of the string except for the last one
			for(int i=0; i<str.length()-1; i++) {
				//Set the text field as every character except for the last one in the string
				textfield.setText(textfield.getText()+str.charAt(i));
			}
		}
		
		//Calculate
		else if(e.getSource() == equal) {
			num2 = Double.parseDouble(textfield.getText());
			
			//Calculate based on the operator chosen
			if(operator == '/') {
				result = num1/num2;
			}
			else if(operator == '*') {
				result = num1*num2;
			}
			else if(operator == '-') {
				result = num1-num2;
			}
			else if(operator == '+') {
				result = num1+num2;
			}
			
			//Display Answer
			textfield.setText(String.valueOf(result));
			num1 = result; //result becomes num1 if user wants to continue putting in numbers
		}//end if else if
	}//end actionPerformed	
}//end calculator
