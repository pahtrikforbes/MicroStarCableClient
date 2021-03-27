package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import models.Complaint;
import serverconnector.ServerConnector;
import utils.CustomizedException;

public class ComplaintController {
	
	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private ServerConnector serverConnector;
	private Socket socket;
	private String operation;
	
	public ComplaintController() {
		this.serverConnector = new ServerConnector();
		this.socket = null;
		this.operation = "";
	}


	public int createComplaint(Complaint complaint) throws CustomizedException{
		 int complaintId = -1;
		 //operation that should be done on database
	     operation = "createComplaint";
	    //short lived socket that will carry out the operation
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(complaint);
			 
			 try {
				complaintId = (int)objectInStream.readObject();
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
	   
	   return complaintId;
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
	
	
	/* Method to accept a user id and returns an ArrayList of complaints
	that are tied to that specific User from database through network stream */
	public ArrayList<Complaint> getComplaintsPerUser(int complaintId) throws CustomizedException {
		ArrayList<Complaint> userComplaintList = new ArrayList<>();

	    operation = "getUserComplaints";
	    
	    try {
	    	socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			
			userComplaintList = (ArrayList<Complaint>)objectInStream.readObject();
			socket.close();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return userComplaintList;
	}
	
	
	/* Method to READ one complaint. Returns a single complaint. */
	public Complaint findById(int complaintId) throws CustomizedException {
		
		Complaint complaint = null;
		operation = "findById";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(complaintId);
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
	
	
	/*Method to assign a Technician to a Complaint*/
	public Complaint assignTechnician(Complaint assignComplaint) throws CustomizedException {
		Complaint complaint = null;
		operation = "assignTechnician";
		try {
			socket = this.serverConnector.getSocket();
			initializeStreams();
			objectOutStream.writeObject(operation);
			objectOutStream.writeObject(assignComplaint);
		    complaint =(Complaint)objectInStream.readObject();
		    socket.close();
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
		return complaint;
	}
	
	
	/*Method to delete complaint*/
	public int deleteComplaint(int complaintId) throws CustomizedException {
		int result = -1;
	
	     operation = "deleteComplaint";
	
		try {
			socket = this.serverConnector.getSocket();
			
			 initializeStreams();
			 objectOutStream.writeObject(operation);
			 objectOutStream.writeObject(complaintId);
			 
			 try {
				complaintId = (int)objectInStream.readObject();
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


















