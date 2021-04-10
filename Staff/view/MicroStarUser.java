package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import AccountView.*;
import ComplaintsView.*;
import ResponseView.*;
import UserView.*;
import login.*;

public class MicroStarUser extends JFrame implements ActionListener{
	
	private JMenu menu1, menu2, menu3, menu4, clock;
	private JButton logoutBtn;
	private JMenuBar menuBar;
	private JMenuItem i1, i2, i3, i4, i5;
	private JMenuItem c1, c2, c3, c4;
	private JMenuItem r1, r2, r3, r4, r5, r6;
	private JMenuItem a1, a2, a3, a4, a5;
	private JDesktopPane desktopPane;
	//private JDesktopPane leftTopPane;
	//private JDesktopPane leftBottomPanel;
	//private JComboBox comboBox;
	private JFrame logOut;
	private JButton outstanding, resolve, comboBoxbtn, chatboxbtn;
	private JLabel header, resolved_value, oustanding_value, label,lbl_clock, 
					service_lblSub, service_lbl, title,title2,sub_title1,sub_title2,sub_title3;
	private JComboBox <String> comboBox;
	private JPanel leftTopPanel, leftBottomPanel;

 
	//internal JFrame to facilitate password pane and mainframe
	
	public MicroStarUser() { 
		
		menu1 = new JMenu("Users");
		menu1.setPreferredSize(new Dimension(200, menu1.getPreferredSize().height));
		//menu1.setVerticalAlignment(WIDTH);
		menu2 = new JMenu("Complaints");
		menu2.setPreferredSize(new Dimension(200, menu2.getPreferredSize().height));
		menu3 = new JMenu("Responses");
		menu3.setPreferredSize(new Dimension(200, menu3.getPreferredSize().height));
		menu4 = new JMenu("Query Account");
		menu4.setPreferredSize(new Dimension(200, menu4.getPreferredSize().height));
		clock = new JMenu();
		clock.setPreferredSize(new Dimension(200, menu1.getPreferredSize().height));
		logoutBtn = new JButton("LOGOUT");
		
		menuBar= new JMenuBar();
		
		//user drop down menu
		i1 = new JMenuItem("Create User");
		i1.setPreferredSize(new Dimension(200, menu1.getPreferredSize().height));
		i2 = new JMenuItem("View all Users");
		i3 = new JMenuItem("Find user ID");
		i4 = new JMenuItem("Update User");
		i5 = new JMenuItem("Delete User");
		
	    
	    //complaints drop down menu
	    c1 = new JMenuItem("Add complaint");
		c1.setPreferredSize(new Dimension(200, menu1.getPreferredSize().height));
		c2 = new JMenuItem("View all Complaints");
		c3 = new JMenuItem("Update Complaint");
		c4 = new JMenuItem("Delete Complaint");
		
	    
	  //ResponseView drop down menu
  		r1 = new JMenuItem("Add Response");
  		r1.setPreferredSize(new Dimension(150, r1.getPreferredSize().height));
  		r2 = new JMenuItem("Update Response");
  		r3 = new JMenuItem("All Responses");
  		r4 = new JMenuItem("Response per Complaint");
  		r5 = new JMenuItem("find Complaint by ID");
  		r6 = new JMenuItem("Delete Response");
  		
  	   //AccountView drop down menu
  		a1 = new JMenuItem("Payment Status");
  		a1.setPreferredSize(new Dimension(200, menu4.getPreferredSize().height));
  		a2 = new JMenuItem("Amount Due");
  		a3 = new JMenuItem("Payment Due date");
  		a4 = new JMenuItem("Account History");
  		
  		
  		desktopPane = new JDesktopPane(); 
  		leftTopPanel = new JPanel();
  		leftBottomPanel = new JPanel();
		
  	    showForm();
	  
	}
	
	public void createWindow() {
		 this.setTitle("MicroStar Frame");
		 this.setBounds(0,0,1500,800); //(40,45,1500,700) (0,0,1500,800)
		 this.getContentPane().setLayout(null);
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setResizable(false);
	}
	
	public void setLocationAndSize() { 
		this.desktopPane.setBounds(405,10,600,700); //(315,7,870,620) (405,10,600,700)
		this.desktopPane.setBackground(Color.white);
		
		//window for the logo
		leftTopPanel.setBounds(5, 10, 400, 400);
		leftTopPanel.setBackground(Color.black);	

        title = new JLabel("Micro-Star CableVision");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.white);
		title.setBounds(30,3,200,23);
		
        title2 = new JLabel("Company Limited");
        title2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title2.setForeground(Color.LIGHT_GRAY);
		title2.setBounds(30,8,200,23);
        
