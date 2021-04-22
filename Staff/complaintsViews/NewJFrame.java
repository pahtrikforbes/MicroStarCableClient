/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complaintsViews;

import java.io.StreamCorruptedException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controllers.ComplaintController;
import models.Complaint;
import utils.ComplaintStatus;
import utils.CustomizedException;

/**
*
* @author Steen
*/
public class NewJFrame extends javax.swing.JFrame {

   /**
    * Creates new form update
    */
   public NewJFrame() {
       initComponents();
   }
   
   String newStatus;
   
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jLabel1 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jButton1 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
       jLabel1.setText("Enter updated status  ");

       jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

       jButton1.setText("Confirm");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               try {
				jButton1ActionPerformed(evt);
			} catch (StreamCorruptedException e) {
				JOptionPane.showMessageDialog(NewJFrame.this,
	     			  	"Update unsuccessful!\nPlease try again",
	     			    "Complaint View Tip",
	     			    JOptionPane.WARNING_MESSAGE);
			}
           }
       });

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(52, 52, 52)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel1)
                           .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(88, 88, 88)
                       .addComponent(jButton1)))
               .addContainerGap(52, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(22, 22, 22)
               .addComponent(jLabel1)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(jButton1)
               .addContainerGap(21, Short.MAX_VALUE))
       );

       pack();
   }// </editor-fold>                        

   public Complaint oldComplaint;
   
   public Complaint getOldComplaint() {
	return oldComplaint;
}


public void setOldComplaint(Complaint oldComplaint) {
	this.oldComplaint = oldComplaint;
}


private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws StreamCorruptedException {  
   		String newStatus = jTextField1.getText();
   		
   		System.out.println("New Status: "+newStatus);
   		String r1 = "RESOLVED";
   		String o1 = "OUTSTANDING";
   		
   		ComplaintController cc = new ComplaintController();
   		try {
			System.out.println("Complaint found:\n"+oldComplaint);
			System.out.println("\nConfirming new status: "+newStatus);
			
			if(newStatus.equals(r1)) {
				System.out.println("Updating complaint status to RESOLVED");
				oldComplaint.setComplaintStatus(ComplaintStatus.RESOLVED);
				System.out.println(oldComplaint);
				System.out.println("Status set completed\n");
				
				Complaint newComplaint = cc.updateComplaint(oldComplaint);
				System.out.println("Updated Complaint details: \n"+newComplaint);
				JOptionPane.showMessageDialog(NewJFrame.this,
	     			  	"Update successful!",
	     			    "Complaint View Tip",
	     			    JOptionPane.INFORMATION_MESSAGE);
				
			} else if (newStatus.equals(o1)) {
				System.out.println("Updating complaint status to OUTSTANDING");
				oldComplaint.setComplaintStatus(ComplaintStatus.OUTSTANDING);
				System.out.println("Status set completed\n");
				
				Complaint newComplaint = cc.updateComplaint(oldComplaint);
				System.out.println("Updated Complaint details: \n"+newComplaint);
				JOptionPane.showMessageDialog(NewJFrame.this,
	     			  	"Update successful!",
	     			    "Complaint View Tip",
	     			    JOptionPane.INFORMATION_MESSAGE);
				
			} else {
				System.out.println("Incorrect input. Case sensitive");
			}
			
			System.out.println("Jump out of if statement");
			
			
			
		} catch (CustomizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
           java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new NewJFrame().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify                     
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   public javax.swing.JTextField jTextField1;
   // End of variables declaration       
}
