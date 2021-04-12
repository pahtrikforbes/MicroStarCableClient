
package loginregisterprompt;

import javax.swing.*;

import utils.Role;

import view.registrationForm;

import views.LoginView;
import views.RegistrationView;

import java.awt.*;
import java.awt.event.*;

public class LoginRegisterPrompt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public LoginRegisterPrompt(){

		//super("Login Autentification");
		
		setSize(420,300);
		setLocation(500,280);
		panel.setLayout (null);  
		
		//userName.setBounds(30, 30, 100, 20);
		//userPassword.setBounds(30,65,100,20);
		
		//textArea.setBounds(130,30,150,20);
		//passArea.setBounds(130,65,150,20);
		
		heading.setBounds(10,15,600,20);
		loginArea.setBounds(150,40,120,80);
		registerLabel.setBounds(140, 125, 200, 40);
		registerArea.setBounds(150,160,125,80);
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

			new RegistrationView();

			
		}
	});
	
	loginArea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		Object[] possibilities = {"Representative", "Customer", "Technician"};

			Component frame = null;
			setLocation(520,280);
			String choice = (String)JOptionPane.showInputDialog(
			 frame, "Please specify the role youre registering as:\n"
			                    + "\"I am a: \"",
			                    "Login Option:",
			                    JOptionPane.PLAIN_MESSAGE,
			                    icon,
			                    possibilities,
			                    "Staff");

			if ((choice != null) && (choice.length() > 0)) {
				if(choice == "Representative") {
					LoginView loginView = new LoginView();
					loginView.showForm(Role.REPRESENTATIVE);
					
					//calls the staff login
				}if(choice.equals("Customer")) {
					LoginView loginView = new LoginView();
					loginView.showForm(Role.CUSTOMER);
				}if(choice.equals("Technician")) {
					LoginView loginView = new LoginView();
					loginView.showForm(Role.TECHNICIAN);

				}
			    return;
			}
		}
	});
	 
}

		public static void main(String[] args) {
			new LoginRegisterPrompt();

}
}
