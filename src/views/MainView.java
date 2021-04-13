package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.IOException;



import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import models.User;
import utils.Role;


public class MainView extends JInternalFrame implements ActionListener, ItemListener {


	private static final long serialVersionUID = 1L;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JMenu userMenu, complaintMenu, responseMenu, accountMenu;
	private JLabel servicesLbl, title2, sub_title1, sub_title2, sub_title3;
	private JLabel logoLbl;
	private JMenuBar menuBar;
	private JComboBox<String> serviceBox;
	private String[] services;
	private JButton selectServiceBtn;
	private JButton logoutBtn;
	private JLabel loggedInUser;
	private Role role;
	private User user;
	private JMenuItem usrItem1, usrItem2, compItem1,compItem2,compItem3, accItem1,accItem2,accItem3;
	JToggleButton togBtn;
	private String availalbility;
	
    public MainView(Role role,User user) {
    	super("Micro Star");
    	rightPanel = new JPanel();
		leftPanel = new JPanel();
		userMenu  = new JMenu("Users");
		complaintMenu = new JMenu("Complaints");
		responseMenu = new JMenu("Responses");
		accountMenu = new JMenu("Account");
		menuBar = new JMenuBar();
		logoLbl  = new JLabel("Micro-Star CableVision");
		servicesLbl= new JLabel("Services");
		services = new String[] {"Cable","Broadband"};
		serviceBox = new JComboBox<>(services);
		selectServiceBtn = new JButton("Select");
		loggedInUser = new JLabel("HI "+user.getFirstName().toUpperCase());
		loggedInUser.setHorizontalAlignment(SwingConstants.CENTER);
		logoutBtn = new JButton("LOGOUT");
		this.role = role;
		this.user = user;
		usrItem1 = new JMenuItem("View Users");
		usrItem2 = new JMenuItem("");
		compItem1 = new JMenuItem("Add Complaint");
		compItem2 = new JMenuItem("View Complaints");
		compItem3 = new JMenuItem("Assign Technician");
		accItem1 = new JMenuItem("Account Status");
		accItem2 = new JMenuItem("Past Payments");
		accItem3 = new JMenuItem("Update Account");
		this.availalbility = "Go Online";
		togBtn = new JToggleButton(this.availalbility);
		this.setVisible(true);
		
		BasicInternalFrameUI basic = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener li : basic.getNorthPane().getMouseListeners()) {
			basic.getNorthPane().removeMouseListener(li);
		}
		
