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
		this.client.setEndPoint("user");
	}

	public int createUser(User user) throws CustomizedException{
		 int userId = -1;
		 client.setOperation("createUser");
		
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(user);
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				userId = (int)client.getObjectInStream().readObject();
			
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				userId = -1;
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
	   
	   return userId;
	}
		
	/* Method to  READ all the users returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllUsers() throws CustomizedException {
		ArrayList<User> userList = new ArrayList<>();

		 client.setOperation("getAllUsers");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			 String success = (String)client.getObjectInStream().readObject();
				
				if(success.equalsIgnoreCase("success")) {
					userList = (ArrayList<User>)client.getObjectInStream().readObject();
				}
				else {
					CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
					throw new CustomizedException(e.getMessage());
				}
			} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return userList;
	}
	
	
	/* Method to  READ all the users returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllTechnicians() throws CustomizedException {
		ArrayList<User> userList = new ArrayList<>();

		 client.setOperation("getAllTechnicians");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			 String success = (String)client.getObjectInStream().readObject();
				
				if(success.equalsIgnoreCase("success")) {
					userList = (ArrayList<User>)client.getObjectInStream().readObject();
				}
				else {
					CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
					throw new CustomizedException(e.getMessage());
				}
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
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
			    user = (User)client.getObjectInStream().readObject();
				client.getObjectOutStream().flush();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		
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

		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(email);

			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				 userFound =(boolean)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		   
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
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedUser);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				 user = (User)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new CustomizedException(e.getMessage());
		}
		
		return user;
	}
	
	
	/*Method to delete user*/
	public int deleteUser(int userId) throws CustomizedException {
		int result = -1;
		client.setOperation("deleteUser");
	
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			 
			String success = (String)client.getObjectInStream().readObject();
			if(success.equalsIgnoreCase("success")) {
				userId = (int)client.getObjectInStream().readObject();
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
