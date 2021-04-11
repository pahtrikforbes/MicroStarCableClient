package complaintsViews;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ResponseView.addResponse;
import complaintsViews.ComplaintView;
import controllers.ComplaintController;
import models.Complaint;
import utils.CustomizedException;

public class MainFrameTest extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menu, menu2, menu3, menu4;
	private JButton logoutBtn;
	private JMenuBar menuBar;
	private JMenuItem i1,i3,i2,i4;
	static private JDesktopPane desktopPane;
	
	
	public MainFrameTest() {
		menu  = new JMenu("Users");
		menu2 = new JMenu("Complaints");
		menu3 = new JMenu("Responses");
		menu4 = new JMenu("Accounts");
		menuBar= new JMenuBar();
		logoutBtn = new JButton("LOGOUT");
		i1 = new JMenuItem("Submit a Complaint");
		i2 = new JMenuItem("Submit a Response");
		i3 = new JMenuItem("Complaint Action View");
		i4=new JMenuItem("View all responses");
		desktopPane = new JDesktopPane();
	    showForm();
	}
	
	public void createWindow() {
		
		this.setTitle("MicroStar Frame");
		 this.setBounds(45,40,1200,710);
		 this.getContentPane().setLayout(null);
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setResizable(false);
	}
	
	public void setLocationAndSize() {
		desktopPane.setBounds(315,7,870,635);
		desktopPane.setBackground(Color.white);
		
		this.i1.addActionListener(this);
		this.i2.addActionListener(this);
		
		this.i3.addActionListener(this);
		
		
		
		
		this.i4.addActionListener(this);
		
		
		this.logoutBtn.addActionListener(this);
		
		
		System.out.println("test");
	}
	
	public void addComponentsToFrame() {
		
		menu2.add(i1);
		menu2.add(i3);
		menu3.add(i2);
		menu3.add(i4);
		menuBar.add(menu);
		menuBar.add(menu2);	
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		menuBar.add(logoutBtn);
		
		this.setJMenuBar(menuBar);
		this.add(desktopPane);
	}
	
	public void showForm() {
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logoutBtn) {
			System.out.println("\nLogout Button clicked!");
			
		}
		else if (e.getSource() == i1) {
			System.out.println("\nSubmit Complaint clicked!");
			desktopPane.removeAll();
			ComplaintView cv = new ComplaintView();
			desktopPane.add(cv).setVisible(true);
			desktopPane.moveToFront(cv);
			cv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			cv.setLocation(0,0);
			
		}
		
		
		else if (e.getSource() == i3) {
			System.out.println("\nRep Complaints View clicked!");
			desktopPane.removeAll();
			RepresentativeComplaintsView rcv = new RepresentativeComplaintsView();
			desktopPane.add(rcv).setVisible(true);
			desktopPane.moveToFront(rcv);
			rcv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			rcv.setLocation(0,0);
			
		}
		
			
		else if (e.getSource() == i2) {
			System.out.println("\nSubmit Response clicked!");
			desktopPane.removeAll();
			addResponse ar = new addResponse();
			desktopPane.add(ar).setVisible(true);
			desktopPane.moveToFront(ar);
			ar.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			ar.setLocation(0,0);
			
		}
		else if (e.getSource() == i4) {
			System.out.println("\nShow all Responses clicked!");
			desktopPane.removeAll();
			DisplayAllResponses dar = new DisplayAllResponses();
			desktopPane.add(dar).setVisible(true);
			desktopPane.moveToFront(dar);
			dar.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			dar.setLocation(0,0);
			
			dar.addRowsToJTable();
			
		}
		
		/*
		else if (e.getSource() == i3) {
			System.out.println("\nTech Complaints View clicked!");
			desktopPane.removeAll();
			TechnicianComplaintView tcv = new TechnicianComplaintView();		
			desktopPane.add(tcv).setVisible(true);
			desktopPane.moveToFront(tcv);
			tcv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			tcv.setLocation(0,0);
			
		}
		*/ 
		
		
		/*
		else if (e.getSource() == i3) {
			System.out.println("\nCust Complaints View clicked!");
			desktopPane.removeAll();
			CustomerComplaintView ccv = new CustomerComplaintView();
			desktopPane.add(ccv).setVisible(true);
			desktopPane.moveToFront(ccv);
			ccv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			ccv.setLocation(0,0);
		}
		*/
	}

	public static void main(String[] args) {
		new MainFrameTest();

	}
}
