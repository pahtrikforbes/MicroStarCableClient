package ResponseView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import complaintsViews.ComplaintView;
import controllers.ComplaintController;
import controllers.ResponseController;
import controllers.UserController;
import models.Complaint;
import models.Response;
import models.User;
import utils.ComplaintCategory;
import utils.ComplaintType;
import utils.CustomizedException;
import java.util.*;
import java.sql.*;


public class addResponse extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	
	private JLabel complaintIdLabel;
	
	private JLabel responseLabel;
	
	
	public JTextField complaintIdTextField;
	private JTextArea responseTextArea;
	
	
	private JLabel responseEmptyLabel;
	private JLabel  complaintIdEmptyLabel;
	
	private JButton submitButton;
    private JButton resetButton;
	
	public addResponse() {
		super();
//		Labels

		this.complaintIdLabel = new JLabel("COMPLAINT ID");
		this.responseLabel = new JLabel("RESPONSE");
		
		
//		TextField
		this.complaintIdTextField = new JTextField();
//		TextArea
		this.responseTextArea = new JTextArea();
//		ComboBoxes
		
//		Buttons
		this.submitButton= new JButton("SUBMIT");
	    this.resetButton = new JButton("RESET");	
	    this.responseEmptyLabel = new JLabel("Error message");
		this.complaintIdEmptyLabel = new JLabel("Error message");
		
	    
	    showForm();
	}
	
	public void createWindow() {
		this.setTitle("Add Response");
		this.setSize(440,440);
		this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	}
	 

	public void setLocationAndSize()
    {
//		Setting Location and Size of Each Component
        this.complaintIdLabel.setBounds(50,20,160,70);
     
        this.responseLabel.setBounds(50,65,160,70);

        
//		Set label fonts
        this.complaintIdLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
       
        this.responseLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.responseEmptyLabel.setFont(new Font("Times New Roman", Font.BOLD,11));
		this.complaintIdEmptyLabel.setFont(new Font("Times New Roman", Font.BOLD,11));
		
		
//		Set field fonts
        this.complaintIdTextField.setFont(new Font("Times New Roman", Font.BOLD,13));
        this.responseTextArea.setFont(new Font("Times New Roman", Font.BOLD,12));
        
       
        
//		Set bounds
        this.complaintIdTextField.setBounds(200,43,185,23);
       
       
        this.responseTextArea.setBounds(200,90,185,170);       
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        responseTextArea.setBorder(border);
        this.submitButton.setBounds(100,290,100,35);
        this.resetButton.setBounds(240,290,100,35);     
        
        this.complaintIdTextField.setEnabled(false);
    }
	
//    Adds components to the JFrame
	public void addComponentsToFrame() {
    	this.add(this.complaintIdLabel);
    	this.add(this.responseLabel);
    	//    	this.add(this.responseEmptyLabel);
    	//    	this.add(this.complaintIdEmptyLabel);

    	    	
    	this.add(this.responseTextArea);
    	this.add(this.complaintIdTextField);
    	
   	
    	this.add(this.submitButton);
    	this.add(this.resetButton);
    	
    	this.submitButton.addActionListener(this);
    	this.resetButton.addActionListener(this);
    }
	
//    Reset method
    private void reset() {
    	this.responseTextArea.setText("");

    	this.complaintIdTextField.setText("");
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
			String complaintIdText = complaintIdTextField.getText();
			System.out.println("Test1");
			String responseText = responseTextArea.getText();
			
			
			if (!responseText.equals("") ) {
//				System.out.println("Both are not Empty");
				ResponseController uc = new ResponseController();
				ComplaintController cc = new ComplaintController();
				int complaintId = Integer.parseInt(complaintIdText);
				
				System.out.println("Now inside if Statement in adResponse\n"
						+ "Details of selected complaint: "+inputComplaint);
			
				
//				Complaint complaint = null;
			
				
				Response response = new Response();
				System.out.println("now setting response complaint id");
				response.setComplaint_id(inputComplaint);
				response.setResponse(this.responseTextArea.getText());
				System.out.println("Test2");
				
				
				java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
				response.setResponse_date(sqlDate);
				
				System.out.println("Test3");
				
				try {
					System.out.println("Test6");
					int responseId = uc.createResponse(response);
					System.out.println("Test4");
					
					if(responseId  > 0) {
						JOptionPane.showMessageDialog(addResponse.this,
								"Response added successfully!\n"
								+ "Submitted: "+sqlDate
				          			    );
					} else {
						System.out.println("Complaint creation unsuccessful");
					}
					
					
				} catch (CustomizedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} 
				
			} else {
				 JOptionPane.showMessageDialog(addResponse.this,
				"Empty inputs are not allowed. Please try again!",
          			    "Invalid Submission",
          			    JOptionPane.ERROR_MESSAGE);
			}
	
		}else if(e.getSource() == this.resetButton) {
			this.reset();
			System.out.println("Reset button clicked");
		}
		
	
	}
	
	
	

	


	public static void main(String[] args) {
		new addResponse();

	}

}