		showForm();
	}
    
    private void showForm() {
    	this.createWindow(); 
    	setLocationAndSize();
    	addComponentsToFrame() ;
	}

	public void createWindow()
    {
		this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(new BorderLayout());
        this.setVisible(true);
        this.setSize(1195,691);
       
    }
	
	 private void setLocationAndSize() {
		
		 userMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 complaintMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 responseMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 accountMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 loggedInUser.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 logoutBtn.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 togBtn.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
		 
		 leftPanel.setBackground(Color.BLACK);
		 leftPanel.setLayout(null);
		 leftPanel.setPreferredSize(new Dimension(300,100));
		 
		 rightPanel.setLayout(new BorderLayout());
		 logoLbl.setBounds(29, 17,300, 40);
		 logoLbl.setFont(new Font("Times New Roman", Font.BOLD, 24));
		 logoLbl.setForeground(Color.white);
		 
		 servicesLbl.setBounds(108,240,150, 30);
		 servicesLbl.setForeground(Color.white);
		 servicesLbl.setFont(new Font("Times New Roman", Font.BOLD, 24));
		 
		 title2 = new JLabel("Company Limited");
	     title2.setFont(new Font("Times New Roman", Font.BOLD, 23));
	     title2.setForeground(Color.LIGHT_GRAY);
	     title2.setBounds(60,55,200,23);
	        
	     sub_title1 = new JLabel("'Aspiration is built");
	     sub_title1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
	     sub_title1.setForeground(Color.white);
	     sub_title1.setBounds(1,95,300,23);
	     sub_title1.setHorizontalAlignment(JLabel.CENTER);

	        
	     sub_title2 = new JLabel("through Hardwork");
	     sub_title2.setFont(new Font("Times New Roman", Font.ITALIC, 17));
	     sub_title2.setForeground(Color.white);
	     sub_title2.setBounds(1,113,300,23);
	     sub_title2.setHorizontalAlignment(JLabel.CENTER);
	        
	     sub_title3 = new JLabel("and Dedication'");
	     sub_title3.setFont(new Font("Times New Roman", Font.ITALIC, 17));
	     sub_title3.setForeground(Color.white);
	     sub_title3.setBounds(1,131,300,23);
	     sub_title3.setHorizontalAlignment(JLabel.CENTER);

		 
		 

		 serviceBox.setBounds(50,280,200,30);
		 selectServiceBtn.setBounds(100,320,100,30);
		 rightPanel.setBackground(Color.LIGHT_GRAY);
		 
	 }

	 private void addComponentsToFrame() {
		 
		 this.add(rightPanel,BorderLayout.CENTER);
		 this.add(leftPanel,BorderLayout.WEST);
		
		 if(this.role.equals(Role.CUSTOMER)) {
			 
			 complaintMenu.add(compItem1);
			 complaintMenu.add(compItem2);
			 accountMenu.add(accItem1);
			 accountMenu.add(accItem2);
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);
		 }else if(this.role.equals(Role.REPRESENTATIVE)) {
			 complaintMenu.add(compItem1);
			 complaintMenu.add(compItem3);
			 accountMenu.add(accItem1);
			 accountMenu.add(accItem2);
			 accountMenu.add(accItem3);
			 userMenu.add(usrItem1);
			 
			 menuBar.add(userMenu);
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);
			 leftPanel.add(servicesLbl);
			 leftPanel.add(serviceBox);
			 leftPanel.add(selectServiceBtn);
			 
		 }else if(this.role.equals(Role.TECHNICIAN)) {
			 
			 complaintMenu.add(compItem1);
			 complaintMenu.add(compItem2);
			 accountMenu.add(accItem1);
			 accountMenu.add(accItem2);
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);

			 leftPanel.add(servicesLbl);
			 leftPanel.add(serviceBox);
			 leftPanel.add(selectServiceBtn);
			 menuBar.add(togBtn);
			 

			 menuBar.add(togBtn);

		 }
		 menuBar.add(loggedInUser);
		 menuBar.add(logoutBtn);
		 leftPanel.add(logoLbl);
		 leftPanel.add(title2);
		 leftPanel.add(sub_title1);
		 leftPanel.add(sub_title2);
		 leftPanel.add(sub_title3);
		 this.setJMenuBar(menuBar);

		
		
		 selectServiceBtn.addActionListener(this);

		 
		 this.registerListeners();
		 
	 }
	 
	 private void registerListeners() {
		 
		 this.usrItem1.addActionListener(this);
		 this.usrItem2.addActionListener(this);
		 this.compItem1.addActionListener(this);
		 this.compItem2.addActionListener(this);
		 this.compItem3.addActionListener(this);
		 this.accItem1.addActionListener(this);
		 this.accItem2.addActionListener(this);
		 this.accItem3.addActionListener(this);
		 this.logoutBtn.addActionListener(this);
		 this.togBtn.addItemListener(this);
		 this.selectServiceBtn.addActionListener(this);

	 }
	 
			
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == selectServiceBtn) {
			
			String service = serviceBox.getSelectedItem().toString();
			
			rightPanel.removeAll();
			rightPanel.add(new SelectedServiceView(service));
		}else if(e.getSource() == compItem1) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(compItem1.getText()));	
		}else if(e.getSource() == compItem2) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(compItem2.getText()));
		}else if(e.getSource() == compItem3) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(compItem3.getText()));
		}else if(e.getSource() == accItem1) {
			rightPanel.removeAll();
			rightPanel.repaint();
			rightPanel.add(new SelectedMenuOptionView(accItem1.getText()));	
		}else if(e.getSource() == accItem2) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(accItem2.getText()));
		}else if(e.getSource() == accItem3) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(accItem3.getText()));
		}else if(e.getSource() == usrItem1) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(usrItem1.getText()));
		}else if(e.getSource() == usrItem2) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(usrItem2.getText()));
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(togBtn.isSelected()){
			togBtn.setText("GO OFFLINE"); 
		}else {
			togBtn.setText("GO ONLINE");
		} 
	        	  
	 }  
		
}
		
