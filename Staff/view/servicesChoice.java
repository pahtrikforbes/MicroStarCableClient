package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class servicesChoice extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	
	public servicesChoice() {
		showForm();
	}
	
	public void createWindow() {
		this.setTitle("Services Information");
		this.setBounds(0,0,490,580);
		this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
//	    this.setResizable(false);
	}
	 
	
	public void showForm() {
		
		createWindow();
		//serviceStatus();
	}
	

	public static void main(String[] args) {
		new servicesChoice();

	}

}
