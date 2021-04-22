/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complaintsViews;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ComplaintController;
import models.Complaint;
import utils.CustomizedException;

/**
 *
 * @author Steen
 */
public class FindComplaintById extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Search
     */
	
    public FindComplaintById() {
    	initComponents();
    }

    public void addRowsToJTable(int in) {
    	try {
 

  	  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
  	  ComplaintController cc = new ComplaintController();
  	  int input = in;
				Complaint complaint = cc.findById(input);
				System.out.println("List successfully retrieved!");
				 Object rowData[] = new Object[8];
			        for (int i =0; i < 1; i++ ){
			            rowData[0] = complaint.getComplaintID();
			            rowData[1] = complaint.getCustID().getUserId();
  			            rowData[2] = complaint.getEmpID() != null?complaint.getEmpID().getUserId():null;
			            rowData[3] = complaint.getCategory();
			            rowData[4] = complaint.getComplaint();
			            rowData[5] = complaint.getComplaintDate();
			            rowData[6] = complaint.getComplaintType();
			            rowData[7] = complaint.getComplaintStatus();
			            
			            model.addRow(rowData);
			        }
			} catch (CustomizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
  	 
  }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setEnabled(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Complaint");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setPreferredSize(new java.awt.Dimension(870, 450));

        jLabel2.setText("Enter Complaint ID to search below");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        this.setBackground(Color.WHITE);
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complaint Id", "Customer Id", "Employee Id", "Complaint Category",
                "Complaint", "Complaint Date", "Complaint Type", "Complaint Status"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(371, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );




        pack();
    }// </editor-fold>                        

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent e) {                                            
        
    	if(e.getSource() == jTextField2) {

			if (jTextField2.getText().equals("")){
           	 JOptionPane.showMessageDialog(FindComplaintById.this,
         			  	"You cannot submit an empty value.\nPlease try again.",
         			    "Search Complaint Status",
         			    JOptionPane.ERROR_MESSAGE);
            } else {
            	try {
					if (Integer.parseInt(jTextField2.getText()) > 0) {
			           	int input = Integer.parseInt(jTextField2.getText()); 
						System.out.println("Search Complaint Input: "+input);
						try {
							addRowsToJTable(input);
							JOptionPane.showMessageDialog(FindComplaintById.this,
								  	"Complaint record was found",
								    "Search Complaint Status",
								    JOptionPane.INFORMATION_MESSAGE);
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(FindComplaintById.this,
								  	"Complaint record not found in database",
								    "Search Complaint Status",
								    JOptionPane.ERROR_MESSAGE);
						}
					} else if (Integer.parseInt(jTextField2.getText()) < 0) {
		           	  JOptionPane.showMessageDialog(FindComplaintById.this,
						  	"Invalid input.\nId number must not be negative number."
						  	+ "\nPlease try again.",
						    "Search Complaint Status",
						    JOptionPane.WARNING_MESSAGE);
		           	  
		             } else if (Integer.parseInt(jTextField2.getText()) == 0) {
		            	 	JOptionPane.showMessageDialog(FindComplaintById.this,
							  	"Invalid input.\nId number must not be equal to zero."
							  	+ "\nPlease try again.",
							    "Search Complaint Status",
							    JOptionPane.WARNING_MESSAGE);
		            	
		             } 
				 
	            } catch (NumberFormatException e2) {
	            	JOptionPane.showMessageDialog(FindComplaintById.this,
	         			  	"You cannot submit letters.\nPlease try again.",
	         			    "Search Complaint Status",
	         			    JOptionPane.ERROR_MESSAGE);
	            	
	            }
            }

		}	
  	
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindComplaintById().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration   
    
	
}
