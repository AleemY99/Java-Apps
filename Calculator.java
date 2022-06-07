import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	//ATTRIBUTES
	private JFrame frame;
	private JTextField textfield;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[8];
	private JButton addButton, subButton, multButton, divButton;
	private JButton decButton, eqlButton, delButton, clrButton;
	private JPanel panel;	
	private Font font1 = new Font("Arial", Font.BOLD, 30);
	private Font font2 = new Font("Arial", Font.ITALIC, 30);
	
	private double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	//CONSTRUCTOR
	public Calculator() {
		//JFrame set-up
		frame = new JFrame("Calculator");
		frame.setSize(425, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		//Calculator display
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(font1);
		textfield.setEditable(false);
		textfield.setBackground(Color.WHITE);
		
		//Setting function buttons
		addButton = new JButton("+");	functionButtons[0] = addButton;
		subButton = new JButton("-");	functionButtons[1] = subButton;
		multButton = new JButton("*");	functionButtons[2] = multButton;
		divButton = new JButton("/");	functionButtons[3] = divButton;
		decButton = new JButton(".");	functionButtons[4] = decButton;
		eqlButton = new JButton("=");	functionButtons[5] = eqlButton;
		delButton = new JButton("DEL");	functionButtons[6] = delButton;
		clrButton = new JButton("AC");	functionButtons[7] = clrButton;

		for(int i=0; i<8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font1);
			functionButtons[i].setFocusable(false);
		}
		
		//Setting number buttons
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font2);
			numberButtons[i].setFocusable(false);
		}
		
		//Setting delete and clear buttons
		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		
		//Setting panel
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(eqlButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource() == multButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource() == eqlButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource() == delButton) {
			StringBuilder string = new StringBuilder(textfield.getText());
			string = string.deleteCharAt(string.length()-1);
			textfield.setText(string.toString());
		}
	}
}