package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import models.User;
import serverconnector.ServerConnector;
import utils.CustomizedException;

public class UserController {
	
	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private ServerConnector serverConnector;
	private Socket socket;
	private String operation;
	private String endPoint;
	
	public UserController() {
		this.serverConnector = new ServerConnector();
		this.socket = null;
		this.operation = "";
		this.endPoint = "user";
	}

	


	public int createUser(User user) throws CustomizedException{
		 int userId = -1;
		 //operation that should be done on database
	     operation = "createUser";
	    //short lived socket that will carry out the operation
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(endPoint);
			 objectOutStream.writeObject(user);
			 
			 try {
				userId = (int)objectInStream.readObject();
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
	   
	   return userId;
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
	
	
	
	/* Method to  READ all the users returned from database through network stream */
	public ArrayList<User> getAllUsers() throws CustomizedException {
		ArrayList<User> userList = new ArrayList<>();

	    operation = "getAllUsers";
	    
	    try {
	    	socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(endPoint);
			userList = (ArrayList<User>)objectInStream.readObject();
			socket.close();
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
		operation = "findById";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(endPoint);
			objectOutStream.writeObject(userId);
		    user = (User)objectInStream.readObject();
		    socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return user;
	}
	

	/* Method to  READ one user. Returns a single user. */
	public boolean findByEmail(String email) throws CustomizedException {
		
		operation = "findByEmail";
		try {
		    
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(endPoint);
			objectOutStream.writeObject(email);
		    boolean userFound =(boolean)objectInStream.readObject();
		   socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			 throw new CustomizedException(e.getMessage());
		}
		
		return true;
	}
	

	/*Method to UPDATE a user*/
	public User updateUser(User updatedUser) throws CustomizedException {
		User user = null;
		operation = "updateUser";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(endPoint);
			objectOutStream.writeObject(updatedUser);
		    user =(User)objectInStream.readObject();
		    socket.close();
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
	
	     operation = "deleteUser";
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(endPoint);
			 objectOutStream.writeObject(userId);
			 
			 try {
				userId = (int)objectInStream.readObject();
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
