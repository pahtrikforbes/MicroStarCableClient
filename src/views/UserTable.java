package views;

import javax.swing.table.DefaultTableModel;

public class UserTable extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columns;
	private Object[][] rows;
	
	
	public UserTable() {
		super();
       this.columns = new String[] {"hello"};
       this.rows = new Object[][] {new String[] {"Kathy"}}; 
	}
	

	
}
