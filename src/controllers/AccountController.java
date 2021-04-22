package controllers;

import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import utils.CustomizedException;
import models.Account;

public class AccountController {
	
	private Client client;
	
	public AccountController() {
		this.client = new Client();
		this.client.setEndPoint("account");
	}
	
//	Method to create a new account 
	public int createAccount(Account account) throws CustomizedException {
		int acctId = -1;
		
		client.setOperation("createAccount");
		try {
			client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(account);
			 
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				acctId = (int)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e1) {
			throw new CustomizedException(e1.getMessage());
		}
		return acctId;
	}
	
	/* Method to  READ all the accounts returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Account> getAllAccounts() throws CustomizedException {
		ArrayList<Account> acctList = new ArrayList<>();
		client.setOperation("getAllAccounts");
	    try {	
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				acctList = (ArrayList<Account>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e1.getMessage());
		}
	    
	    return acctList;
	}
	
	
	/* Method to  READ one account. Returns a single account. */
	public Account findById(int accountId) throws CustomizedException {
		
		Account account = null;
		client.setOperation("findById");
		try {
			client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(accountId);
		
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				account = (Account)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e1.getMessage());
		}
		
		return account;
	}
	

	/*Method to UPDATE a complaint*/
	public Account updateAccount(Account updatedAccount) throws CustomizedException {
		Account account = null;
		client.setOperation("updateAccount");
		
		try {
			client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedAccount);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				account = (Account)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return account;
	}
	
	
	/*Method to delete an account*/
	public int deleteAccount(int accountID) throws CustomizedException {
		int result = -1;
	
		client.setOperation("deleteAccount");
		try {
			client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(accountID);
			 
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				result = (int)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e1.getMessage());
		}
	   return result;
	}
}
