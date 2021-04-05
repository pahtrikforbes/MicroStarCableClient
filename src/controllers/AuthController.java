 package controllers;

import utils.CustomizedException;

import utils.Role;
import java.io.IOException;
import java.net.UnknownHostException;
import client.Client;
import models.User;

/*This class will isolate the logic for authentication and updating password.*/
public class AuthController {

	private Client client;
	private UserController userController;
	public AuthController() {
		this.client = new Client();
		this.client.setEndPoint("auth");
	}
	
	public boolean login(int userId,String password, Role role) throws CustomizedException {
		
	    boolean loggedIn = false;
	    client.setOperation("login");
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			client.getObjectOutStream().writeObject(password);
			client.getObjectOutStream().writeObject(role);
			
			String success = (String)client.getObjectInStream().readObject();
			
			  if(success.equalsIgnoreCase("success")) { 
				  loggedIn =  (boolean) client.getObjectInStream().readObject();
			} else {
			  CustomizedException e = (CustomizedException)client.getObjectInStream().readObject(); 
			  loggedIn = false; 
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
		
	    return loggedIn;
	}
	
	public boolean updatePassword(int userId,String oldPassword,String newPassword) throws CustomizedException {
		boolean passwordUpdated = false;
		 client.setOperation("updatePassword");

		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			client.getObjectOutStream().writeObject(oldPassword);
			client.getObjectOutStream().writeObject(newPassword);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				passwordUpdated = (boolean)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				passwordUpdated = false;
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e1.getMessage());
		}
		return passwordUpdated;
	}
	
	public int register(User user) throws CustomizedException {
		
		int userId = -1;
		try {
			 userController = new UserController();
			userId = userController.createUser(user);
			
		} catch (CustomizedException e) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e.getMessage());
		}
		return userId;
	}
	
}
