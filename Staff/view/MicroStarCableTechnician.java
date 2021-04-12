package view;


	import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
	import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
import javax.swing.JPanel;

import complaintsViews.ComplaintView;
	import complaintsViews.RepresentativeComplaintsView;
import complaintsViews.TechnicianComplaintView;
import controllers.ComplaintController;
	import models.Complaint;
import models.User;
import utils.CustomizedException;

	public class MicroStarCableTechnician extends JFrame implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private User user;
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		private JMenu menu, menu2, menu3, menu4;
		private JButton logoutBtn;
		private JMenuBar menuBar;
		private JMenuItem i1,i3;
		static private JDesktopPane desktopPane;
		private JButton outstanding, resolve, comboBoxbtn, chatboxbtn;
		private JLabel header, resolved_value, oustanding_value, label,clock_lbl, 
						service_lblSub, service_lbl, title,title2,sub_title1,sub_title2,sub_title3;
		private JComboBox <String> comboBox;
		private JPanel leftTopPanel, leftBottomPanel;
		private JButton serviceBtn;
		
		public MicroStarCableTechnician() {
			menu  = new JMenu("Users");
			menu2 = new JMenu("Complaints");
			menu3 = new JMenu("Responses");
			menu4 = new JMenu("Accounts");
			menuBar= new JMenuBar();
			logoutBtn = new JButton("LOGOUT");
			i1 = new JMenuItem("Submit a Complaint");
			i3 = new JMenuItem("Complaint Action View");
			desktopPane = new JDesktopPane();
			leftTopPanel = new JPanel();
	  		leftBottomPanel = new JPanel();
	  		serviceBtn = new JButton("Services");
			
		    showForm();
		}
		
	
		
		public void createWindow() {
			 this.setTitle("MicroStar Frame - Staff");
			 this.setBounds(0,0,1280,750);
			 this.getContentPane().setLayout(null);
		     this.setVisible(true);
		     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     this.setResizable(false);
		}
		
		public void setLocationAndSize() {
			desktopPane.setBounds(409,7,860,676);
			desktopPane.setBackground(Color.white);
			
			
			//window for the logo
			leftTopPanel.setBounds(5, 25, 400, 300);
			leftTopPanel.setBackground(Color.black);	
			
			//Bottom pane 
			leftBottomPanel.setBounds(5, 360, 400, 300);
			leftBottomPanel.setBackground(Color.WHITE); 
			
			service_lbl = new JLabel("Services");
		    service_lblSub = new JLabel("Please specify the service you are requesting information on:");
	        service_lbl.setFont(new Font("Impact", Font.PLAIN, 20));
	        service_lbl.setHorizontalAlignment(JLabel.CENTER);
	        service_lblSub.setBounds(30,40,400,30);
	        
		    service_lbl.setBounds(35,10,300,20);
		    //service_lbl.setVisible(true);
		    leftBottomPanel.add(service_lbl);
		    leftBottomPanel.add(service_lblSub);
		    
		    
		    serviceBtn.setBounds(120,110,120,40);
		    serviceBtn.addActionListener(this);
		    
			
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
	        
	        leftBottomPanel.add(serviceBtn);
	        
			this.i1.addActionListener(this);
			this.i3.addActionListener(this);
			this.logoutBtn.addActionListener(this);
			
			//adding the ComboBox to the Bottom Pane
//			
			
		}
		
		public void addComponentsToFrame() {
			
			menu2.add(i1);
			menu2.add(i3);

			menuBar.add(menu);
			menuBar.add(menu2);	
			menuBar.add(menu3);
			menuBar.add(menu4);
			
			menuBar.add(logoutBtn);
			
			this.setJMenuBar(menuBar);
			this.add(desktopPane);
			
			this.setJMenuBar(menuBar);
			this.add(desktopPane);
			this.add(leftTopPanel);
			this.add(leftBottomPanel);
		}
		
		public void showForm() {
			createWindow();
			setLocationAndSize();
			addComponentsToFrame();
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
		    	
				JFrame servicePopup = new JFrame();
				
				servicePopup.setLocationRelativeTo(null);
				servicePopup.setVisible(true);
				servicePopup.setSize(400,400);
				servicePopup.setTitle("Services");
				
		        String services[] = {"Cable","Broadband"};
		        
		        comboBox = new JComboBox<>(services);
		        comboBox.setSelectedIndex(0);
		        comboBox.setBounds(20, 80, 300, 40);
//		        leftBottomPanel.add(comboBox);
		        //leftBottomPanel.setLayout(null);
		        
		        comboBoxbtn = new JButton("Submit Service");
		        comboBoxbtn.setBounds(20,50,80,20);
//		        leftBottomPanel.add(comboBoxbtn);
//		        comboBoxbtn.setVisible(true);
		        //leftBottomPanel.setLayout(null);	
		        
		        chatboxbtn = new JButton("ChatBox");
		        chatboxbtn.setBounds(40,200,100,30);
		        leftBottomPanel.add(chatboxbtn);
		        chatboxbtn.setVisible(true);
		        
		        leftBottomPanel.setLayout(null);
		        
		        servicePopup.add(comboBox);
		        servicePopup.add(comboBoxbtn);
		        
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

			
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logoutBtn) {
			System.out.println("\nLogout Button clicked!");
			
		}
		else if (e.getSource() == i1) {
			desktopPane.removeAll();
			TechnicianComplaintView tcv = new TechnicianComplaintView();		
			desktopPane.add(tcv).setVisible(true);
			desktopPane.moveToFront(tcv);
			tcv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			tcv.setLocation(0,0);
			
		}

		else if (e.getSource() == comboBox) {
			System.out.println("Services Status");
			desktopPane.removeAll();
			
			
		} else if (e.getSource() == serviceBtn) {
			System.out.println("Service clicked");

			serviceBox();
	
			
		}
		
		
		
	
	}
		public static void main(String[] args) {
			new MicroStarCableTechnician();

		}
	
}
