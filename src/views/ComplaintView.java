package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.Complaint;
import utils.ComplaintCategory;
import utils.ComplaintType;

public class ComplaintView extends JFrame implements ActionListener{

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
	    
	    showForm();
	}

	
	
	public void createWindow()
    {
       //Setting properties of JFrame; i.e this frame
        this.setTitle("Complaint Form");
        this.setBounds(550,100,400,550);
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
	
	
	public void setLocationAndSize()
    {
//		Setting Location and Size of Each Component
        this.custIdLabel.setBounds(20,20,160,70);
        this.categoryLabel.setBounds(20,70,160,70);
        this.typeLabel.setBounds(20,120,160,70);
        this.complaintLabel.setBounds(20,170,160,70);
        
//		Set label fonts
        this.custIdLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.categoryLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.typeLabel.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.complaintLabel.setFont(new Font("Times New Roman", Font.BOLD,12));

        
//		Set field fonts
        this.custIdTextField.setFont(new Font("Times New Roman", Font.BOLD,13));
        this.complaintTextArea.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.categoryComboBox.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.typeComboBox.setFont(new Font("Times New Roman", Font.BOLD,12));
        
//		Set bounds
        this.custIdTextField.setBounds(180,43,185,23);
        this.categoryComboBox.setBounds(180,93,185,23);
        this.typeComboBox.setBounds(180,143,185,23);
        this.complaintTextArea.setBounds(180,193,185,170);       
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        complaintTextArea.setBorder(border);
        this.submitButton.setBounds(70,395,100,35);
        this.resetButton.setBounds(220,395,100,35);     
        
    }
	
//    Adds components to the JFrame
	public void addComponentsToFrame() {
    	this.add(this.custIdLabel);
    	this.add(this.categoryLabel);
    	this.add(this.complaintLabel);
    	this.add(this.typeLabel);
    	    	
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
    	 this.setLocationAndSize(); 
    	 this.addComponentsToFrame();
    }
    
    

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.submitButton) {
			Complaint complaint = new Complaint();
			
			int custID = Integer.parseInt(this.custIdTextField.getText());
			complaint.setCustID(custID);
			complaint.setComplaint(this.complaintTextArea.getText());
			complaint.setEmpID(0000);

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
			
			System.out.println("Success!");
		
		}else if(e.getSource() == this.resetButton) {
			this.reset();
		}
		
	}
	
	
}




