        sub_title1 = new JLabel("'Aspiration is built");
        sub_title1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        sub_title1.setForeground(Color.white);
        sub_title1.setBounds(30,120,300,23);
        sub_title1.setHorizontalAlignment(JLabel.CENTER);

        
        sub_title2 = new JLabel("through Hardwork");
        sub_title2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        sub_title2.setForeground(Color.white);
        sub_title2.setBounds(30,135,300,23);
        sub_title2.setHorizontalAlignment(JLabel.CENTER);
        
        sub_title3 = new JLabel("and Dedication'");
        sub_title3.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        sub_title3.setForeground(Color.white);
        sub_title3.setBounds(30,140,300,23);
        sub_title3.setHorizontalAlignment(JLabel.CENTER);

	
		
		title.setVisible(true);
		title2.setVisible(true);
		sub_title1.setVisible(true);
		sub_title2.setVisible(true);
		sub_title3.setVisible(true);
		
        leftTopPanel.add(title);
        leftTopPanel.add(title2);
        leftTopPanel.add(sub_title1);
        leftTopPanel.add(sub_title2);
        leftTopPanel.add(sub_title3);

        
        //leftTopPane.add(image);
        
		//Bottom pane 
		leftBottomPanel.setBounds(5, 410, 400, 400);
		leftBottomPanel.setBackground(Color.WHITE); 
		
	    //internet.setBounds(5, 12, 150, 20);
	    //cable.setBounds(150, 12,150,20);
	    
		
	    service_lbl = new JLabel("Services");
	    service_lblSub = new JLabel("Please specify the service you are requesting information on:");
        service_lbl.setFont(new Font("Impact", Font.PLAIN, 20));
        service_lbl.setHorizontalAlignment(JLabel.CENTER);
        service_lblSub.setBounds(30,40,400,30);

	    service_lbl.setBounds(35,10,300,20);
	    //service_lbl.setVisible(true);
	    leftBottomPanel.add(service_lbl);
	    leftBottomPanel.add(service_lblSub);
	    
	    //adding the ComboBox to the Bottom Pane
		serviceBox();
	    leftBottomPanel.add(comboBox);
	    leftBottomPanel.add(comboBoxbtn);
	    
	
		//actionListeners for the users
		this.i1.addActionListener(this);
		this.i2.addActionListener(this);
		this.i3.addActionListener(this);
		this.i4.addActionListener(this);
		this.i5.addActionListener(this);
		
		//actionListeners for the complaint
		this.c1.addActionListener(this);
		this.c2.addActionListener(this);
		this.c3.addActionListener(this);
		this.c4.addActionListener(this);
		
		//actionListerners for 
		this.r3.addActionListener(this);
		this.r4.addActionListener(this);
		this.r5.addActionListener(this);
		
		//actionListerners for accounts
		this.a1.addActionListener(this);
		this.a2.addActionListener(this);
		this.a3.addActionListener(this);
		this.a4.addActionListener(this);

		//actionListerners for logout button
		this.logoutBtn.addActionListener(this);
		this.comboBoxbtn.addActionListener(this);
		
		
	}
	
	public void addComponentsToFrame() {
		menu1.add(i1);
		menu1.add(i2);
		menu1.add(i3);
		menu1.add(i4);
		menu1.add(i5);
		//menuBar.add(menu1);
		
		// second menu bar for the complaint
		menu2.add(c1);
		menu2.add(c2); 
		menu2.add(c3);
		menu2.add(c4); 
		menuBar.add(menu2);
		  
		//menu for response
		menu3.add(r3);
		menu3.add(r4);
		menu3.add(r5);
		menuBar.add(menu3);
		 
		//menu for accounts
		menu4.add(a1);
		menu4.add(a2);
		menu4.add(a3);
		menu4.add(a4);
		menuBar.add(menu4);
		  
		menuBar.add(logoutBtn);
		//clock.add(clock); 
		menuBar.add(clock);

		this.setJMenuBar(menuBar);
		this.add(desktopPane);
		this.add(leftTopPanel);
		this.add(leftBottomPanel);
	}
	
	public void showForm() {
		//UserLogin();
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == logoutBtn) {
			dispose();
			logOut = new JFrame();
		    JOptionPane.showMessageDialog(logOut, "Logged out");
		    new UserLogin();
		}
		
		//complaint section
		
		  else if (e.getSource() ==  this.c1) { 
			 System.out.println("Add Complaint");
			 desktopPane.removeAll(); 
			 addComplaint fr1 = new addComplaint(); desktopPane.add(fr1).setVisible(true);
			 desktopPane.moveToFront(fr1); fr1.setSize(desktopPane.getWidth(),
			 desktopPane.getHeight()); fr1.setLocation(0,0);
				 
		  	}
		  else if (e.getSource() ==  this.c2) { 
			 System.out.println("View all Complaints");
			 desktopPane.removeAll(); 
			 viewAllComplaints fr2 = new viewAllComplaints();
			 desktopPane.add(fr2).setVisible(true); 
			 desktopPane.moveToFront(fr2);
			 fr2.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fr2.setLocation(0,0); 
			} 
		  else if (e.getSource() ==  this.c3) { 
			 System.out.println("Update Complaint");
			 desktopPane.removeAll(); 
			 updateComplaint fr3 = new updateComplaint();
			 desktopPane.add(fr3).setVisible(true); 
			 desktopPane.moveToFront(fr3);
			 fr3.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fr3.setLocation(0,0); 
			} 
		  else if (e.getSource() ==  this.c4) { 
			 System.out.println("Delete Complaint");
			 desktopPane.removeAll(); 
			 deleteComplaint fr4 = new deleteComplaint();
			 desktopPane.add(fr4).setVisible(true); 
			 desktopPane.moveToFront(fr4);
			 fr4.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fr4.setLocation(0,0); 
			} 
