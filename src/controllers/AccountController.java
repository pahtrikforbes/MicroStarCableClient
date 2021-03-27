package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import models.Account;
import models.User;
import serverconnector.ServerConnector;
import utils.CustomizedException;

public class AccountController{
	
	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private ServerConnector serverConnector;
	private Socket socket;
	private String operation;
	private String endPoint;
	
	
	public AccountController() {
		
		this.serverConnector = new ServerConnector();
		this.socket = null;
		this.operation = "";
		this.endPoint = "";
	}
	
	
	public int createAccount(Account account) throws CustomizedException{
		
		int acctId = -1;
		
		//operation that should be done on database
		operation = "createAccount";
		//short lived socket that will carry out the operation
		
		try {
			socket = this.serverConnector.getSocket();
			
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(account);
			
			try {
				acctId = (int)objectInStream.readObject();
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
			socket.close();
		}catch (IOException e) {
			
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		return acctId;
	}
	
	
	private void initializeStreams() throws CustomizedException {
		
		try {
			this.objectOutStream = new ObjectOutputStream(socket.getOutputStream());
			this.objectInStream = new ObjectInputStream(socket.getInputStream());
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//Method to read all the accts returned from the database through the network stream
	
	@SuppressWarnings("unchecked") 
	public ArrayList<Account> getAllAccounts() throws CustomizedException {
		ArrayList<Account> accountList = new ArrayList<>();

	    operation = "getAllAccountss";
	    
	    try {
	    	socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			
			accountList = (ArrayList<Account>)objectInStream.readObject();
			socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return accountList;
	}
	
	
	/* Method to  read one acct. Returns a single acct. */
	public Account findById(int acctId) throws CustomizedException {
		
		Account account = null;
		operation = "findById";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(acctId);
		    account = (Account)objectInStream.readObject();
		    socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return account;
	}
	
	
	/*Method to update an account*/
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
	
	
	/*Method to delete account*/
	public int deleteAccount(int acctId) throws CustomizedException {
		int result = -1;
	
	     operation = "deleteAccount";
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(acctId);
			 
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
	   return result;
	}
	
	
	
}