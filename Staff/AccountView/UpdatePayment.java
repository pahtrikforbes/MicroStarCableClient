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

public class UpdatePayment extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	
	private JLabel paymentStatusLabel;
	
	private JLabel amountDueLabel;
	
	private JLabel dueDateLabel;
	
	
	public JTextField paymentStatusTextField;
	
	public JTextField amountDueTextField;
	
	public JTextField dueDateTextField;

	
	
	
	
	
	private JButton submitButton;
   
	
	public UpdatePayment() {
		super();
//		Labels

		this.paymentStatusLabel = new JLabel("Payment Status");
		this.amountDueLabel = new JLabel("Amount Due");
		this.dueDateLabel=new JLabel("Payment Due Date");
		
//		TextField
		this.paymentStatusTextField = new JTextField();
		this.amountDueTextField = new JTextField();
		this.dueDateTextField = new JTextField();

//		Buttons
		this.submitButton= new JButton("submit");
	   	
	   
		
	    
	    showForm();
	}
	
	public void createWindow() {
		this.setTitle("Account Status");
		this.setSize(400,280);
		this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	}
	 

	public void setLocationAndSize()
    {
//		Setting Location and Size of Each Component
        this.paymentStatusLabel.setBounds(20,20,160,70);
     
        this.amountDueLabel.setBounds(20,60,160,70);

        
        this.dueDateLabel.setBounds(20,100,160,70);
        
//		Set label fonts
        this.paymentStatusLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
       
        this.amountDueLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
       
		
//		Set field fonts
        this.paymentStatusTextField.setFont(new Font("Times New Roman", Font.BOLD,13));
       
        
       
        
//		Set bounds
        this.paymentStatusTextField.setBounds(150,43,185,23);
        this.amountDueTextField.setBounds(150,83,185,23);
        this.dueDateTextField.setBounds(150,123,185,23);
       
       
       
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
  
        this.submitButton.setBounds(170,170,100,35);
        
      
        
    }
	
//    Adds components to the JFrame
	public void addComponentsToFrame() {
    	this.add(this.paymentStatusLabel);
    	this.add(this.amountDueLabel);
    	this.add(this.dueDateLabel);
    	//    	this.add(this.responseEmptyLabel);
    	//    	this.add(this.complaintIdEmptyLabel);

    	    	
    
    	this.add(this.paymentStatusTextField);
    	this.add(this.amountDueTextField);
    	this.add(this.dueDateTextField);
    	
   	
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
		new UpdatePayment();

	}

}
