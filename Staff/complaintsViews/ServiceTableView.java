package complaintsViews;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import controllers.ComplaintController;
import models.Complaint;
import utils.CustomizedException;

public class ServiceTableView extends javax.swing.JInternalFrame {

    /**
     * Creates new form table
     */
    public ServiceTableView() {
        initComponents();
    }

    public int recordsNum;

    public int getRecordsNum() {
		return recordsNum;
	}

	public void setRecordsNum(int recordsNum) {
		this.recordsNum = recordsNum;
	}


	public void addRowsToJTable(int num) {
  	  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//      Grab the returned array list and put it into a variable of type Arraylist
  	  ComplaintController cc = new ComplaintController();
  	  if(num == 0) {
  		  try {
				ArrayList <Complaint> displayList = cc.getAllResolvedCableComplaints();
				System.out.println("AllResolvedCableComplaints List successfully retrieved!");
				recordsNum = displayList.size();
			
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
			            System.out.println(rowData);
			        }
			} catch (CustomizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
  	  } 
  	  
  	 
  	  else if (num ==1) {
  		  try {
				ArrayList <Complaint> displayList = cc.getAllOutstandingCableComplaints();
				System.out.println("AllOutstandingCableComplaints List successfully retrieved!");
				System.out.println(displayList);
				recordsNum = displayList.size();
				
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
  	  } else if (num == 2) {
  		  try {
				ArrayList <Complaint> displayList = cc.getAllResolvedBroadbandComplaints();
				System.out.println("AllResolvedBroadbandComplaints List successfully retrieved!");
				recordsNum = displayList.size();
				
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
  	  } else if (num == 3) {
  		  try {
				ArrayList <Complaint> displayList = cc.getAllOutstandingBroadbandComplaints();
				System.out.println("\nAllOutstandingBroadbandComplaints List successfully retrieved!");
				recordsNum = displayList.size();
			
				
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
	 
	 
	 
  }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setDragEnabled(false);
        jTable1.setEnabled(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        
        BasicInternalFrameUI basic = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener li : basic.getNorthPane().getMouseListeners()) {
			basic.getNorthPane().removeMouseListener(li);
		}
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complaint Id", "Customer Id", "Employee Id", "Category", 
                "Details", "Date", "Type", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(ServiceTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceTableView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
