package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import models.User;
import utils.Role;

public class MainView extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JMenu userMenu, complaintMenu, responseMenu, accountMenu;
	private JLabel servicesLbl;
	private JLabel logoLbl;
	private JMenuBar menuBar;
	private JComboBox<String> serviceBox;
	private String[] services;
	private JButton selectServiceBtn;
	private JButton logoutBtn;
	private JLabel loggedInUser;
	private Role role;
	private User user;
	private JMenuItem usrItem1, usrItem3, usrItem2,
	                  usrItem4, usrItem5, compItem1,compItem2,compItem3, accItem1,accItem2;
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
		logoLbl  = new JLabel("Micro Star Cable Company");
		servicesLbl= new JLabel("Services");
		services = new String[] {"Cable","Broadband"};
		serviceBox = new JComboBox<>(services);
		selectServiceBtn = new JButton("Select");
		loggedInUser = new JLabel("HI "+user.getFirstName().toUpperCase());
		logoutBtn = new JButton("LOGOUT");
		this.role = role;
		this.user = user;
		usrItem1 = new JMenuItem("");
		usrItem2 = new JMenuItem("");
		compItem1 = new JMenuItem("");
		compItem2 = new JMenuItem("");
		compItem3 = new JMenuItem();
		accItem1 = new JMenuItem("");
		accItem2 = new JMenuItem("");
		this.availalbility = "Go Online";
		togBtn = new JToggleButton(this.availalbility);
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
        this.setSize(1400,800);
    }
	
	 private void setLocationAndSize() {
		 leftPanel.setBackground(Color.red);
		 leftPanel.setLayout(null);
		 leftPanel.setPreferredSize(new Dimension(300,100));
		 
		 rightPanel.setLayout(new BorderLayout());
		 logoLbl.setBounds(0, 10,300, 20);
		 servicesLbl.setBounds(0,100,150, 30);
		 serviceBox.setBounds(0,130,200,30);
		 selectServiceBtn.setBounds(0,160,100,30);
		 rightPanel.setBackground(Color.green);
		 
	 }

	 private void addComponentsToFrame() {
		 
		 this.add(rightPanel,BorderLayout.CENTER);
		 this.add(leftPanel,BorderLayout.WEST);
		 
		 compItem1.setText("Submit a Complaint");
		// compItem2.setText("View All Complaints");
		 compItem3.setText("Assign Technician");
		 accItem1.setText("Account Status");
		 accItem2.setText("Past Payments");
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
			 menuBar.add(userMenu);
			 menuBar.add(responseMenu);
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);
			 leftPanel.add(servicesLbl);
			 leftPanel.add(serviceBox);
			 leftPanel.add(selectServiceBtn);
			 
		 }else if(this.role.equals(Role.TECHNICIAN)) {
			 
			 complaintMenu.add(compItem1);
			// complaintMenu.add(compItem3);
			 accountMenu.add(accItem1);
			 accountMenu.add(accItem2);
			 menuBar.add(userMenu);
			 menuBar.add(responseMenu);
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);
			 leftPanel.add(servicesLbl);
			 leftPanel.add(serviceBox);
			 leftPanel.add(selectServiceBtn);
			 menuBar.add(togBtn);
			 
		 }
		 menuBar.add(loggedInUser);
		 menuBar.add(logoutBtn);
		 leftPanel.add(logoLbl);
		 
		 this.setJMenuBar(menuBar);
		 
		
		 selectServiceBtn.addActionListener(this);
	 }
	 
			
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == selectServiceBtn) {
			
			String service = serviceBox.getSelectedItem().toString();
			
			rightPanel.removeAll();
			rightPanel.add(new SelectedServiceView(service)) ;
		}
		
	}
	
	
	
}