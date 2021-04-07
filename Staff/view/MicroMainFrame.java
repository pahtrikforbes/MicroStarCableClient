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

public class MicroMainFrame extends JFrame implements ActionListener{
	
	private JMenu menu1, menu2, menu3, menu4, clock;
	private JButton logoutBtn;
	private JMenuBar menuBar;
	private JMenuItem i1, i2, i3, i4, i5;
	private JMenuItem c1, c2, c3, c4;
	private JMenuItem r1, r2, r3, r4, r5, r6;
	private JMenuItem a1, a2, a3, a4, a5;
	private JDesktopPane desktopPane;
	private JDesktopPane leftTopPane;
	private JDesktopPane leftBottomPane;
	//private JComboBox comboBox;
	private JFrame frame, serviceFrame;
	private JButton outstanding, resolve, comboBoxbtn;
	private JLabel header, resolved_value, oustanding_value, label,lbl_clock;
	private JComboBox <String> comboBox;
	private ImageIcon ii;

 
	//internal JFrame to facilitate password pane and mainframe
	
	public MicroMainFrame() { 
		
		menu1 = new JMenu("Users");
		menu1.setPreferredSize(new Dimension(200, menu1.getPreferredSize().height));
		//menu1.setVerticalAlignment(WIDTH);
		menu2 = new JMenu("Complaints");
		menu2.setPreferredSize(new Dimension(200, menu2.getPreferredSize().height));
		menu3 = new JMenu("Responses");
		menu3.setPreferredSize(new Dimension(200, menu3.getPreferredSize().height));
		menu4 = new JMenu("Accounts");
		menu4.setPreferredSize(new Dimension(200, menu4.getPreferredSize().height));
		clock = new JMenu();
		clock.setPreferredSize(new Dimension(370, menu1.getPreferredSize().height));
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
  		a1 = new JMenuItem("Add Acoount");
  		a1.setPreferredSize(new Dimension(200, menu4.getPreferredSize().height));
  		a2 = new JMenuItem("All Accounts");
  		a3 = new JMenuItem("Find Account");
  		a4 = new JMenuItem("Update Account");
  		a5 = new JMenuItem("Delete Account");
  		
  		desktopPane = new JDesktopPane(); 
  		leftTopPane = new JDesktopPane();
  		leftBottomPane = new JDesktopPane();
		
  	    showForm();
	    
	}
	
	public void createWindow() {
		 this.setTitle("MicroStar Frame");
		 this.setBounds(0,0,1500,800);
		 this.getContentPane().setLayout(null);
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setResizable(false);
	}
	
	public void setLocationAndSize() { 
		this.desktopPane.setBounds(360,10,900,700);
		this.desktopPane.setBackground(Color.white);
		
		//window for the logo
		leftTopPane.setBounds(5, 10, 400, 400);
		leftTopPane.setBackground(Color.gray);	
		//leftTopPane = new microStarViews();
		
		ii = logo();
        JLabel label = new JLabel(ii);
        leftTopPane.add(label);
        
		//Bottom pane 
		leftBottomPane.setBounds(5, 410, 400, 400);
		leftBottomPane.setBackground(Color.WHITE); 
		
	    //internet.setBounds(5, 12, 150, 20);
	    //cable.setBounds(150, 12,150,20);
	    
		
	    JLabel service_lbl = new JLabel("Services");
	    JLabel service_lblSub = new JLabel("Please specify the service you are requesting information on:");
        service_lbl.setFont(new Font("Impact", Font.PLAIN, 20));
        service_lbl.setHorizontalAlignment(JLabel.CENTER);
        service_lblSub.setBounds(5,40,400,30);

	    service_lbl.setBounds(10,10,300,20);
	    //service_lbl.setVisible(true);
	    leftBottomPane.add(service_lbl);
	    leftBottomPane.add(service_lblSub);
	    
		serviceBox();
	    leftBottomPane.add(comboBox);
	    leftBottomPane.add(comboBoxbtn);
	    
	    
	    
		 //servicesComboBox services = new servicesComboBox();
		 //leftBottomPane.add(services).setVisible(true);
		 //leftBottomPane.moveToFront(services);
		 //services.setSize(leftBottomPane.getWidth(), leftBottomPane.getHeight());
		 //services.setLocation(0,0);
		 
	   
	
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
		this.r1.addActionListener(this);
		this.r2.addActionListener(this);
		this.r3.addActionListener(this);
		this.r4.addActionListener(this);
		this.r5.addActionListener(this);
		this.r6.addActionListener(this);
		
		//actionListerners for accounts
		this.a1.addActionListener(this);
		this.a2.addActionListener(this);
		this.a3.addActionListener(this);
		this.a4.addActionListener(this);
		this.a5.addActionListener(this);

		//actionListerners for logout button
		this.logoutBtn.addActionListener(this);
	}
	
