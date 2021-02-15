package com.reena.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainApplication extends JFrame implements ActionListener { 
   
	private static final long serialVersionUID = 1L;
	
	private static JFrame frame; 
    private static JTextField regex; 
    private static JTextField input; 
    private static JRadioButton stringCheck,patternCheck;    
    private static JButton check;
    private static JButton clear;
    private static JTextArea output; 

    public static void main(String[] args) 
    { 
    	frame = new JFrame("Pattern Validator");
    	frame.setSize(415, 600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	frame.add(designGrid());
        
        MainApplication obj = new MainApplication();     
        check.addActionListener(obj); // addActionListener to button  
        clear.addActionListener(obj);
        
        frame.setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e)  // if the button is pressed 
    { 
        if (e.getActionCommand().equals("Search")) { 
        	
            if(stringCheck.isSelected()) {
            	
            	System.out.println("String check");
            	output.setText(RegexCheck.stringMatcher(input.getText(), regex.getText()));
            	
            } else if(patternCheck.isSelected()) {
            	
            	System.out.println("Pattern check");
            	output.setText(RegexCheck.patternMatcher(input.getText(), regex.getText()));
            	
            } else {
            	output.setText("Select a check type !!");
            }
           
        } else if(e.getActionCommand().equals("Clear")) {
        	System.out.println("clear");
        	clear();
        }
    }

	private static JPanel designGrid() {
		final String[] labels = {"Regex: ", "Input: ","String Check", "Pattern Check"};
		regex = new JTextField(27); 
        input = new JTextField(27);
    	output = new JTextArea("");
    	output.setEditable(false);
    	
    	check = new JButton("Search"); 
    	clear = new JButton("Clear");   
  
        JPanel panel = new JPanel(); 
        panel.add(new JLabel(labels[0]));
        panel.add(regex);
        panel.add(new JLabel(labels[1]));
        panel.add(input);
        
        stringCheck = new JRadioButton(labels[2],true);    
        patternCheck = new JRadioButton(labels[3]);    
        
        panel.add(stringCheck);
        panel.add(patternCheck);
        panel.add(check);
        panel.add(clear);
        panel.add(output);
		return panel;
	} 
	private void clear() {
		regex.setText("");
		input.setText("");
		stringCheck.setSelected(true);
		patternCheck.setSelected(false);
		output.setText("");
	}

}
