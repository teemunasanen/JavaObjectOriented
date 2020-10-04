package Lämpötilamuunnin;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lämpötilamuunnin implements ActionListener {
	
	JFrame frame = new JFrame("Celsius Converter");
	JLabel label1 = new JLabel("Celsius");
	JTextField input = new JTextField();
	JButton button1 = new JButton("Convert");
	JLabel output = new JLabel("Fahrenheit: ");

	
	public Lämpötilamuunnin(){
		
		JPanel p1 = new JPanel();
		JFrame frame = new JFrame("Celsius Converter");
		p1.setLayout(new GridLayout (2,2));
		
	
		
		p1.add(label1);
		p1.add(input);
		p1.add(button1);
		p1.add(output);
		
		frame.add(p1);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
	
		
		button1.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,150);
		frame.setVisible(true);
		}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
		if(isDouble(input.getText())) {
			double numbers = Double.parseDouble(input.getText());
			double converted = (numbers*1.8 + 32.0);
			output.setText("Fahrenheit: " + converted);
			

		}else {
			output.setText("Numbers only!");
		}
		}
	}	
	public boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
		
			
		
		
		public static void main(String[] args) {
				new Lämpötilamuunnin();
		}
}
