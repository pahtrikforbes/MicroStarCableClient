package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import client.Client;
import models.Complaint;
import serverconnector.ServerConnector;
import utils.CustomizedException;

public class ComplaintController {
	
	private Client client;
	
	public ComplaintController() {
		this.client = new Client();
	}


	public int createComplaint(Complaint complaint) throws CustomizedException{
		 int complaintId = -1;
		 client.setOperation("createComplaint");
		 client.setEndPoint("complaint");
		 
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(complaint);
			 try {
				complaintId = (int)client.getObjectInStream().readObject();
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
	   
	   return complaintId;
	}


		
//	*************************************************************************	


	
	/* Method to  READ all the complaints returned from database through network stream */
	public ArrayList<Complaint> getAllComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllComplaints");
		 client.setEndPoint("complaint");
	    
	    try {
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
//	*************************************************************************	

	
	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllMildComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllMildComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
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
	    
	    return complaintList;
	}
	
	
//	*************************************************************************	

	
	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllModerateComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllModerateComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
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
	    
	    return complaintList;
	}
	
//	*************************************************************************	


	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllSevereComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllSevereComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
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
	    
	    return complaintList;
	}
	
	
//	*************************************************************************	

	
	/* Method to accept a user id and returns an ArrayList of complaints
	that are tied to that specific User from database through network stream */
	public ArrayList<Complaint> getComplaintsPerUser(int complaintId) throws CustomizedException {
		ArrayList<Complaint> userComplaintList = new ArrayList<>();

		 client.setOperation("getAllUserComplaints");
		 client.setEndPoint("complaint");
	    
	    try {
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			userComplaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return userComplaintList;
	}
	
	
//	*************************************************************************	

	
	/* Method to READ one complaint. Returns a single complaint. */
	public Complaint findById(int complaintId) throws CustomizedException {
		
		Complaint complaint = null;
		client.setOperation("findById");
		client.setEndPoint("complaint");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(complaintId);
			
		    complaint = (Complaint)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return complaint;
	}
	

//	*************************************************************************	

	
	/*Method to UPDATE a complaint*/
	public Complaint updateComplaint(Complaint updatedComplaint) throws CustomizedException {
		Complaint complaint = null;
		client.setOperation("updateComplaint");
		client.setEndPoint("complaint");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedComplaint);
		    complaint = (Complaint)client.getObjectInStream().readObject();
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return complaint;
	}

	
//	*************************************************************************	

	
	
	/*Method to assign a Technician to a Complaint*/
	public Complaint assignTechnician(Complaint assignComplaint) throws CustomizedException {
		Complaint complaint = null;
		
		client.setOperation("assignTechnician");
		client.setEndPoint("complaint");
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(assignComplaint);
		    complaint = (Complaint)client.getObjectInStream().readObject();
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
		return complaint;
	}
	
	
//	*************************************************************************	
	
	/*Method to delete complaint*/
	public int deleteComplaint(int complaintId) throws CustomizedException {
		int result = -1;
		client.setOperation("deleteComplaint");
		client.setEndPoint("complaint");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			client.getObjectOutStream().writeObject(complaintId);
			 
			 
			 try {
				 complaintId = (int)client.getObjectInStream().readObject();
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


















