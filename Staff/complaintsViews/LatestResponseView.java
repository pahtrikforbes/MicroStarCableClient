package complaintsViews;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LatestResponseView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel heading;
	private JLabel subHeading;
	private JLabel respIdLabel;
	private JLabel compIdLabel;
	private JLabel fNameLabel;
	private JLabel lNameLabel;
	private JLabel dateLabel;
	private JLabel respLabel;
	
	public JTextField respIdTextField;
	public JTextField compIdTextField;
	public JTextField fNameTextField;
	public JTextField lNameTextField;
	public JTextField dateTextField;
	
	
	public JTextArea respDetails;
	
	private JButton btn;
	
	
	public LatestResponseView() {
		this.heading = new JLabel("Response Details");
		this.subHeading = new JLabel("(Latest response)");
		this.respIdLabel = new JLabel("Response Id");
		this.compIdLabel = new JLabel("Complaint Id");
		this.fNameLabel = new JLabel("First Name");
		this.lNameLabel = new JLabel("Last Name");
		this.dateLabel = new JLabel("Response Date");
		this.respLabel = new JLabel("Response");
		
		this.respIdTextField = new JTextField();
		this.compIdTextField = new JTextField();
		this.fNameTextField = new JTextField();
		this.lNameTextField = new JTextField();
		this.dateTextField = new JTextField();
		
		this.respDetails = new JTextArea();
		
		this.btn = new JButton("OK");
		
		showForm();
	}
	
	
	public void createWindow()
    {
       //Setting properties of JFrame; i.e this frame
        this.setTitle("Latest Response");
        this.setBounds(45,50,400,600);
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(null);
        this.setVisible(true); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }
	
	public void setLocationAndSize()
    {
//		Setting Location and Size of Each Component
		this.heading.setBounds(125,10,160, 30);
		this.subHeading.setBounds(155,40,160, 30);
        this.respIdLabel.setBounds(35,90,160,70);
        this.compIdLabel.setBounds(35,140,160,70);
        this.fNameLabel.setBounds(35,190,160,70);
        this.lNameLabel.setBounds(35,240,160,70);
        this.dateLabel.setBounds(35,290,160,70);
        this.respLabel.setBounds(35,340,160,70);

        this.heading.setFont(new Font("Times New Roman", Font.BOLD,22));
		this.subHeading.setFont(new Font("Times New Roman", Font.BOLD,12));
        this.respIdLabel.setFont(new Font("Times New Roman", Font.BOLD,16));
        this.compIdLabel.setFont(new Font("Times New Roman", Font.BOLD,16));
        this.fNameLabel.setFont(new Font("Times New Roman", Font.BOLD,16));
        this.lNameLabel.setFont(new Font("Times New Roman", Font.BOLD,16));
        this.dateLabel.setFont(new Font("Times New Roman", Font.BOLD,16));
        this.respLabel.setFont(new Font("Times New Roman", Font.BOLD,16));
        
        
        this.respIdTextField.setBounds(170,110,160,30);
		this.compIdTextField.setBounds(170,160,160,30);
        this.fNameTextField.setBounds(170,210,160,30);
        this.lNameTextField.setBounds(170,260,160,30);
        this.dateTextField.setBounds(170,310,160,30);
       
        this.respDetails.setBounds(160,365,180,130);
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        this.respDetails.setBorder(border);
        
        this.btn.setBounds(150,510,70,30);
        this.btn.addActionListener(this);
        
        this.respIdTextField.setFont(new Font("Times New Roman", Font.PLAIN,14));
		this.compIdTextField.setFont(new Font("Times New Roman", Font.PLAIN,14));
        this.fNameTextField.setFont(new Font("Times New Roman", Font.PLAIN,14));
        this.lNameTextField.setFont(new Font("Times New Roman", Font.PLAIN,14));
        this.dateTextField.setFont(new Font("Times New Roman", Font.PLAIN,14));
        this.respDetails.setFont(new Font("Times New Roman", Font.PLAIN,14));
        
        respIdTextField.setEditable(false);
    	compIdTextField.setEditable(false);
    	fNameTextField.setEditable(false);
    	lNameTextField.setEditable(false);
    	dateTextField.setEditable(false); 	
    	respDetails.setEditable(false);
    	
    }
	
	//    Adds components to the JFrame
	public void addComponentsToFrame() {
		this.add(this.heading);
		this.add(this.subHeading);
        this.add(this.respIdLabel);
        this.add(this.compIdLabel);
        this.add(this.fNameLabel);
        this.add(this.lNameLabel);
        this.add(this.dateLabel);
        this.add(this.respLabel);
		
        this.add(this.respIdTextField);
        this.add(this.compIdTextField);
        this.add(this.fNameTextField);
        this.add(this.lNameTextField);
        this.add(this.dateTextField);
        this.add(this.respDetails);
        
        this.add(btn);
    }
	
//	Shows the JFrame 
    public void showForm() {
    	 this.createWindow(); 
    	 this.setLocationAndSize();
    	 this.addComponentsToFrame();
    }
	
	
	
	
	public static void main(String[] args) {
		LatestResponseView	view =  new LatestResponseView();
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btn) {
			this.dispose();
		}
		
	}

}