	public void addComponentsToFrame() {
		menu1.add(i1);
		menu1.add(i2);
		menu1.add(i3);
		menu1.add(i4);
		menu1.add(i5);
		menuBar.add(menu1);
		
		// second menu bar for the complaint
		menu2.add(c1);
		menu2.add(c2); 
		menu2.add(c3);
		menu2.add(c4); 
		menuBar.add(menu2);
		  
		//menu for response
		menu3.add(r1);
		menu3.add(r2);
		menu3.add(r3);
		menu3.add(r4);
		menu3.add(r5);
		menu3.add(r6);
		menuBar.add(menu3);
		 
		//menu for accounts
		menu4.add(a1);
		menu4.add(a2);
		menu4.add(a3);
		menu4.add(a4);
		menu4.add(a5);
		menuBar.add(menu4);
		  
		//clock.add(clock); 
		menuBar.add(clock);
		  
		menuBar.add(logoutBtn);
		 
		
		this.setJMenuBar(menuBar);
		this.add(desktopPane);
		this.add(leftTopPane);
		this.add(leftBottomPane);
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
			System.out.println("go to the login screen");
		}
		else if (e.getSource() == i1) {
			
			  System.out.println("Create UserView"); desktopPane.removeAll(); CreateUser f1
			  = new CreateUser(); desktopPane.add(f1).setVisible(true);
			  desktopPane.moveToFront(f1); f1.setSize(desktopPane.getWidth(),
			  desktopPane.getHeight()); f1.setLocation(0,0);
			 
		}
		else if (e.getSource() == i2) {
			System.out.println("View all user");
			desktopPane.removeAll();
			viewAllUsers f2 = new viewAllUsers();
			desktopPane.add(f2).setVisible(true);
			desktopPane.moveToFront(f2);
			f2.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			f2.setLocation(0,0);
		}
		else if (e.getSource() == i3) {
			System.out.println("Find user");
			desktopPane.removeAll();
			findByID f3 = new findByID();
			desktopPane.add(f3).setVisible(true);
			desktopPane.moveToFront(f3);
			f3.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			f3.setLocation(0,0);
		}
		else if (e.getSource() == i4) {
			System.out.println("Update UserView");
			desktopPane.removeAll();
			UpdateUser f4 = new UpdateUser();
			desktopPane.add(f4).setVisible(true);
			desktopPane.moveToFront(f4);
			f4.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			f4.setLocation(0,0);
		}
		
