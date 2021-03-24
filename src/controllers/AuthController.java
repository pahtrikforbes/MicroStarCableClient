package controllers;

import utils.CustomizedException;

import utils.Role;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import models.User;
import serverconnector.ServerConnector;
/*This class will isolate the logic for authentication and updating password.*/
public class AuthController {

	private UserController userController;
	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private ServerConnector serverConnector;
	private Socket socket;
	private String operation;
	
	public AuthController() {
		this.userController = new UserController();
		this.serverConnector = new ServerConnector();
		this.socket = null;
		this.operation = "";
	}
	
	public boolean login(int userId,String password, Role role) throws CustomizedException {
		
	    boolean loggedIn = false;
	    
	    operation = "login";
	    try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(userId);
			objectOutStream.writeObject(password);
			objectOutStream.writeObject(role);
			
			try {
				loggedIn = (boolean)objectInStream.readObject();
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
		
	    return loggedIn;
	}
	
	public boolean updatePassword(int userId,String oldPassword,String newPassword) throws CustomizedException {
		boolean passwordUpdated = false;
		operation = "updatePassword";

		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(userId);
			objectOutStream.writeObject(oldPassword);
			objectOutStream.writeObject(newPassword);
			
			try {
				passwordUpdated = (boolean)objectInStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return passwordUpdated;
	}
	
	public int register(User user) throws CustomizedException {
		
		int userId = -1;
		
		try {
			
			userId = this.userController.createUser(user);
		} catch (CustomizedException e) {
			// TODO Auto-generated catch block
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
}
