package ComplaintsView;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class findComplaints extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	
	
	public findComplaints() {
		showForm();
	}
	
	public void createWindow() {
		this.setTitle("Find Complaint");
		this.setBounds(0,0,490,580);
		this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    this.setResizable(false);
	}
	 
	
	public void showForm() {
		createWindow();

	}
	

	public static void main(String[] args) {
		new findComplaints();

	}

}
