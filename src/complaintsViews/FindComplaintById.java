package complaintsViews;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controllers.ComplaintController;
import models.Complaint;
import utils.CustomizedException;

/**
 *
 * @author Steen
 */
public class FindComplaintById extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form NewJFrame
     */
    public FindComplaintById() {
        initComponents();
        addRowsToJTable();
    }

    public void addRowsToJTable() {
    	  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        Grab the returned array list and put it into a variable of type Arraylist
    	  ComplaintController cc = new ComplaintController();
			try {
				ArrayList <Complaint> displayList = cc.findById();
				System.out.println("List successfully retrieved!");
				 Object rowData[] = new Object[7];
			        for (int i =0; i < displayList.size(); i++ ){
			            rowData[0] = displayList.get(i).getComplaintID();
			            rowData[1] = displayList.get(i).getCustID();
			            rowData[2] = displayList.get(i).getEmpID();
			            rowData[3] = displayList.get(i).getCategory();
			            rowData[4] = displayList.get(i).getComplaint();
			            rowData[5] = displayList.get(i).getComplaintDate();
			            rowData[6] = displayList.get(i).getComplaintType();
			         
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complaint Id", "Customer Id", "Employee Id", "Complaint Category ", "Complaint ", "Complaint Date", "Complaint Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(DisplayAllComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayAllComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayAllComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayAllComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayAllComplaintsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}