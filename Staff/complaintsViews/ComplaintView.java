package complaintsViews;

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

import controllers.ComplaintController;
import controllers.UserController;
import models.Complaint;
import models.User;
import utils.ComplaintCategory;
import utils.ComplaintType;
import utils.CustomizedException;

public class ComplaintView extends JInternalFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] complaintCategory;
	private String [] complaintType;
	
	private JLabel custIdLabel;
	private JLabel categoryLabel;
	private JLabel complaintLabel;
	private JLabel typeLabel;
	private JLabel custIdEmptyLabel;
	private JLabel complaintEmptyLabel;
	
	private JTextField custIdTextField;
	private JTextArea complaintTextArea;
	
	private JComboBox<String> categoryComboBox;
	private JComboBox<String> typeComboBox;
	
	private JButton submitButton;
    private JButton resetButton;
//    Have the submit button do both send the info as well 
//    to send the date at which the form complaint form
//    was filled out
    
    
	
	public ComplaintView() {
		super();
//		Labels
		this.complaintCategory = new String[]{"MILD","MODERATE","SEVERE"};
		this.complaintType = new String[] {"BROADBAND","CABLE"};
		this.custIdLabel = new JLabel("CUSTOMER ID");
		this.categoryLabel = new JLabel("COMPLAINT CATEGORY");
		this.complaintLabel = new JLabel("COMPLAINT DETAILS");
		this.typeLabel = new JLabel("COMPLAINT TYPE");
//		TextField
		this.custIdTextField = new JTextField();
//		TextArea
		this.complaintTextArea = new JTextArea();
//		ComboBoxes
		this.categoryComboBox = new JComboBox<String>(this.complaintCategory);
		this.typeComboBox = new JComboBox<String>(this.complaintType);
//		Buttons
		this.submitButton= new JButton("SUBMIT");
	    this.resetButton = new JButton("RESET");	
	    this.custIdEmptyLabel = new JLabel("Error message");
		this.complaintEmptyLabel = new JLabel("Error message");
		
	    
	    showForm();
	}

	
	
	public void createWindow()
    {
       //Setting properties of JFrame; i.e this frame
        this.setTitle("Complaint Form");
        this.setBounds(45,50,400,550);
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);
    }
	
	
	public void setLocationAndSize()
    {
//		Setting Location and Size of Each Component
        this.custIdLabel.setBounds(240,20,160,70);
        this.categoryLabel.setBounds(240,70,160,70);
        this.typeLabel.setBounds(240,120,160,70);
        this.complaintLabel.setBounds(240,170,160,70);

        
//		Set label fonts
        this.custIdLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.categoryLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.typeLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.complaintLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.custIdEmptyLabel.setFont(new Font("Times New Roman", Font.BOLD,11));
		this.complaintEmptyLabel.setFont(new Font("Times New Roman", Font.BOLD,11));
		
		
//		Set field fonts
        this.custIdTextField.setFont(new Font("Times New Roman", Font.BOLD,13));
        this.complaintTextArea.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.categoryComboBox.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.typeComboBox.setFont(new Font("Times New Roman", Font.BOLD,12));
        
//		Set bounds
        this.custIdTextField.setBounds(400,43,185,23);
        this.categoryComboBox.setBounds(400,93,185,23);
        this.typeComboBox.setBounds(400,143,185,23);
        this.complaintTextArea.setBounds(400,193,185,170);       
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        complaintTextArea.setBorder(border);
        this.submitButton.setBounds(300,395,100,35);
        this.resetButton.setBounds(440,395,100,35);     
        
    }
	
//    Adds components to the JFrame
	public void addComponentsToFrame() {
    	this.add(this.custIdLabel);
    	this.add(this.categoryLabel);
    	this.add(this.complaintLabel);
    	this.add(this.typeLabel);
//    	this.add(this.custIdEmptyLabel);
//    	this.add(this.complaintEmptyLabel);
    	    	
    	this.add(this.custIdTextField);
    	this.add(this.categoryComboBox);
    	this.add(this.typeComboBox);
    	this.add(this.complaintTextArea);
   	
    	this.add(this.submitButton);
    	this.add(this.resetButton);
    	
    	this.submitButton.addActionListener(this);
    	this.resetButton.addActionListener(this);
    }
	
