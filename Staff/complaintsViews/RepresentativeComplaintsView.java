package complaintsViews;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.ComplaintController;
import controllers.ResponseController;
import models.Complaint;
import models.Response;
import utils.CustomizedException;

/**
 *
 * @author Steen
 */
public class RepresentativeComplaintsView extends javax.swing.JInternalFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form TestView
     */
    public RepresentativeComplaintsView() {
        initComponents();
    }

    public void addRowsToJTable(int num) {
  	  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//      Grab the returned array list and put it into a variable of type Arraylist
  	  ComplaintController cc = new ComplaintController();
  	  if(num == 0) {
  		  try {
  			  
				ArrayList <Complaint> displayList = cc.getAllComplaints();
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
			
  	  } else if (num ==1) {
  		  try {
				ArrayList <Complaint> displayList = cc.getAllMildComplaints();
				System.out.println("List successfully retrieved!");
				System.out.println(displayList);
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
				ArrayList <Complaint> displayList = cc.getAllModerateComplaints();
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
  	  } else if (num == 3) {
  		  try {
				ArrayList <Complaint> displayList = cc.getAllSevereComplaints();
				System.out.println("\nList successfully retrieved!");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Complaints ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complaint Id", "Customer Id", "Employee Id", "Category", "Details", "Date", "Type", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("View By Category");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Complaints", "Mild Complaints", "Moderate Complaints", "Severe Complaints" }));

        jButton1.setText("GO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setText("Search ");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Enter Complaint Id");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
      

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
        
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Update ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setText("Assign Technician");
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addGap(103, 103, 103)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1)))
                        .addGap(185, 185, 185))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton7))
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton8))
                        .addGap(57, 57, 57))))
        );
        jComboBox1.addActionListener(this);
        
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 1) {
            	 JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
    	System.out.println("Click!");
      
    }  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	String choice = jComboBox1.getSelectedItem().toString();
		System.out.println("Selected: "+choice);
		
		switch(choice) {
			case "All Complaints":
				jTable1.setModel(new DefaultTableModel(null, new String [] {
	  	                "Complaint Id", "Customer Id", "Employee Id",
	  	                "Category", "Details", "Date", "Type", "Status"
	              }));
				System.out.println("All Complaints");
				int num = 0;
				addRowsToJTable(num);
				
			break;
			case "Mild Complaints":
				jTable1.setModel(new DefaultTableModel(null, new String [] {
	  	                "Complaint Id", "Customer Id", "Employee Id",
	  	                "Category", "Details", "Date", "Type", "Status"
	              }));
				System.out.println("Mild Complaints");
				int num1 = 1;
				addRowsToJTable(num1);
				
			break;
			case "Moderate Complaints":
				jTable1.setModel(new DefaultTableModel(null, new String [] {
	  	                "Complaint Id", "Customer Id", "Employee Id",
	  	                "Category", "Details", "Date", "Type", "Status"
	              }));
				System.out.println("Moderate Complaints");
				int num2 = 2;
				addRowsToJTable(num2);
				
			break;
			case "Severe Complaints":
				jTable1.setModel(new DefaultTableModel(null, new String [] {
	  	                "Complaint Id", "Customer Id", "Employee Id",
	  	                "Category", "Details", "Date", "Type", "Status"
	              }));
				System.out.println("Severe Complaints");
				int num3 = 3;
				addRowsToJTable(num3);
				
			break;
		}
    }
    
    ComplaintDetailsView cdv = new ComplaintDetailsView();
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {  
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
    
    public void addRowsToJTableFind(int in) {
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
    
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent e) {                                            
    	if(e.getSource() == jTextField1) {

			if (jTextField1.getText().equals("")){
           	 JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
         			  	"You cannot submit an empty value.\nPlease try again.",
         			    "Search Complaint Status",
         			    JOptionPane.ERROR_MESSAGE);
            } else {
            	try {
					if (Integer.parseInt(jTextField1.getText()) > 0) {
			           	int input = Integer.parseInt(jTextField1.getText()); 
						System.out.println("Search Complaint Input: "+input);
						try {
							jTable1.setModel(new DefaultTableModel(null, new String [] {
				  	                "Complaint Id", "Customer Id", "Employee Id",
				  	                "Category", "Details", "Date", "Type", "Status"
				              }));
							addRowsToJTableFind(input);
							JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
								  	"Complaint record was found",
								    "Search Complaint Status",
								    JOptionPane.INFORMATION_MESSAGE);
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
								  	"Complaint record not found in database",
								    "Search Complaint Status",
								    JOptionPane.ERROR_MESSAGE);
						}
					} else if (Integer.parseInt(jTextField1.getText()) < 0) {
		           	  JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
						  	"Invalid input.\nId number must not be negative number."
						  	+ "\nPlease try again.",
						    "Search Complaint Status",
						    JOptionPane.WARNING_MESSAGE);
		           	  
		             } else if (Integer.parseInt(jTextField1.getText()) == 0) {
		            	 	JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
							  	"Invalid input.\nId number must not be equal to zero."
							  	+ "\nPlease try again.",
							    "Search Complaint Status",
							    JOptionPane.WARNING_MESSAGE);
		            	
		             } 
				 
	            } catch (NumberFormatException e2) {
	            	JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
	         			  	"You cannot submit letters.\nPlease try again.",
	         			    "Search Complaint Status",
	         			    JOptionPane.ERROR_MESSAGE);
	            	
	            }
            }

		}	
    }                                           

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {                                        
       if (jTextField1.getText().equals("Enter Complaint Id")){
           jTextField1.setText("");
           jTextField1.setForeground(new Color(153,153,153));
       }
    }                                       

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {                                      
       if (jTextField1.getText().equals("")){
           jTextField1.setText("Enter Complaint Id");
           jTextField1.setForeground(new Color(153,153,153));
       }
    }                                     

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//    	jTable2.setModel(new DefaultTableModel(null, new String [] {
//                "Response Id","Complaint Id","Response", "Response"
//       }));
   	   DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

        // get the selected row index
       int selectedRowIndex = jTable1.getSelectedRow();
       
       
       System.out.println("Selected: "+selectedRowIndex);
       
       String compIdStr = model.getValueAt(selectedRowIndex, 0).toString();       
       
       System.out.println("Complaint Id: "+compIdStr);
       
       int compId = Integer.parseInt(compIdStr);
       
       addRowsToJTableLatest(compId);

    }  
    
    JTable jTable2 = new JTable(); 
    
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
  				JOptionPane.showMessageDialog(RepresentativeComplaintsView.this,
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
    
 
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
    }  
    
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
    }  
    
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
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
            java.util.logging.Logger.getLogger(RepresentativeComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepresentativeComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepresentativeComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepresentativeComplaintsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepresentativeComplaintsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration 
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}