//ResponseView section
		
		  else if (e.getSource() ==  this.r3) { 
			 System.out.println("View all Complaints");
			 desktopPane.removeAll(); 
			 viewAllResponse fra3 = new viewAllResponse();
			 desktopPane.add(fra3).setVisible(true); 
			 desktopPane.moveToFront(fra3);
			 fra3.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fra3.setLocation(0,0); 
			} 
		  else if (e.getSource() ==  this.r4) { 
			 System.out.println("View per Complaint");
			 desktopPane.removeAll(); 
			 viewPerResponse fra4 = new viewPerResponse();
			 desktopPane.add(fra4).setVisible(true); 
			 desktopPane.moveToFront(fra4);
			 fra4.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fra4.setLocation(0,0); 
			} 
		  else if (e.getSource() ==  this.r5) { 
			 System.out.println("Find complaint by ID");
			 desktopPane.removeAll(); 
			 findResponse fra5 = new  findResponse();
			 desktopPane.add(fra5).setVisible(true); 
			 desktopPane.moveToFront(fra5);
			 fra5.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fra5.setLocation(0,0); 
			} 
	
		//AccountView
		  else if (e.getSource() == a1) {
				System.out.println("Payment Status");
				desktopPane.removeAll();
				CreateAccount AccFrame1 = new CreateAccount();
				desktopPane.add(AccFrame1).setVisible(true);
				desktopPane.moveToFront(AccFrame1);
				AccFrame1.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame1.setLocation(0,0);
			}
			else if (e.getSource() == a2) {
				System.out.println("Amount Due");
				desktopPane.removeAll();
				allAccount AccFrame2 = new allAccount();
				desktopPane.add(AccFrame2).setVisible(true);
				desktopPane.moveToFront(AccFrame2);
				AccFrame2.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame2.setLocation(0,0);
			}
			else if (e.getSource() == a3) {
				System.out.println("Payment Due Date");
				desktopPane.removeAll();
				findAccByID AccFrame3 = new findAccByID();
				desktopPane.add(AccFrame3).setVisible(true);
				desktopPane.moveToFront(AccFrame3);
				AccFrame3.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame3.setLocation(0,0);
			}
			else if (e.getSource() == a4) {
				System.out.println("Account History");
				desktopPane.removeAll();
				updateAccount AccFrame4 = new updateAccount();
				desktopPane.add(AccFrame4).setVisible(true);
				desktopPane.moveToFront(AccFrame4);
				AccFrame4.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame4.setLocation(0,0);
			}

			else if (e.getSource() == comboBoxbtn) {
				System.out.println("Services Status");
				desktopPane.removeAll();
				serviceForm(comboBox.getSelectedItem().toString());
				/*
				desktopPane.add(ServicesChoice).setVisible(true);
				desktopPane.moveToFront(ServicesChoice);
				ServicesChoice.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				ServicesChoice.setLocation(0,0);*/
			}
			else if (e.getSource() == comboBox) {
				System.out.println("Services Status");
				desktopPane.removeAll();
				
				
			}
		
			 
	}
	
	public void clockFeature(){
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						GregorianCalendar date = new GregorianCalendar();
			    		
			            Calendar now = Calendar.getInstance();
			            int h = now.get(Calendar.HOUR_OF_DAY);
			            int m = now.get(Calendar.MINUTE);
			            int s = now.get(Calendar.SECOND);
			            //date
			            int day = date.get(Calendar.DAY_OF_MONTH);
			            int month = date.get(Calendar.MONTH);
			            int year = date.get(Calendar.YEAR);
			           
			            //clockField.setText("("+day+"/"+(month+1)+"/"+year+")"+ " Time:" + h + ":" + m + ":" + s);
			            
						sleep(1000);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//end of run
		};//end of thread
		clock.start();
    }

	public void serviceForm(String service) {
			int outstandingCount = 0;
			int resolvedCount = 0;
			
			//serviceFrame = new JFrame("Service Status"); 
			header = new JLabel(service);
			header.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			header.setHorizontalAlignment(JLabel.CENTER);
			header.setBounds(210, 30, 200, 40);

			
			this.resolved_value = new JLabel("Unresolved Complaints: " + outstandingCount);
			this.resolved_value.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			this.resolved_value.setBounds(320,130, 200, 20);

			this.oustanding_value = new JLabel("Resolved Complaints: " + resolvedCount);
			this.oustanding_value.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			this.oustanding_value.setBounds(130,130, 200, 20);

		    resolve =new JButton("Resolved");  
		    outstanding = new JButton("Outstanding");
		    outstanding.setBounds(120,100,150,30);
		    resolve.setBounds(310,100,150,30);  
		    
		    ActionListener actionListioner = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						
						if(e.getSource()==resolve) {
							System.out.println("RESOLVE TABLE.");
						}else if(e.getSource()==outstanding) {
							System.out.println("OUSTANDING TABLE.");
						}
					}
		    };
	        
	        resolve.addActionListener(actionListioner);
	        outstanding.addActionListener(actionListioner);
	        
		    desktopPane.removeAll();
		    desktopPane.add(header).setVisible(true);
		    desktopPane.add(outstanding).setVisible(true);  
		    desktopPane.add(resolve).setVisible(true);
		    desktopPane.add(resolved_value).setVisible(true);
		    desktopPane.add(oustanding_value).setVisible(true);
		    desktopPane.moveToFront(header);
		    desktopPane.moveToFront(outstanding);  
		    desktopPane.moveToFront(resolve);
		    desktopPane.moveToFront(resolved_value);
		    desktopPane.moveToFront(oustanding_value);
		    desktopPane.setBounds(405,10,600,700);

		    desktopPane.setLayout(null);  
		    //desktopPane.setVisible(true);

		   // serviceFrame.setVisible(true);  

		}  
	
	public void serviceBox() {
	    	
	        String services[] = {"Cable","Broadband"};
	        
	        comboBox = new JComboBox<>(services);
	        comboBox.setSelectedIndex(0);
	        comboBox.setBounds(20, 80, 300, 40);
	        leftBottomPanel.add(comboBox);
	        //leftBottomPanel.setLayout(null);
	        
	        comboBoxbtn = new JButton("Submit Service");
	        comboBoxbtn. setBounds(70,160,200,50);
	        leftBottomPanel.add(comboBoxbtn);
	        comboBoxbtn.setVisible(true);
	        //leftBottomPanel.setLayout(null);	
	        
	        chatboxbtn = new JButton("ChatBox");
	        chatboxbtn.setBounds(8,250,100,30);
	        leftBottomPanel.add(chatboxbtn);
	        chatboxbtn.setVisible(true);
	        
	        leftBottomPanel.setLayout(null);
	        
	        
	        ActionListener actionListioner = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==comboBoxbtn) {
						String choice = comboBox.getSelectedItem().toString();
						System.out.println(choice);
						switch (choice) {//check for a match
						    case "Cable":
						    	System.out.println("You're choice is Cable");
						    		serviceForm("Cable");
						        break;
						    case "BroadBand":    
						        System.out.println("You're choice is BroadBand");
						        	serviceForm("BroadBand");
						        break;
						    default:
						    	//removeAll();
						        break;
						}
					}else if(e.getSource()==resolve) {
						System.out.println("RESOLVE TABLE.");
					}else if(e.getSource()==outstanding) {
						System.out.println("OUSTANDING TABLE.");
					}else if(e.getSource()== chatboxbtn) {
						System.out.println("let's chat");
					}
				}
	        	
	        };
	       
	        comboBoxbtn.addActionListener(actionListioner);
	        chatboxbtn.addActionListener(actionListioner);
	        
	    }

   /* private void logo() {

        ImageIcon loadImage = new ImageIcon("src/logo/MicroLogo.png");
        
        JLabel image = new JLabel(loadImage);

        image.setBounds(0,70,350,200);
        image.setVisible(true);
        leftTopPanel.add(image);
        
    }*/

		public static void main(String[] args) {
			new MicroStarUser();

		}
		

}//end of mainframe
