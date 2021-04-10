
package complaintsViews;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.Client;
import controllers.ComplaintController;
import controllers.ResponseController;
import models.Complaint;
import models.Response;
import utils.CustomizedException;

/**
 *
 * @author Steen
 */
public class CustomerComplaintView extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form TestView
     */
    public CustomerComplaintView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Complaints ");
        jTable1.setDragEnabled(false);
        jTable1.setEnabled(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complaint Id", "Customer Id", "Employee Id", "Category", "Details", "Date", "Type", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setText("Other Actions");
        
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("View Selected");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Latest Response ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("View All Responses");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setText("Display Complaints");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(364, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 1) {
            	 JOptionPane.showMessageDialog(CustomerComplaintView.this,
         			  	"Row selected!",
         			    "Complaint View Tip",
         			    JOptionPane.INFORMATION_MESSAGE);
            	jTable1MouseClicked(evt);
            }
                
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pack();
    }// </editor-fold>                        
    
    ComplaintDetailsView cdv = new ComplaintDetailsView();
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	  // get the model from the jtable
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

         // get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();
        
        
        System.out.println("Selected: "+selectedRowIndex);
        
        String compId = model.getValueAt(selectedRowIndex, 0).toString();        
        
        String custId = model.getValueAt(selectedRowIndex,1).toString();      
        
        if (model.getValueAt(selectedRowIndex,2) == null) {
        	System.out.println("Employee Id is null");
        	cdv.jTextField2.setText("Not assigned");
        } else {
        	String empId = model.getValueAt(selectedRowIndex,2).toString();
        	cdv.jTextField2.setText(empId); 
        }
        
        
        String compCategory = model.getValueAt(selectedRowIndex,3).toString();
        String compDetails = model.getValueAt(selectedRowIndex,4).toString();
        String compDate = model.getValueAt(selectedRowIndex,5).toString();
        String compType = model.getValueAt(selectedRowIndex,6).toString();
        String compStatus = model.getValueAt(selectedRowIndex,7).toString();
             
        
        cdv.jTextField7.setText(compId);
        cdv.jTextField1.setText(custId);                 
        cdv.jTextField3.setText(compCategory);
        cdv.jTextField4.setText(compDate);
        cdv.jTextField5.setText(compType);
        cdv.jTextField6.setText(compStatus);
        cdv.jTextArea1.setText(compDetails);
        
        
        cdv.setVisible(true);
        cdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cdv.setLocationRelativeTo(null);
        
        
         
    }  
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
    	System.out.println("Click!");
      
    }  
    JTable jTable2 = new JTable();
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	jTable2.setModel(new DefaultTableModel(null, new String [] {
                "Response Id","Complaint Id","Response", "Response"
       }));
   	   DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

        // get the selected row index
       int selectedRowIndex = jTable1.getSelectedRow();
       
       
       System.out.println("Selected: "+selectedRowIndex);
       
       String compIdStr = model.getValueAt(selectedRowIndex, 0).toString();       
       
       System.out.println("Complaint Id: "+compIdStr);
       
       int compId = Integer.parseInt(compIdStr);
       
       addRowsToJTableLatest(compId);

    }  
    
    public void addRowsToJTableLatest(int complaintId) {
    	jTable2.setModel(new DefaultTableModel(null, new String [] {
                "Response Id","Complaint Id","Response", "Response"
       }));
    	DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
    	
//        Grab the returned array list and put it into a variable of type Arraylist
    	  ResponseController rc = new ResponseController();
    	  int complaintId1 = complaintId;
    		  try {
    			  
  				ArrayList <Response> displayList2 = rc.getResponsesPerUser(complaintId1);
  				System.out.println("List successfully retrieved!");
  				Object rowData[] = new Object[4];
  				int lastResponse = (displayList2.size()-1);
  				System.out.println("Array length: "+lastResponse);
  				
  			       for (int i =0; i < displayList2.size(); i++ ){
  			       
  			        	rowData[0] = displayList2.get(i).getResponse_id();
  			        	rowData[1] = displayList2.get(i).getComplaint_id().getComplaintID();
  			        	rowData[2] = displayList2.get(i).getResponse_date();
  			        	rowData[3] = displayList2.get(i).getResponse();
  			        	
  			            model2.addRow(rowData);  

  			        }
  			       
  			       System.out.println("\nExiting for loop");

  			            String data0 = model2.getValueAt(lastResponse, 0).toString();
  			            String data1 = model2.getValueAt(lastResponse, 1).toString();
  			            String data2 = model2.getValueAt(lastResponse, 2).toString();
  			            String data3 = model2.getValueAt(lastResponse, 3).toString();
  			            
  			            
  			       System.out.println("Response Id: "+data0);     
  			              
  			        
  			        	ResponseDetailsView rdv = new ResponseDetailsView(); 
  			            rdv.setLocationRelativeTo(null);
  			            rdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  			            
  			            rdv.jTextField1.setText(data0);
  			            rdv.jTextField2.setText(data1);
  			            rdv.jTextField3.setText(data2);
  			            rdv.jTextArea1.setText(data3);
  			            
  			            rdv.setVisible(true);
  			            
  			          
  			} catch (ArrayIndexOutOfBoundsException e2) {
  				JOptionPane.showMessageDialog(CustomerComplaintView.this,
         			  	"No response available!",
         			    "Complaint View Tip",
         			    JOptionPane.INFORMATION_MESSAGE);
    		  
    		} catch (CustomizedException e1) {
  				// TODO Auto-generated catch block
  				
  				e1.printStackTrace();
  			}
  			
    	 
    }
    
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	DisplayResponsesView drv = new DisplayResponsesView();
    	 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

         // get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();
        
        
        System.out.println("Selected: "+selectedRowIndex);
        
        String compIdStr = model.getValueAt(selectedRowIndex, 0).toString();       
        
        System.out.println("Complaint Id: "+compIdStr);
        
        int compId = Integer.parseInt(compIdStr);
        
        drv.addRowsToJTable(compId);
        drv.setLocationRelativeTo(null);
        drv.setVisible(true);
    }  
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	jTable1.setModel(new DefaultTableModel(null, new String [] {
	                "Complaint Id", "Customer Id", "Employee Id",
	                "Category", "Details", "Date", "Type", "Status"
          }));
    	addRowsToJTableCust();
    }                              
//    

    public void addRowsToJTableCust() {
    	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        Grab the returned array list and put it into a variable of type Arraylist
    	  ComplaintController cc = new ComplaintController();
    	  
    		  try {
    			  int user = 1736;
  				ArrayList <Complaint> displayList = cc.getComplaintsPerUser(user);
  				System.out.println("List successfully retrieved!");
  				 Object rowData[] = new Object[8];
  			        for (int i =0; i < displayList.size(); i++ ){
  			            rowData[0] = displayList.get(i).getComplaintID();
  			            rowData[1] = displayList.get(i).getCustID().getUserId();
			            rowData[2] = displayList.get(i).getEmpID() != null?displayList.get(i).getEmpID().getUserId():null;
  			            rowData[3] = displayList.get(i).getCategory();
  			            rowData[4] = displayList.get(i).getComplaint();
  			            rowData[5] = displayList.get(i).getComplaintDate();
  			            rowData[6] = displayList.get(i).getComplaintType();
  			            rowData[7] = displayList.get(i).getComplaintStatus();
  			         
  			            model.addRow(rowData);
  			            
  			           		            
  			        }
  			} catch (CustomizedException e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
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
            java.util.logging.Logger.getLogger(CustomerComplaintView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerComplaintView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerComplaintView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerComplaintView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerComplaintView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration   
}