//    Reset method
    private void reset() {
    	this.custIdTextField.setText("");
    	this.categoryComboBox.setSelectedIndex(0);
    	this.typeComboBox.setSelectedIndex(0);
    	this.complaintTextArea.setText("");
    }
	
//	Shows the JFrame 
    public void showForm() {
    	 this.createWindow(); 	 
    }
    
    
    public int userMap (int i, int id) {
    	if (i == 1) {
    	 this.setLocationAndSize(); 
       	 this.addComponentsToFrame();
       	 
    	} else if (i == 2) {
    		String userId = String.valueOf(id);
    		this.custIdTextField.setEditable(false);
    		this.custIdTextField.setText(userId);
    		this.setLocationAndSize(); 
          	this.addComponentsToFrame();
    	}
    	
    	return i;
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.submitButton) {
			
			System.out.println("\nSubmit button clicked!");
			String custIdText = custIdTextField.getText();
			String complaintDetails = complaintTextArea.getText();
			
			
			if (!custIdText.equals("") && !complaintDetails.equals("")) {
//				System.out.println("Both are not Empty");
				Complaint complaint = new Complaint();
				UserController uc = new UserController();
				ComplaintController cc = new ComplaintController();
				int custId = Integer.parseInt(custIdText.trim());
				User userId = null;
				try {
					 userId = uc.findById(custId);
				} catch (CustomizedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				
				complaint.setCustID(userId);
				complaint.setComplaint(this.complaintTextArea.getText());
				complaint.setEmpID(null);

				switch(((String)this.categoryComboBox.getSelectedItem()).toLowerCase()){
					case "mild":
						complaint.setCategory(ComplaintCategory.MILD);
					break;
				
					case "moderate":
						complaint.setCategory(ComplaintCategory.MODERATE);
					break;
					
					case "severe":
						complaint.setCategory(ComplaintCategory.SEVERE);
					break;
					
					default: 
						throw new IllegalArgumentException("Unexpected value: " 
						+ this.categoryComboBox.getSelectedItem());
				}
				
				switch(((String)this.typeComboBox.getSelectedItem()).toLowerCase()){
				case "broadband":
					complaint.setComplaintType(ComplaintType.BROADBAND);
				break;
			
				case "cable":
					complaint.setComplaintType(ComplaintType.CABLE);
				break;
				
				default: 
					throw new IllegalArgumentException("Unexpected value: " 
					+ this.typeComboBox.getSelectedItem());
			}
				
				java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
				complaint.setComplaintDate(sqlDate);
				
				
				try {
					int complaintId = cc.createComplaint(complaint);
					
					if(complaintId > 0) {
						JOptionPane.showMessageDialog(ComplaintView.this,
								"Complaint added successfully!\n"
								+ "Submitted: "+sqlDate
				          			    );
					} else {
						System.out.println("Complaint creation unsuccessful");
						JOptionPane.showMessageDialog(ComplaintView.this,
								"Complaint action failed!\n"
								+ "Please enter a valid Customer Id\n"
								+ "Submitted: "+sqlDate
				          			    );		
					}
					
					
				} catch (CustomizedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ComplaintView.this,
							"Complaint action failed!\n"
							+ "Submitted: "+sqlDate
			          			    );				
				} 
				
			}else if (!custIdText.equals("")) {
				try {
					int i = Integer.parseInt(custIdText);
				}catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(ComplaintView.this,
							"Letters are not allowed!\nPlease try again.",
			          			    "Invalid Submission",
			          			    JOptionPane.ERROR_MESSAGE);
				}
			}
			else { JOptionPane.showMessageDialog(ComplaintView.this,
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
		System.out.println("Complaints View\n");
		new ComplaintView();
		
	}
	
}




















