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

import complaintsViews.ComplaintView;

public class SelectedServiceView extends JInternalFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JButton resolvedBtn;
	private JButton outstandingBtn;
	private JLabel resolvedLbl;
	private JLabel outstandingLbl;
	private JLabel resolvedCountLbl;
	private JLabel outstandingCountLbl;
	private JPanel headerPanel;
	private String service;
	private JLabel headerLabel;
	private JPanel contentPanel;
	private JPanel btnPanel;
	
	public SelectedServiceView(String service) {
		super(service);
		this.service = service;
		resolvedBtn = new JButton("View Resolved");
		resolvedLbl = new JLabel("Resolved: ");
		outstandingBtn = new JButton("View Outstanding");
		outstandingLbl = new JLabel("Outstanding: ");
		headerPanel = new JPanel();
		headerLabel = new JLabel(service);
		resolvedCountLbl = new JLabel("0");
		outstandingCountLbl = new JLabel("0");
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
		
		
	    this.resolvedBtn.setBounds(300,10,150,30);
	    this.outstandingBtn.setBounds(700,10,150,30);
	    resolvedLbl.setBounds(300,30,150,30);
	    outstandingLbl.setBounds(700,30,150,30);
	    
	    resolvedCountLbl.setBounds(400,30,150,30);
	    outstandingCountLbl.setBounds(800,30,150,30);
	     
	    
	    this.resolvedBtn.addActionListener(this);
	     
	 }
	 
	 private void addComponentsToFrame() {
		 
		 headerPanel.add(headerLabel);
		 btnPanel.add(resolvedBtn);
		 btnPanel.add(outstandingBtn);
		 btnPanel.add(resolvedLbl);
		 btnPanel.add(outstandingLbl);
		 btnPanel.add(resolvedCountLbl);
		 btnPanel.add(outstandingCountLbl);
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
		
		if(e.getSource() == resolvedBtn) {
			
			contentPanel.removeAll();
			contentPanel.repaint();
			ComplaintView cv = new ComplaintView();
			contentPanel.add(cv);
		}
		
	}

}
