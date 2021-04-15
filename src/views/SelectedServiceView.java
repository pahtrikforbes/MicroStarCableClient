package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import complaintsViews.ComplaintView;
import complaintsViews.ServiceTableView;

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
		
		BasicInternalFrameUI basic = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener li : basic.getNorthPane().getMouseListeners()) {
			basic.getNorthPane().removeMouseListener(li);
		}
		
		showForm();
	}
	
	 private void createWindow()
	    {
		    this.getContentPane().setBackground(Color.white);
	        this.getContentPane().setLayout(new BorderLayout());
	        this.setVisible(true);
	    }

	 private void setLocationAndSize() {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Color c1 = new Color(0,102,166);
		Color c2 = new Color(0,179,179);
		
		headerPanel.setLayout(null);
		headerPanel.setPreferredSize(new Dimension(300,40));
		headerLabel.setForeground(Color.WHITE);
		headerPanel.setBackground(c1);
		
		btnPanel.setLayout(null);
		btnPanel.setPreferredSize(new Dimension(300,30));
		btnPanel.setBackground(c2);
		
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(300,500));
		contentPanel.setBorder(blackline);
		
		headerLabel.setBounds(402,0,200,50);
		headerLabel.setFont(new Font("Times New Roman",Font.ITALIC+Font.BOLD,28));
		
		
	    this.resolvedBtn.setBounds(210,20,150,30);
	    this.outstandingBtn.setBounds(550,20,150,30);
	    
	    resolvedLbl.setBounds(250,50,150,30);
	    resolvedLbl.setFont(new Font("Times New Roman",Font.PLAIN,16));
	    
	    outstandingLbl.setBounds(580,50,150,30);
	    outstandingLbl.setFont(new Font("Times New Roman",Font.PLAIN,16));
	    
	    resolvedCountLbl.setBounds(325,50,150,30);
	    resolvedCountLbl.setFont(new Font("Times New Roman",Font.PLAIN,16));
	    
	    outstandingCountLbl.setBounds(670,50,150,30);
	    outstandingCountLbl.setFont(new Font("Times New Roman",Font.PLAIN,16));
	     
	    
	    this.resolvedBtn.addActionListener(this);
	    this.outstandingBtn.addActionListener(this);
	     
	 }
	 
	 private void addComponentsToFrame() {
		 
		 headerPanel.add(headerLabel);
		 btnPanel.add(resolvedBtn);
		 btnPanel.add(outstandingBtn);
		 btnPanel.add(resolvedLbl);
		 btnPanel.add(outstandingLbl);
		 btnPanel.add(resolvedCountLbl);
		 btnPanel.add(outstandingCountLbl);
		 this.add(headerPanel,BorderLayout.PAGE_START);
		 this.add(btnPanel,BorderLayout.CENTER); 
		 this.add(contentPanel,BorderLayout.PAGE_END);
	}
	 
	 private void showForm() {
		 createWindow();
		 setLocationAndSize();
		 addComponentsToFrame();
	 }
	
	 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (service.equalsIgnoreCase("Cable")) {
				System.out.println("\nInside Cable");
				
				if(e.getSource() == resolvedBtn) {			
					System.out.println("Cable Resolved button clicked!");
					contentPanel.removeAll();
					int num = 0;
					
					ServiceTableView sv = new ServiceTableView();
					sv.addRowsToJTable(num);
					int numRecords = sv.recordsNum;
					
					if (numRecords == 0) {
						JOptionPane.showMessageDialog(SelectedServiceView.this,
								"Zero records of type: Cable Oustanding!\n"
				          			    );	
						String numRecordsStr = String.valueOf(numRecords);				
						resolvedCountLbl.setText(numRecordsStr);
					
					} else if (numRecords > 0) {
					String numRecordsStr = String.valueOf(numRecords);				
					resolvedCountLbl.setText(numRecordsStr);
					
					sv.setVisible(true);
					sv.setBounds(70,40,767,326);
					contentPanel.add(sv);
					
					}
			
				} else if(e.getSource() == outstandingBtn) {			
					System.out.println("Cable Outstanding button clicked!");				
					contentPanel.removeAll();
					int num = 1;		
					
					ServiceTableView sv = new ServiceTableView();
					sv.addRowsToJTable(num);
					int numRecords = sv.recordsNum;
					
					if (numRecords == 0) {
						JOptionPane.showMessageDialog(SelectedServiceView.this,
								"Zero records of type: Cable Oustanding!\n"
				          			    );	
						String numRecordsStr = String.valueOf(numRecords);				
						outstandingCountLbl.setText(numRecordsStr);
					
					} else if (numRecords > 0) {
					String numRecordsStr = String.valueOf(numRecords);				
					outstandingCountLbl.setText(numRecordsStr);
					
					sv.setVisible(true);
					sv.setBounds(70,40,767,326);
					contentPanel.add(sv);
					
					}

			}
		}else if (service.equalsIgnoreCase("Broadband")) {
				System.out.println("\nInside Broadband");
				
				if(e.getSource() == resolvedBtn) {			
					System.out.println("Broadband Resolved button clicked!");
					contentPanel.removeAll();
					int num = 2;
					
					ServiceTableView sv = new ServiceTableView();
					sv.addRowsToJTable(num);
					int numRecords = sv.recordsNum;
					
					if (numRecords == 0) {
						JOptionPane.showMessageDialog(SelectedServiceView.this,
								"Zero records of type: Cable Oustanding!\n"
				          			    );	
						String numRecordsStr = String.valueOf(numRecords);				
						resolvedCountLbl.setText(numRecordsStr);
					
					} else if (numRecords > 0) {
					String numRecordsStr = String.valueOf(numRecords);				
					resolvedCountLbl.setText(numRecordsStr);
					
					sv.setVisible(true);
					sv.setBounds(70,40,767,326);
					contentPanel.add(sv);
					
					}
					
			
				} else if(e.getSource() == outstandingBtn) {			
					System.out.println("Broadband Outstanding button clicked!");		
					contentPanel.removeAll();
					int num = 3;		
					
					ServiceTableView sv = new ServiceTableView();
					sv.addRowsToJTable(num);
					int numRecords = sv.recordsNum;
					
					if (numRecords == 0) {
						JOptionPane.showMessageDialog(SelectedServiceView.this,
								"Zero records of type: Cable Oustanding!\n"
				          			    );	
						String numRecordsStr = String.valueOf(numRecords);				
						outstandingCountLbl.setText(numRecordsStr);
					
					} else if (numRecords > 0) {
					String numRecordsStr = String.valueOf(numRecords);				
					outstandingCountLbl.setText(numRecordsStr);
					
					sv.setVisible(true);
					sv.setBounds(70,40,767,326);
					contentPanel.add(sv);
					
					}
	
	
				}

		}
		
	}

}









