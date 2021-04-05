package controllers;

import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import models.User;
import utils.CustomizedException;

public class UserController {
	
	private Client client;
	
	
	public UserController() {
		
		this.client = new Client();
	}

	public int createUser(User user) throws CustomizedException{
		 int userId = -1;
		 client.setOperation("createUser");
		 client.setEndPoint("user");
		try {
			
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(user);
			 try {
				userId = (int)client.getObjectInStream().readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	   
	   return userId;
	}
		
	/* Method to  READ all the users returned from database through network stream */
	public ArrayList<User> getAllUsers() throws CustomizedException {
		ArrayList<User> userList = new ArrayList<>();

		 client.setOperation("getAllUsers");
		 client.setEndPoint("user");
	    
	    try {
	    	
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			userList = (ArrayList<User>)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return userList;
	}
	
	
	/* Method to  READ one user. Returns a single user. */
	public User findById(int userId) throws CustomizedException {
		
		User user = null;
		client.setOperation("findById");
		client.setEndPoint("user");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			
		    user = (User)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return user;
	}
	

	/* Method to  READ one user. Returns a single user. */
	public boolean findByEmail(String email) throws CustomizedException {
		boolean userFound = false;
		client.setOperation("findByEmail");
		client.setEndPoint("user");
		try {
		    
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(email);
		    userFound =(boolean)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			 throw new CustomizedException(e.getMessage());
		}
		
		return userFound ;
	}
	

	/*Method to UPDATE a user*/
	public User updateUser(User updatedUser) throws CustomizedException {
		User user = null;
		client.setOperation("updateUser");
		client.setEndPoint("user");
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedUser);
		    user = (User)client.getObjectInStream().readObject();
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return user;
	}
	
	
	/*Method to delete user*/
	public int deleteUser(int userId) throws CustomizedException {
		int result = -1;
		client.setOperation("deleteUser");
		client.setEndPoint("user");
	
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			client.getObjectOutStream().writeObject(userId);
			 
			 try {
				userId = (int)client.getObjectInStream().readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	   return result;
	}
	
}
