package UserView;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;


import controllers.ResponseController;
import controllers.UserController;
import models.Response;
import models.User;
import utils.CustomizedException;

public class viewAllUsers extends JInternalFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	   public viewAllUsers() {
	        initComponents();
	    }

	    public void addRowsToJTable() {
	    	  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//	        Grab the returned array list and put it into a variable of type Arraylist
	    	  UserController cc = new UserController();
	    	 
	    		  try {
	  				ArrayList <User> displayList = cc.getAllUsers();
	  				System.out.println("List successfully retrieved!");
	  				 Object rowData[] = new Object[8];
	  			        for (int i =0; i < displayList.size(); i++ ){
	  			            rowData[0] = displayList.get(i).getUserId();
	  			            rowData[1] = displayList.get(i).getFirstName();
	  			            rowData[2] = displayList.get(i).getLastName() ;
	  			            rowData[3] = displayList.get(i).getPassword();
	  			           
	  			          rowData[4] = displayList.get(i).getContactNum();
	  			            rowData[5] = displayList.get(i).getEmail() ;
	  			            rowData[6] = displayList.get(i).getRole();
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
	        jTable1.setEnabled(false);
	        jTable1.getTableHeader().setReorderingAllowed(false);
	        jTable1.getTableHeader().setResizingAllowed(false);
	        jTable1.getTableHeader().setReorderingAllowed(false);
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jTable1.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	            		"userId", "firstName", "lastName", "password", "contact number", "email", "Role"
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
	            java.util.logging.Logger.getLogger(viewAllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(viewAllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(viewAllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(viewAllUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new viewAllUsers().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify                     
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable1;
	    // End of variables declaration                   
	}

