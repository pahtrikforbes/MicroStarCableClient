
package login;

import javax.swing.*;

import view.registrationForm;

import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

	/*
	 * JLabel userName = new JLabel("UserView Name"); JLabel userPassword = new
	 * JLabel("UserView Password");
	 */
JLabel registerLabel = new JLabel("Don't have an account? ");
JLabel heading = new JLabel("Please specify your choice by clicking on the buttons provided.");


JButton loginArea = new JButton("Login");
JButton registerArea = new JButton("Register here...");

JPanel panel = new JPanel();
JTextField textArea = new JTextField(15);
JPasswordField passArea = new JPasswordField(15);
protected Icon icon;
JFrame f;

	public UserLogin(){
		//super("Login Autentification");
		
		setSize(1000,450);
		setLocationRelativeTo(null);
		panel.setLayout (null);  
		
		
		heading.setBounds(280,60,400,20);
		heading.setHorizontalAlignment(JLabel.CENTER);
		loginArea.setBounds(420,100,120,80);
		registerLabel.setBounds(410,180, 200, 40);
		registerArea.setBounds(420,240,120,80);
		//registerArea.setVisible(false);
		
		panel.add(heading);
		panel.add(registerLabel);
		panel.add(loginArea);
		panel.add(registerArea);
		//panel.setMaximumSize(new Dimension(420,300));

		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		action();
	}

	public void action(){
	registerArea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			dispose();
			registrationForm register = new registrationForm();
			panel.add(register);
			pack();
			
		}
	});
	
	loginArea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			Object[] possibilities = {"Staff", "Customer"};
			Component frame = null;
			setLocation(18,18);
		//frame;
			String choice = (String)JOptionPane.showInputDialog(
			 frame, "Please specify the role youre registering as:\n"
			                    + "\"I am a: \"",
			                    "Login Option:",
			                    JOptionPane.PLAIN_MESSAGE,
			                    icon,
			                    possibilities,
			                    "Staff");


			//If a string was returned, say so.
			if ((choice != null) && (choice.length() > 0)) {
				if(choice == "Staff") {
					dispose();
					f = new JFrame();
					JOptionPane.showMessageDialog(f,"Your choice was Staff");
					//calls the staff login
				}if(choice.equals("Customer")) {
					dispose();
					f = new JFrame();
					JOptionPane.showMessageDialog(f,"Your choice was Customer");
					//calls the customer login
				}
			    return;
			}
		}
	});
	 
}

		public static void main(String[] args) {
			UserLogin userlogin = new UserLogin();
			
}
}
