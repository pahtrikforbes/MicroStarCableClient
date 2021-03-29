
package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import utils.CustomizedException;
import models.Account;
import models.Complaint;

public class AccountController {
	
	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private Socket socket;
	private String operation;

	
	public AccountController() {
		this.socket = null;
		this.operation = "";
	}
	
	
//	Method to create a new complaint  
	public int createAccount(Account account) throws CustomizedException {
		int acctId = -1;
		
		operation = "createAccount";
		
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(account);
			 
			 try {
				acctId = (int)objectInStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
			 socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		
		return acctId;
	}
	
	
	
	private void initializeStreams()  throws CustomizedException  {
		try {
			this.objectOutStream = new ObjectOutputStream(socket.getOutputStream());
			this.objectInStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	/* Method to  READ all the complaints returned from database through network stream */
	public ArrayList<Account> getAllAccounts() throws CustomizedException {
		ArrayList<Account> acctList = new ArrayList<>();

	    operation = "getAllAccounts";
	    
	    try {
	    	socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			
			acctList = (ArrayList<Account>)objectInStream.readObject();
			socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return acctList;
	}
	
	
	/* Method to  READ one complaint. Returns a single complaint. */
	public Account findById(int complaintID) throws CustomizedException {
		
		Account account = null;
		operation = "findById";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(complaintID);
			account = (Account)objectInStream.readObject();
		    socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return account;
	}
	

	/*Method to UPDATE a complaint*/
	public Account updateAccount(Account updatedAccount) throws CustomizedException {
		Account account = null;
		operation = "updateAccount";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(updatedAccount);
			account =(Account)objectInStream.readObject();
		    socket.close();
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return account;
	}
	
	
	/*Method to delete a complaint*/
	public int deleteAccount(int accountID) throws CustomizedException {
		int result = -1;
	
	     operation = "deleteAccount";
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(accountID);
			 
			 try {
				 result = (int)objectInStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
			 socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	   return result;
	}
}
