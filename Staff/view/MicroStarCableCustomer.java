package view;


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

	import complaintsViews.ComplaintView;
import complaintsViews.CustomerComplaintView;
import complaintsViews.RepresentativeComplaintsView;
	import controllers.ComplaintController;
	import models.Complaint;
import models.User;
import utils.CustomizedException;

	public class MicroStarCableCustomer extends JFrame implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JMenu menu, menu2, menu3, menu4;
		private JButton logoutBtn;
		private JMenuBar menuBar;
		private JMenuItem i1,i3;
		static private JDesktopPane desktopPane;
		private User user;
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		public MicroStarCableCustomer() {
			menu  = new JMenu("Users");
			menu2 = new JMenu("Complaints");
			menu3 = new JMenu("Responses");
			menu4 = new JMenu("Accounts");
			menuBar= new JMenuBar();
			logoutBtn = new JButton("LOGOUT");
			i1 = new JMenuItem("Submit a Complaint");
			i3 = new JMenuItem("Complaint Action View");
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
			this.i3.addActionListener(this);
			this.logoutBtn.addActionListener(this);
			
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
				desktopPane.removeAll();
				CustomerComplaintView ccv = new CustomerComplaintView();
				desktopPane.add(ccv).setVisible(true);
				desktopPane.moveToFront(ccv);
				ccv.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				ccv.setLocation(0,0);
			}
			
			
		
		}

		public static void main(String[] args) {
			new MicroStarCableCustomer();

		}
	
}
