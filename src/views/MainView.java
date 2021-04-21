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

import UserView.viewAllUsers;
import complaintsViews.ComplaintView;
import complaintsViews.CustomerComplaintView;
import complaintsViews.RepresentativeComplaintsView;
import complaintsViews.TechnicianComplaintView;
import loginregisterprompt.LoginRegisterPrompt;
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
	private JButton liveChatBtn;
	private JLabel loggedInUser;
	private Role role;
	private User user;
	private JMenuItem usrItem1, usrItem2, compItem1,compItem2,compItem3,
						compItem4, accItem1,accItem2,accItem3;
	JToggleButton togBtn;
	private JFrame logFrame;
	private String availalbility;
	
    public MainView(Role role,User user, JFrame frame) {
    	super();
    	rightPanel = new JPanel();
    	logFrame = frame;
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
		liveChatBtn = new JButton("Live Chat");
		this.role = role;
		this.user = user;
		usrItem1 = new JMenuItem("View Users");
		compItem1 = new JMenuItem("Add Complaint");
		compItem2 = new JMenuItem("Complaints Action View");
		compItem3 = new JMenuItem("Complaints Action View");
		compItem4 = new JMenuItem("Complaints Action View");
		accItem1 = new JMenuItem("Account Status");
		accItem2 = new JMenuItem("Past Payments");
		accItem3 = new JMenuItem("Update Account");
		this.availalbility = "Go Online";
		togBtn = new JToggleButton(this.availalbility);
		this.setVisible(true);
		
		Color c1 = new Color(51,255,0);
		togBtn.setBackground(c1);
		
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
		 Color c1 = new Color(0,115,153);
		 Color c2 = new Color(0,179,179);
		 
		 leftPanel.setBackground(c1);
		 leftPanel.setLayout(null);
		 leftPanel.setPreferredSize(new Dimension(300,100));
		 
		 rightPanel.setLayout(new BorderLayout());
		 logoLbl.setBounds(16, 17,300, 40);
		 logoLbl.setFont(new Font("Times New Roman", Font.BOLD, 26));
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
		 liveChatBtn.setBounds(97,250,100,30);
		 
		 rightPanel.setBackground(Color.LIGHT_GRAY);
		 
		 
	 }

	 private void addComponentsToFrame() {
		 
		 this.add(rightPanel,BorderLayout.CENTER);
		 this.add(leftPanel,BorderLayout.WEST);
		
		 if(this.role.equals(Role.CUSTOMER)) {
			 this.setTitle("Micro-Star Customer");
			 
			 complaintMenu.setPreferredSize(new Dimension(300, userMenu.getPreferredSize().height));
			 responseMenu.setPreferredSize(new Dimension(300, userMenu.getPreferredSize().height));
			 accountMenu.setPreferredSize(new Dimension(300, userMenu.getPreferredSize().height));
			 loggedInUser.setPreferredSize(new Dimension(300, userMenu.getPreferredSize().height));
			 logoutBtn.setPreferredSize(new Dimension(300, userMenu.getPreferredSize().height));

			 
			 complaintMenu.add(compItem1);
			 complaintMenu.add(compItem3);
			 
			 accountMenu.add(accItem1);
			 accountMenu.add(accItem2);
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);
			 
			 leftPanel.add(liveChatBtn);
			 liveChatBtn.addActionListener(this);
			 
			 
			 
		 }else if(this.role.equals(Role.REPRESENTATIVE)) {
			 
			 // Custom set sizes for the menuBar items 
			 this.setTitle("Micro-Star Representaive");
			 
			 userMenu.setPreferredSize(new Dimension(220, userMenu.getPreferredSize().height));
			 complaintMenu.setPreferredSize(new Dimension(220, userMenu.getPreferredSize().height));
			 responseMenu.setPreferredSize(new Dimension(220, userMenu.getPreferredSize().height));
			 accountMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 loggedInUser.setPreferredSize(new Dimension(220, userMenu.getPreferredSize().height));
			 logoutBtn.setPreferredSize(new Dimension(220, userMenu.getPreferredSize().height));
			 togBtn.setPreferredSize(new Dimension(220, userMenu.getPreferredSize().height));

			 
			 complaintMenu.add(compItem1);
			 complaintMenu.add(compItem2);
			 
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
			 this.setTitle("Micro-Star Technician");
			 
			 userMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 complaintMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 responseMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 accountMenu.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 loggedInUser.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 logoutBtn.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));
			 togBtn.setPreferredSize(new Dimension(250, userMenu.getPreferredSize().height));



			 complaintMenu.add(compItem4);
			 
			 accountMenu.add(accItem1);
			 accountMenu.add(accItem2);
			 
			 menuBar.add(complaintMenu);
			 menuBar.add(accountMenu);

			 userMenu.add(usrItem1);
			 
			 leftPanel.add(servicesLbl);
			 leftPanel.add(serviceBox);
			 leftPanel.add(selectServiceBtn);
			 menuBar.add(togBtn);
			 
			 menuBar.add(userMenu);
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
		 this.compItem1.addActionListener(this);
		 this.compItem2.addActionListener(this);
		 this.compItem3.addActionListener(this);
		 this.compItem4.addActionListener(this);
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
			
		} else if (e.getSource() == liveChatBtn) {
			System.out.println("Live Chat Button clicked!");
			try {
				ChatView cv = new ChatView();
				rightPanel.removeAll();
				rightPanel.add(cv);
				cv.setVisible(true);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource() == compItem1) {
			rightPanel.removeAll();
			
			if (user.getRole().equals(Role.REPRESENTATIVE)) {
				ComplaintView cv = new ComplaintView();
				rightPanel.add(cv).setVisible(true);
				cv.setSize(rightPanel.getWidth(), rightPanel.getHeight());
				cv.setLocation(0,0);
				int custId = 0;
				int choice = 1;			
				cv.userMap(choice, custId);
				
			} else if (user.getRole().equals(Role.CUSTOMER)) {
				ComplaintView cv = new ComplaintView();
				rightPanel.add(cv).setVisible(true);
				cv.setSize(rightPanel.getWidth(), rightPanel.getHeight());
				cv.setLocation(0,0);
				int custId = user.getUserId();
				int choice = 2;			
				cv.userMap(choice, custId);
				
			}
			

			
		}else if(e.getSource() == compItem2) {
			rightPanel.removeAll();
			RepresentativeComplaintsView rcv = new RepresentativeComplaintsView();
			rightPanel.add(rcv).setVisible(true);
			rcv.setSize(rightPanel.getWidth(), rightPanel.getHeight());
			rcv.setLocation(0,0);

			
		}else if(e.getSource() == compItem3) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(compItem3.getText()));
			CustomerComplaintView ccv = new CustomerComplaintView();
			rightPanel.add(ccv).setVisible(true);
			ccv.setSize(rightPanel.getWidth(), rightPanel.getHeight());
			ccv.setLocation(0,0);
			int custId = user.getUserId();
			ccv.setCustomerId(custId);
			
		}
		
		else if(e.getSource() == compItem4) {
			rightPanel.removeAll();
			rightPanel.add(new SelectedMenuOptionView(compItem3.getText()));
			TechnicianComplaintView tcv = new TechnicianComplaintView();		
			rightPanel.add(tcv).setVisible(true);
			tcv.setSize(rightPanel.getWidth(), rightPanel.getHeight());
			tcv.setLocation(0,0);
			
		}
		
		else if(e.getSource() == accItem1) {
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
			//rightPanel.add(new SelectedMenuOptionView(usrItem1.getText()));
			viewAllUsers userAll = new viewAllUsers();
			rightPanel.add(userAll).setVisible(true);
			userAll.setSize(rightPanel.getWidth(), rightPanel.getHeight());
			userAll.setLocation(0,0);
		}else if (e.getSource()==logoutBtn) {
			logFrame.dispose();
			System.out.println("Logged out");
			new LoginRegisterPrompt();
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(togBtn.isSelected()){
			togBtn.repaint();
			Color c2 = new Color(255,51,0);
			togBtn.setText("GO OFFLINE"); 
			togBtn.setBackground(c2);	
			
		}else {
			Color c1 = new Color(51,255,0);
			togBtn.setText("GO ONLINE");
			togBtn.setBackground(c1);
			
		} 
	        	  
	 }  
		
}
		
