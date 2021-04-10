package AccountView;

import java.awt.Color;

import javax.swing.JFrame;
  
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



import controllers.AccountController;
import models.Account;
import utils.CustomizedException;

public class findAccByID extends JInternalFrame{
	
    // Variables declaration - do not modify                     
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    

	private static final long serialVersionUID = 1L;
	
	
	public findAccByID() {
		showForm();
	}
	
	public void createWindow() {
		this.setTitle("Find Account");
		this.setBounds(0,0,490,580);
		this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    this.setResizable(false);
	}
	
	public void showForm() {
		createWindow();

	}
	
	public void addRowsToJTable(int in) {
		
		try {
			
			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			AccountController ac = new AccountController(null, null);
			int input = in;
			
			Account account = ac.findById(input);
			System.out.println("Account list successfully retrieved!");
			Object rowData[] = new Object[1];
	        for (int i =0; i < 1; i++ ){
	            rowData[0] = account.getAcct_id();
	            rowData[1] = account.getUser();

	        
	            model.addRow(rowData);
	        }
	} catch (CustomizedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

}
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
	        setTitle("Search For Account");
	        setBackground(new java.awt.Color(255, 255, 255));
	        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
	        setPreferredSize(new java.awt.Dimension(870, 450));

	        jLabel2.setText("Enter Account ID to search below");

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
	                "Account Id", "User Id"
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
	           	 JOptionPane.showMessageDialog(findAccByID.this,
	         			  	"You cannot submit an empty value.\nPlease try again.",
	         			    "Search Account Status",
	         			    JOptionPane.ERROR_MESSAGE);
	            } else {
	            	try {
						if (Integer.parseInt(jTextField2.getText()) > 0) {
				           	int input = Integer.parseInt(jTextField2.getText()); 
							System.out.println("Search Account Input: "+input);
							try {
								addRowsToJTable(input);
								JOptionPane.showMessageDialog(findAccByID.this,
									  	"Account info was found",
									    "Search Account Status",
									    JOptionPane.INFORMATION_MESSAGE);
							} catch (NullPointerException npe) {
								JOptionPane.showMessageDialog(findAccByID.this,
									  	"Account info not found in database",
									    "Search Account Status",
									    JOptionPane.ERROR_MESSAGE);
							}
						} else if (Integer.parseInt(jTextField2.getText()) < 0) {
			           	  JOptionPane.showMessageDialog(findAccByID.this,
							  	"Invalid input.\nId number must not be negative number."
							  	+ "\nPlease try again.",
							    "Search Account Status",
							    JOptionPane.WARNING_MESSAGE);
			           	  
			             } else if (Integer.parseInt(jTextField2.getText()) == 0) {
			            	 	JOptionPane.showMessageDialog(findAccByID.this,
								  	"Invalid input.\nId number must not be equal to zero."
								  	+ "\nPlease try again.",
								    "Search Account Status",
								    JOptionPane.WARNING_MESSAGE);
			            	
			             } 
					 
		            } catch (NumberFormatException e2) {
		            	JOptionPane.showMessageDialog(findAccByID.this,
		         			  	"You cannot submit letters.\nPlease try again.",
		         			    "Search Account Status",
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
	                new findAccByID().setVisible(true);
	            }
	        });
	    }

	
	    
		
	}

	




