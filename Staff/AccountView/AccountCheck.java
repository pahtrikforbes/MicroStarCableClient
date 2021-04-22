package AccountView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import ResponseView.addResponse;
import controllers.ComplaintController;
import controllers.ResponseController;
import models.Complaint;
import models.Response;
import utils.CustomizedException;

public class AccountCheck extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	
	private JLabel userIdLabel;
	

	
	public JTextField userIdTextField;
	

	
	
	
	
	
	private JButton submitButton;
   
	
	public AccountCheck() {
		super();
//		Labels

		this.userIdLabel = new JLabel("User Id");
		
		
//		TextField
		this.userIdTextField = new JTextField();

//		Buttons
		this.submitButton= new JButton("submit");
	   	
	   
		
	    
	    showForm();
	}
	
	public void createWindow() {
		this.setTitle("Account Status");
		this.setSize(400,180);
		this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	}
	 

	public void setLocationAndSize()
    {
//		Setting Location and Size of Each Component
        this.userIdLabel.setBounds(20,20,160,70);
     
       
        
//		Set label fonts
        this.userIdLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
       

       
		
//		Set field fonts
        this.userIdTextField.setFont(new Font("Times New Roman", Font.BOLD,13));
       
        
       
        
//		Set bounds
        this.userIdTextField.setBounds(150,43,185,23);

       
       
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
  
        this.submitButton.setBounds(170,90,100,35);
        
        
        this.userIdTextField.setEnabled(true);
    }
	
//    Adds components to the JFrame
	public void addComponentsToFrame() {
    	this.add(this.userIdLabel);
 
    	//    	this.add(this.responseEmptyLabel);
    	//    	this.add(this.complaintIdEmptyLabel);

    	    	
    
    	this.add(this.userIdTextField);

    	
   	
    	this.add(this.submitButton);
    	
    	
    	this.submitButton.addActionListener(this);
    	
    }
	


	
//	Shows the JFrame 
    public void showForm() {
    	 this.createWindow(); 
    	 this.setLocationAndSize(); 
    	 this.addComponentsToFrame();
    }
    
   public Complaint inputComplaint;
    

	public Complaint getInputComplaint() {
	return inputComplaint;
}

public void setInputComplaint(Complaint inputComplaint) {
	this.inputComplaint = inputComplaint;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.submitButton) {
			
			System.out.println("\nSubmit button clicked!");
			
			System.out.println("Test1");
	
		}
	
					
				
		
	
	}
	
	
	

	


	public static void main(String[] args) {
		new AccountCheck();

	}

}