		else if (e.getSource() == i5) {
			System.out.println("Delete UserView");
			desktopPane.removeAll();
			deleteUser f5 = new deleteUser();
			desktopPane.add(f5).setVisible(true);
			desktopPane.moveToFront(f5);
			f5.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			f5.setLocation(0,0);
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
		
		  else if (e.getSource() ==  this.r1) { 
			 System.out.println("Add ResponseView");
			 desktopPane.removeAll(); 
			 addResponse fra1 = new addResponse();
			 desktopPane.add(fra1).setVisible(true); 
			 desktopPane.moveToFront(fra1);
			 fra1.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fra1.setLocation(0,0); 
		  	}
		  else if (e.getSource() ==  this.r2) { 
			 System.out.println("View all Complaints");
			 desktopPane.removeAll(); 
			 updateResponse fra2 = new updateResponse();
			 desktopPane.add(fra2).setVisible(true); 
			 desktopPane.moveToFront(fra2);
			 fra2.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fra2.setLocation(0,0); 
			} 
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
		  else if (e.getSource() ==  this.r6) { 
			 System.out.println("Find complaint by ID");
			 desktopPane.removeAll(); 
			 deleteResponse fra6 = new  deleteResponse();
			 desktopPane.add(fra6).setVisible(true); 
			 desktopPane.moveToFront(fra6);
			 fra6.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			 fra6.setLocation(0,0); 
			} 
		
		//AccountView
		  else if (e.getSource() == a1) {
				System.out.println("Create Account");
				desktopPane.removeAll();
				CreateAccount AccFrame1 = new CreateAccount();
				desktopPane.add(AccFrame1).setVisible(true);
				desktopPane.moveToFront(AccFrame1);
				AccFrame1.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame1.setLocation(0,0);
			}
			else if (e.getSource() == a2) {
				System.out.println("View all Accounts");
				desktopPane.removeAll();
				allAccount AccFrame2 = new allAccount();
				desktopPane.add(AccFrame2).setVisible(true);
				desktopPane.moveToFront(AccFrame2);
				AccFrame2.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame2.setLocation(0,0);
			}
			else if (e.getSource() == a3) {
				System.out.println("Find Account");
				desktopPane.removeAll();
				findAccByID AccFrame3 = new findAccByID();
				desktopPane.add(AccFrame3).setVisible(true);
				desktopPane.moveToFront(AccFrame3);
				AccFrame3.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame3.setLocation(0,0);
			}
			else if (e.getSource() == a4) {
				System.out.println("Update Account");
				desktopPane.removeAll();
				updateAccount AccFrame4 = new updateAccount();
				desktopPane.add(AccFrame4).setVisible(true);
				desktopPane.moveToFront(AccFrame4);
				AccFrame4.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame4.setLocation(0,0);
			}
			
			else if (e.getSource() == a5) {
				System.out.println("Delete Account");
				desktopPane.removeAll();
				deleteAccount AccFrame5 = new deleteAccount();
				desktopPane.add(AccFrame5).setVisible(true);
				desktopPane.moveToFront(AccFrame5);
				AccFrame5.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				AccFrame5.setLocation(0,0);
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

	public void serviceForm() {

			//serviceFrame = new JFrame("Service Status"); 
			header = new JLabel("Status of Services");
			header.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			header.setHorizontalAlignment(JLabel.CENTER);
			header.setBounds(150, 30, 200, 40);

			

			this.resolved_value = new JLabel("Unresolved Complaints: ");
			this.resolved_value.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			this.resolved_value.setBounds(260,130, 200, 20);

			

			this.oustanding_value = new JLabel("Resolved Complaints: ");
			this.oustanding_value.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			this.oustanding_value.setBounds(70,130, 200, 20);

		    resolve =new JButton("Resolved");  
		    outstanding = new JButton("Outstanding");
		    outstanding.setBounds(60,100,150,30);  

		    resolve.setBounds(250,100,150,30);  

		    desktopPane.add(header);
		    desktopPane.add(outstanding);  
		    desktopPane.add(resolve);
		    desktopPane.add(resolved_value);
		    desktopPane.add(oustanding_value);

		    desktopPane.setBounds(0,0,490,580);

		    desktopPane.setLayout(null);  

		   // serviceFrame.setVisible(true);  

		}  
	
	public void serviceBox() {
	    	
		 String defaultselect = "Service type...";
	        String services[] = {defaultselect,"Cable","Broadband"};
	        //String cable[] = {"fibre", "Cooper"};
	        comboBox = new JComboBox<>(services);
	        comboBox.setSelectedIndex(0);
	        comboBox.setBounds(20, 80, 300, 40);
	        this.add(comboBox);
	        this.setLayout(null);
	        
	        comboBoxbtn = new JButton("Submit Service");
	        comboBoxbtn. setBounds(70,180,200,50);
	        this.add(comboBoxbtn);
	        comboBoxbtn.setVisible(true);
	        this.setLayout(null);

	        
	        ActionListener actionListioner = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					String choice = null;
					switch (choice) {//check for a match
					    case "Cable":
					    	
					        System.out.println("You're choice is cable");
					        break;
					    case "BroadBand":    
					        System.out.println("You're choice is broadnad");
					        break;
					    default:
					        break;
					}
					
				}
	        	
	        };
	    }

	
    private ImageIcon logo (JComponent... arg) {

        ImageIcon loadImage = new ImageIcon("src/logo/microImage.png");
        
        Container pane = getRootPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setHorizontalGroup(gl.createSequentialGroup()

                .addComponent(arg[0])

        );
        gl.setVerticalGroup(gl.createParallelGroup()

                .addComponent(arg[0])

        );
        
        return loadImage;
    }

    private void createLayout() {

       

    }




		public static void main(String[] args) {
			new MicroMainFrame();

		}
		
	
	
	
	
	
}//end of mainframe
