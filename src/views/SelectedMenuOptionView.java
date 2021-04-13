package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectedMenuOptionView extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel headerPanel;
	private String selectedOption;
	private JLabel headerLabel;
	private JPanel contentPanel;
	private JPanel btnPanel;
	
	public SelectedMenuOptionView(String option) {
		super(option);
		this.selectedOption = option;
		headerPanel = new JPanel();
		headerLabel = new JLabel(option);
		contentPanel = new JPanel();
		btnPanel =  new JPanel();
		showForm();
	}
	
	 private void createWindow()
	    {
		    this.getContentPane().setBackground(Color.white);
	        this.getContentPane().setLayout(new BorderLayout());
	        this.setVisible(true);
	    }

	 private void setLocationAndSize() {
		headerPanel.setLayout(null);
		headerPanel.setPreferredSize(new Dimension(300,40));
		headerPanel.setBackground(Color.blue);
		
		btnPanel.setLayout(null);
		//btnPanel.setPreferredSize(new Dimension(200,100));
		btnPanel.setBackground(Color.orange);
		
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(300,600));
		contentPanel.setBackground(Color.CYAN);
		headerLabel.setBounds(450,0,200,50);
		headerLabel.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,26));
		
	     
	 }
	 
	 private void addComponentsToFrame() {
		 
		 headerPanel.add(headerLabel);
		 this.add(headerPanel,BorderLayout.NORTH);
		 this.add(btnPanel,BorderLayout.CENTER); 
		 this.add(contentPanel,BorderLayout.SOUTH);
	}
	 
	 private void showForm() {
		 createWindow();
		 setLocationAndSize();
		 addComponentsToFrame();
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
