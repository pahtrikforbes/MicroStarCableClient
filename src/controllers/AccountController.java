package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import serverconnector.ServerConnector;
import utils.CustomizedException;
import models.Complaint;

public class AccountController {
	
	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private ServerConnector serverConnector;
	private Socket socket;
	private String operation;

	
	public AccountController() {
		this.serverConnector = new ServerConnector();
		this.socket = null;
		this.operation = "";
	}
	
	
//	Method to create a new complaint  
	public int createComplaint(Complaint complaint) throws CustomizedException {
		int complaintID = -1;
		
		operation = "createComplaint";
		
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(complaint);
			 
			 try {
				complaintID = (int)objectInStream.readObject();
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
		
		
		return complaintID;
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
	public ArrayList<Complaint> getAllComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

	    operation = "getAllComplaints";
	    
	    try {
	    	socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			
			complaintList = (ArrayList<Complaint>)objectInStream.readObject();
			socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
	
	/* Method to  READ one complaint. Returns a single complaint. */
	public Complaint findById(int complaintID) throws CustomizedException {
		
		Complaint complaint = null;
		operation = "Find By Id";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(complaintID);
		    complaint = (Complaint)objectInStream.readObject();
		    socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return complaint;
	}
	

	/*Method to UPDATE a complaint*/
	public Complaint updateComplaint(Complaint updatedComplaint) throws CustomizedException {
		Complaint complaint = null;
		operation = "updateComplaint";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(updatedComplaint);
		    complaint =(Complaint)objectInStream.readObject();
		    socket.close();
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return complaint;
	}
	
	
	/*Method to delete a complaint*/
	public int deleteComplaint(int complaintID) throws CustomizedException {
		int result = -1;
	
	     operation = "deleteComplaint";
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(complaintID);
			 
			 try {
				complaintID = (int)objectInStream.readObject();
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
