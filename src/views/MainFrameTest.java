package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import complaintsViews.ComplaintView;

public class MainFrameTest extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menu, menu2, menu3, menu4;
	private JButton logoutBtn;
	private JMenuBar menuBar;
	private JMenuItem i1, i2, i3, i4, i5, i6, i7, i8;
	private JDesktopPane desktopPane;
	
	
	public MainFrameTest() {
		menu  = new JMenu("Users");
		menu2 = new JMenu("Complaints");
		menu3 = new JMenu("Responses");
		menu4 = new JMenu("Accounts");
		menuBar= new JMenuBar();
		logoutBtn = new JButton("LOGOUT");
		i1 = new JMenuItem("Submit a Complaint");
		i2 = new JMenuItem("Display All Complaints");
		i3 = new JMenuItem("Get Complaints Per Customer");
		i4 = new JMenuItem("Find Complaint By Id ");
		i5 = new JMenuItem("Update a Complaint");
		i6 = new JMenuItem("Assign Technician");
		i8 = new JMenuItem("Add a Response");
		i7 = new JMenuItem("Delete a Complaint");
		desktopPane = new JDesktopPane();
	    showForm();
	}
	
	public void createWindow() {
		 this.setTitle("MicroStar Frame");
		 this.setBounds(45,40,850,700);
		 this.getContentPane().setLayout(null);
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setResizable(false);
	}
	
	public void setLocationAndSize() {
		this.desktopPane.setBounds(330,5,500,620);
		this.desktopPane.setBackground(Color.white);
		
		this.i1.addActionListener(this);
		this.i2.addActionListener(this);
		this.i3.addActionListener(this);
		this.i4.addActionListener(this);
		this.i5.addActionListener(this);
		this.i6.addActionListener(this);
		this.i7.addActionListener(this);
		this.i8.addActionListener(this);
		this.logoutBtn.addActionListener(this);
		
	}
	
	public void addComponentsToFrame() {
		
		menu2.add(i1);
		menu2.add(i2);
		menu2.add(i3);
		menu2.add(i4);
		menu2.add(i5);
		menu2.add(i6);
		menu2.add(i7);
		menu3.add(i8);
		
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
			System.out.println("Logout Button clicked!");
		}
		else if (e.getSource() == i1) {
			System.out.println("Submit a Complaint clicked!");
			desktopPane.removeAll();
			ComplaintView cv = new ComplaintView();
			desktopPane.add(cv).setVisible(true);
			desktopPane.moveToFront(cv);
			cv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
			cv.setLocation(0,0);
		}
		else if (e.getSource() == i2) {
			System.out.println("Display All Complaints clicked!");
			desktopPane.removeAll();
//			Frame2 f2 = new Frame2();
//			desktopPane.add(f2).setVisible(true);
//			desktopPane.moveToFront(f2);
//			f2.setSize(desktopPane.getWidth(), desktopPane.getHeight());
//			f2.setLocation(0,0);
		}
		else if (e.getSource() == i3) {
			System.out.println("Get Complaints Per Customer clicked!");
			desktopPane.removeAll();

		}
		else if (e.getSource() == i4) {
			System.out.println("Find Complaint By Id clicked!");
			desktopPane.removeAll();

		}
		else if (e.getSource() == i5) {
			System.out.println("Update a Complaint clicked!");
			desktopPane.removeAll();

		}
		else if (e.getSource() == i6) {
			System.out.println("Assign Technician clicked!");
			desktopPane.removeAll();

		}
		else if (e.getSource() == i7) {
			System.out.println("Delete a Complaint clicked!");
			desktopPane.removeAll();

		}
		
	}

	public static void main(String[] args) {
		new MainFrameTest();

	}
}
